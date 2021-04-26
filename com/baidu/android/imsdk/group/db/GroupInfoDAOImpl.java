package com.baidu.android.imsdk.group.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.db.DBGroupTableManager;
import com.baidu.android.imsdk.db.DBOperation;
import com.baidu.android.imsdk.db.DBOperationFactory;
import com.baidu.android.imsdk.db.DBResponseCode;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.IResultParse;
import com.baidu.android.imsdk.db.ITransaction;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GroupInfoDAOImpl {
    public static final String TAG = "GroupInfoDAOImpl";
    public static GroupInfoParse sGroupInfoParse = new GroupInfoParse();

    /* loaded from: classes.dex */
    public static class GroupInfoParse implements IResultParse<GroupInfo> {
        public GroupInfoParse() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.android.imsdk.db.IResultParse
        public GroupInfo onParse(Cursor cursor) {
            if (cursor == null) {
                return null;
            }
            String string = cursor.getString(cursor.getColumnIndex("group_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("group_name"));
            int i2 = cursor.getInt(cursor.getColumnIndex("group_type"));
            int i3 = cursor.getInt(cursor.getColumnIndex("state"));
            long j = cursor.getLong(cursor.getColumnIndex("create_time"));
            long j2 = cursor.getLong(cursor.getColumnIndex("bduid"));
            long j3 = cursor.getLong(cursor.getColumnIndex("uk"));
            int i4 = cursor.getInt(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_USER_NUM));
            long j4 = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_VERSION));
            int i5 = cursor.getInt(cursor.getColumnIndex("disturb"));
            int i6 = cursor.getInt(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF));
            String string3 = cursor.getString(cursor.getColumnIndex("description"));
            int i7 = cursor.getInt(cursor.getColumnIndex("marktop"));
            long j5 = cursor.getLong(cursor.getColumnIndex("marktoptime"));
            GroupInfo groupInfo = new GroupInfo(string);
            groupInfo.setGroupName(string2);
            groupInfo.setType(i2);
            groupInfo.setState(i3);
            groupInfo.setCreateTime(j);
            groupInfo.setBuid(j2);
            groupInfo.setUk(j3);
            groupInfo.setNum(i4);
            groupInfo.setMembersVersion(j4);
            groupInfo.setDisturb(i5);
            groupInfo.setBrief(i6);
            groupInfo.setHeadUrl(string3);
            groupInfo.setMarkTopTime(j5);
            groupInfo.setMarkTop(i7);
            return groupInfo;
        }
    }

    public static int activeGroupState(Context context, String str) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
            if (dBGroupTableManager.isExistGroupTable(context, str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_ACTIVE_STATE, (Integer) 1);
                int intValue = newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
                if (intValue > 0) {
                    dBGroupTableManager.activeGroup(str);
                    return intValue;
                }
                return intValue;
            }
            return DBResponseCode.ERROR_GROUP_NOT_EXIST;
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static long addMemberToGroup(Context context, String str, List<GroupMember> list) {
        if (context == null || TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return -7001L;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                ArrayList arrayList = new ArrayList();
                for (GroupMember groupMember : list) {
                    ContentValues groupMemberCv = getGroupMemberCv(groupMember);
                    if (groupMemberCv != null) {
                        arrayList.add(groupMemberCv);
                    }
                }
                List<Long> insert = newDb.insert("groupmember", arrayList);
                return (insert == null || insert.size() <= 0) ? -7100L : insert.get(0).longValue();
            }
            return -7008L;
        }
        return -70003L;
    }

    public static void clearGroupMarkTop(Context context) {
        DBOperation newDb;
        if (context == null || (newDb = DBOperationFactory.getNewDb(context)) == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("marktop", (Integer) 0);
        newDb.update("groupinfo", contentValues, "marktop = ? ", new String[]{String.valueOf(1)});
    }

    public static int createGroup(Context context, String str) {
        DBGroupTableManager dBGroupTableManager;
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            final String sqlCreateTableGroupMessage = DBTableDefine.getSqlCreateTableGroupMessage(str);
            final ContentValues contentValues = new ContentValues();
            contentValues.put("group_id", str);
            int intValue = newDb.execTransaction(new ITransaction() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.1
                @Override // com.baidu.android.imsdk.db.ITransaction
                public void execTransaction(SQLiteDatabase sQLiteDatabase) {
                    sQLiteDatabase.execSQL(sqlCreateTableGroupMessage);
                    long insert = sQLiteDatabase.insert("groupinfo", null, contentValues);
                    LogUtils.d(GroupInfoDAOImpl.TAG, "insertret : " + insert);
                }
            }).intValue();
            LogUtils.d(TAG, "STAR create star group " + intValue + " " + str);
            if (intValue != 0 || (dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)) == null) {
                return intValue;
            }
            String groupMessageTableName = DBTableDefine.getGroupMessageTableName(str);
            LogUtils.d(TAG, "STAR add group table " + groupMessageTableName);
            dBGroupTableManager.addGroupTable(groupMessageTableName);
            return intValue;
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int delGroupMember(Context context, String str, ArrayList<String> arrayList) {
        if (context == null || arrayList == null || arrayList.size() == 0) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        LogUtils.d("GroupInfoDAOIMPL", "delGroupMember " + arrayList.toString());
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            String str2 = " ( " + arrayList.get(0);
            for (int i2 = 1; i2 < arrayList.size(); i2++) {
                str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + arrayList.get(i2);
            }
            return newDb.delete("groupmember", "group_id = ? AND bduid in " + (str2 + " ) "), new String[]{str}).intValue();
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int deletedGroupMember(Context context, String str) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 1);
            return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static ArrayList<GroupInfo> getAllGroupInfo(Context context) {
        DBOperation newDb;
        if (context == null || (newDb = DBOperationFactory.getNewDb(context)) == null) {
            return null;
        }
        return newDb.query(sGroupInfoParse, "groupinfo", null, null, null, null, null, null, null);
    }

    public static ArrayList<String> getAllGroupList(Context context) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            return newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public String onParse(Cursor cursor) {
                    return cursor.getString(cursor.getColumnIndex("group_id"));
                }
            }, "groupinfo", new String[]{"group_id"}, "state = 0 AND group_type != 2 AND state != 1", null, null, null, "create_time DESC", null);
        }
        return null;
    }

    public static ArrayList<GroupInfo> getGroupInfo(Context context, ArrayList<String> arrayList) {
        DBOperation newDb;
        if (context == null || arrayList == null || arrayList.size() == 0 || (newDb = DBOperationFactory.getNewDb(context)) == null) {
            return null;
        }
        String str = " ( " + arrayList.get(0);
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            str = str + StringUtil.ARRAY_ELEMENT_SEPARATOR + arrayList.get(i2);
        }
        String str2 = str + " ) ";
        return newDb.query(sGroupInfoParse, "groupinfo", null, "group_id in " + str2, null, null, null, null, null);
    }

    public static ContentValues getGroupInfoCv(GroupInfo groupInfo) {
        if (groupInfo == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("bduid", Long.valueOf(groupInfo.getBuid()));
        contentValues.put("uk", Long.valueOf(groupInfo.getUk()));
        contentValues.put("group_id", groupInfo.getGroupId());
        contentValues.put("group_name", groupInfo.getGroupName());
        contentValues.put("create_time", Long.valueOf(groupInfo.getCreateTime()));
        contentValues.put("group_type", Integer.valueOf(groupInfo.getType()));
        contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_NUM, Integer.valueOf(groupInfo.getNum()));
        contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_VERSION, Long.valueOf(groupInfo.getMembersVersion()));
        contentValues.put("state", Integer.valueOf(groupInfo.getState()));
        contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, Integer.valueOf(groupInfo.getBrief()));
        contentValues.put("description", groupInfo.getHeadUrl());
        return contentValues;
    }

    public static ArrayList<String> getGroupList(Context context, boolean z, int i2, int i3) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        String str = null;
        if (newDb != null) {
            String str2 = "active_state = 1";
            if (z) {
                str2 = "active_state = 1 AND state = 0";
            }
            String str3 = str2 + " AND group_type != 2";
            if (i2 > 0) {
                str = String.valueOf(i2);
                if (i3 > 0) {
                    str = str + " offset " + i3;
                }
            }
            return newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public String onParse(Cursor cursor) {
                    return cursor.getString(cursor.getColumnIndex("group_id"));
                }
            }, "groupinfo", new String[]{"group_id"}, str3, null, null, null, "create_time DESC", str);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x008b, code lost:
        if (r15 == 0) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<GroupMember> getGroupMember(Context context, String str, ArrayList<String> arrayList, int i2) {
        ArrayList<GroupMember> arrayList2;
        String str2;
        String str3;
        String str4;
        GroupMember groupMember = null;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            String str5 = "";
            if (arrayList == null || arrayList.size() <= 0) {
                str2 = "";
            } else {
                String str6 = " AND ( bduid = " + arrayList.get(0);
                for (int i3 = 1; i3 < arrayList.size(); i3++) {
                    str6 = str6 + " OR bduid = " + arrayList.get(i3);
                }
                str2 = str6 + " ) ";
            }
            if (i2 < 0) {
                str5 = "join_time DESC ";
                str3 = String.valueOf(Math.abs(i2));
            } else {
                if (i2 > 0) {
                    str3 = String.valueOf(i2);
                } else {
                    str3 = null;
                }
                str4 = "join_time ASC  ";
                arrayList2 = newDb.query(new IResultParse<GroupMember>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.5
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.android.imsdk.db.IResultParse
                    public GroupMember onParse(Cursor cursor) {
                        String string = cursor.getString(cursor.getColumnIndex("group_id"));
                        long j = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME));
                        int i4 = cursor.getInt(cursor.getColumnIndex("role"));
                        String string2 = cursor.getString(cursor.getColumnIndex("name"));
                        String string3 = cursor.getString(cursor.getColumnIndex("nickname"));
                        long j2 = cursor.getLong(cursor.getColumnIndex("bduid"));
                        long j3 = cursor.getLong(cursor.getColumnIndex("uk"));
                        int i5 = cursor.getInt(cursor.getColumnIndex("status"));
                        GroupMember groupMember2 = new GroupMember(string, j3, string2, j2, i4, j);
                        groupMember2.setValid(i5);
                        groupMember2.setNickName(string3);
                        return groupMember2;
                    }
                }, "groupmember", null, "group_id = ? " + str2, new String[]{str}, null, null, str4, str3);
            }
            str4 = str5;
            arrayList2 = newDb.query(new IResultParse<GroupMember>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.5
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public GroupMember onParse(Cursor cursor) {
                    String string = cursor.getString(cursor.getColumnIndex("group_id"));
                    long j = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME));
                    int i4 = cursor.getInt(cursor.getColumnIndex("role"));
                    String string2 = cursor.getString(cursor.getColumnIndex("name"));
                    String string3 = cursor.getString(cursor.getColumnIndex("nickname"));
                    long j2 = cursor.getLong(cursor.getColumnIndex("bduid"));
                    long j3 = cursor.getLong(cursor.getColumnIndex("uk"));
                    int i5 = cursor.getInt(cursor.getColumnIndex("status"));
                    GroupMember groupMember2 = new GroupMember(string, j3, string2, j2, i4, j);
                    groupMember2.setValid(i5);
                    groupMember2.setNickName(string3);
                    return groupMember2;
                }
            }, "groupmember", null, "group_id = ? " + str2, new String[]{str}, null, null, str4, str3);
        } else {
            arrayList2 = null;
        }
        if (arrayList2 != null) {
            int i4 = 0;
            while (true) {
                if (i4 >= arrayList2.size()) {
                    break;
                }
                GroupMember groupMember2 = arrayList2.get(i4);
                if (1 == groupMember2.getRole()) {
                    arrayList2.remove(i4);
                    groupMember = groupMember2;
                    break;
                }
                i4++;
            }
            if (groupMember != null) {
                arrayList2.add(0, groupMember);
            }
        }
        return arrayList2;
    }

    public static ContentValues getGroupMemberCv(GroupMember groupMember) {
        if (groupMember == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_id", groupMember.getGroupid());
        contentValues.put(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME, Long.valueOf(groupMember.getJointime()));
        contentValues.put("role", Integer.valueOf(groupMember.getRole()));
        contentValues.put("bduid", Long.valueOf(groupMember.getBduid()));
        contentValues.put("uk", Long.valueOf(groupMember.getUk()));
        contentValues.put("nickname", groupMember.getNickName());
        contentValues.put("status", Integer.valueOf(groupMember.getValid()));
        return contentValues;
    }

    public static ArrayList<Long> getGroupMemberId(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = (" AND ( role != 1") + " ) ";
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            return newDb.query(new IResultParse<Long>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public Long onParse(Cursor cursor) {
                    return Long.valueOf(cursor.getLong(cursor.getColumnIndex("bduid")));
                }
            }, "groupmember", new String[]{"bduid"}, "group_id = ? " + str2, new String[]{str}, null, null, null, null);
        }
        return null;
    }

    public static ArrayList<GroupMember> getMemberNickname(Context context, String str) {
        DBOperation newDb;
        if (context == null || TextUtils.isEmpty(str) || (newDb = DBOperationFactory.getNewDb(context)) == null) {
            return null;
        }
        return newDb.query(new IResultParse<GroupMember>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.android.imsdk.db.IResultParse
            public GroupMember onParse(Cursor cursor) {
                String string = cursor.getString(cursor.getColumnIndex("group_id"));
                long j = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME));
                int i2 = cursor.getInt(cursor.getColumnIndex("role"));
                String string2 = cursor.getString(cursor.getColumnIndex("name"));
                String string3 = cursor.getString(cursor.getColumnIndex("nickname"));
                long j2 = cursor.getLong(cursor.getColumnIndex("bduid"));
                long j3 = cursor.getLong(cursor.getColumnIndex("uk"));
                int i3 = cursor.getInt(cursor.getColumnIndex("status"));
                GroupMember groupMember = new GroupMember(string, j3, string2, j2, i2, j);
                groupMember.setValid(i3);
                groupMember.setNickName(string3);
                return groupMember;
            }
        }, "groupmember", null, "group_id = ? ", new String[]{str}, null, null, null, null);
    }

    public static String getNickName(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            ArrayList query = newDb != null ? newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public String onParse(Cursor cursor) {
                    return cursor.getString(cursor.getColumnIndex("nickname"));
                }
            }, "groupmember", new String[]{"nickname"}, "group_id = ?  AND bduid = ? ", new String[]{str, str2}, null, null, null, null) : null;
            if (query != null && query.size() > 0) {
                return (String) query.get(0);
            }
        }
        return null;
    }

    public static ArrayList<String> getStarGroupList(Context context) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            return newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public String onParse(Cursor cursor) {
                    return cursor.getString(cursor.getColumnIndex("group_id"));
                }
            }, "groupinfo", new String[]{"group_id"}, null, null, null, null, "create_time DESC", null);
        }
        return null;
    }

    public static int hasMemberInGroup(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            ArrayList query = newDb != null ? newDb.query(new IResultParse<Long>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public Long onParse(Cursor cursor) {
                    return Long.valueOf(cursor.getLong(cursor.getColumnIndex("bduid")));
                }
            }, "groupmember", new String[]{"bduid"}, "group_id = ? ", new String[]{str}, null, null, null, null) : null;
            if (query != null) {
                return query.size();
            }
        }
        return 0;
    }

    public static boolean isExistGroup(Context context, String str) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        LogUtils.e(TAG, "operation : " + newDb);
        if (newDb != null) {
            DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
            if (dBGroupTableManager == null) {
                dBGroupTableManager = new DBGroupTableManager();
                newDb.setTag(DBGroupTableManager.KEY, dBGroupTableManager);
            }
            return dBGroupTableManager.isExistGroupTable(context, str);
        }
        return false;
    }

    public static int modifyGroupMemberNumber(Context context, String str, int i2) {
        if (context == null || TextUtils.isEmpty(str) || i2 < 0) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_NUM, Integer.valueOf(i2));
            return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int modifyGroupMemberVersion(Context context, String str, long j) {
        if (context == null || TextUtils.isEmpty(str) || j < 0) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_VERSION, Long.valueOf(j));
            return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int modifyGroupName(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || str2 == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        ConversationManagerImpl.getInstance(context).updateConversationName(str2, 1, String.valueOf(str));
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("group_name", str2);
            return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int quitGroup(Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        int i2 = DBResponseCode.ERROR_DB_OPEN;
        if (newDb != null) {
            i2 = newDb.execTransaction(new ITransaction() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.10
                @Override // com.baidu.android.imsdk.db.ITransaction
                public void execTransaction(SQLiteDatabase sQLiteDatabase) {
                    sQLiteDatabase.delete("groupinfo", "group_id = ? ", new String[]{str});
                    sQLiteDatabase.delete("groupmember", "group_id = ? ", new String[]{str});
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBTableDefine.getGroupMessageTableName(str));
                }
            }).intValue();
            DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
            if (dBGroupTableManager != null) {
                String groupMessageTableName = DBTableDefine.getGroupMessageTableName(str);
                LogUtils.d(TAG, "STAR quit group");
                dBGroupTableManager.quitGroupTable(groupMessageTableName);
                dBGroupTableManager.deactiveGroup(str);
            }
        }
        return i2;
    }

    public static int setAllStarDisturbDefault(Context context) {
        if (context == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("disturb", (Integer) 1);
            return newDb.update("groupinfo", contentValues, "group_type = ? ", new String[]{"2"}).intValue();
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int setGroupDisturb(Context context, String str, int i2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("disturb", Integer.valueOf(i2));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_GROUP_NOT_EXIST;
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int setGroupPermit(Context context, String str, int i2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, Integer.valueOf(i2));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_GROUP_NOT_EXIST;
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int setGroupState(Context context, String str, int i2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", Integer.valueOf(i2));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_GROUP_NOT_EXIST;
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int setGroupType(Context context, String str, int i2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_type", Integer.valueOf(i2));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_GROUP_NOT_EXIST;
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int updateGroupInfo(Context context, GroupInfo groupInfo) {
        if (context == null || groupInfo == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            return (!((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, groupInfo.getGroupId()) ? createGroup(context, groupInfo.getGroupId()) : 0) >= 0 ? newDb.update("groupinfo", getGroupInfoCv(groupInfo), "group_id = ? ", new String[]{groupInfo.getGroupId()}).intValue() : DBResponseCode.ERROR_DB_OPEN;
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int updateGroupInfoMarkTop(Context context, long j, int i2, long j2) {
        if (context == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, String.valueOf(j))) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("marktop", Integer.valueOf(i2));
                contentValues.put("marktoptime", Long.valueOf(j2));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{String.valueOf(j)}).intValue();
            }
            return DBResponseCode.ERROR_GROUP_NOT_EXIST;
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static void updateGroupListMarkTop(Context context, List<ChatSession> list) {
        clearGroupMarkTop(context);
        if (list != null) {
            for (ChatSession chatSession : list) {
                updateGroupMarkTop(context, chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
            }
        }
    }

    public static void updateGroupMarkTop(Context context, long j, int i2, long j2) {
        updateGroupInfoMarkTop(context, j, i2, j2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("marktop", Integer.valueOf(i2));
        contentValues.put("marktoptime", Long.valueOf(j2));
        ChatMessageDBManager.getInstance(context).updateChatSession("contacter=?", new String[]{String.valueOf(j)}, contentValues);
    }

    public static int updateGroupMemberRole(Context context, String str, String str2, int i2) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("role", Integer.valueOf(i2));
            return newDb.update("groupmember", contentValues, "group_id = ? AND bduid = ? ", new String[]{str, str2}).intValue();
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int updateMasterAsCommon(Context context, String str, int i2) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("role", Integer.valueOf(i2));
            return newDb.update("groupmember", contentValues, "group_id = ? AND role = 2 ", new String[]{str}).intValue();
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int updateMemberNickName(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nickname", str3);
            return newDb.update("groupmember", contentValues, "group_id = ? AND bduid = ?", new String[]{str, str2}).intValue();
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }

    public static int updateMemberToGroup(Context context, String str, GroupMember groupMember) {
        if (context == null || TextUtils.isEmpty(str) || groupMember == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                return newDb.update(DBTableDefine.getGroupMessageTableName(str), getGroupMemberCv(groupMember), "group_id = ? AND bduid = ?", new String[]{groupMember.getGroupid(), String.valueOf(groupMember.getBduid())}).intValue();
            }
            return DBResponseCode.ERROR_GROUP_NOT_EXIST;
        }
        return DBResponseCode.ERROR_DB_OPEN;
    }
}
