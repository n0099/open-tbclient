package com.baidu.android.imsdk.group.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
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
/* loaded from: classes3.dex */
public class GroupInfoDAOImpl {
    private static final String TAG = "GroupInfoDAOImpl";
    private static GroupInfoParse sGroupInfoParse = new GroupInfoParse();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class GroupInfoParse implements IResultParse<GroupInfo> {
        private GroupInfoParse() {
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
            int i = cursor.getInt(cursor.getColumnIndex("group_type"));
            int i2 = cursor.getInt(cursor.getColumnIndex("state"));
            long j = cursor.getLong(cursor.getColumnIndex("create_time"));
            long j2 = cursor.getLong(cursor.getColumnIndex("bduid"));
            long j3 = cursor.getLong(cursor.getColumnIndex("uk"));
            int i3 = cursor.getInt(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_USER_NUM));
            long j4 = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_VERSION));
            int i4 = cursor.getInt(cursor.getColumnIndex("disturb"));
            int i5 = cursor.getInt(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF));
            String string3 = cursor.getString(cursor.getColumnIndex("description"));
            GroupInfo groupInfo = new GroupInfo(string);
            groupInfo.setGroupName(string2);
            groupInfo.setType(i);
            groupInfo.setState(i2);
            groupInfo.setCreateTime(j);
            groupInfo.setBuid(j2);
            groupInfo.setUk(j3);
            groupInfo.setNum(i3);
            groupInfo.setMembersVersion(j4);
            groupInfo.setDisturb(i4);
            groupInfo.setBrief(i5);
            groupInfo.setHeadUrl(string3);
            return groupInfo;
        }
    }

    private static ContentValues getGroupInfoCv(GroupInfo groupInfo) {
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

    private static ContentValues getGroupMemberCv(GroupMember groupMember) {
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

    public static int createGroup(Context context, String str) {
        DBGroupTableManager dBGroupTableManager;
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        final String sqlCreateTableGroupMessage = DBTableDefine.getSqlCreateTableGroupMessage(str);
        final ContentValues contentValues = new ContentValues();
        contentValues.put("group_id", str);
        int intValue = newDb.execTransaction(new ITransaction() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.1
            @Override // com.baidu.android.imsdk.db.ITransaction
            public void execTransaction(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL(sqlCreateTableGroupMessage);
                LogUtils.d(GroupInfoDAOImpl.TAG, "insertret : " + sQLiteDatabase.insert("groupinfo", null, contentValues));
            }
        }).intValue();
        LogUtils.d(TAG, "STAR create star group " + intValue + " " + str);
        if (intValue == 0 && (dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)) != null) {
            String groupMessageTableName = DBTableDefine.getGroupMessageTableName(str);
            LogUtils.d(TAG, "STAR add group table " + groupMessageTableName);
            dBGroupTableManager.addGroupTable(groupMessageTableName);
        }
        return intValue;
    }

    public static boolean isExistGroup(Context context, String str) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        LogUtils.e(TAG, "operation : " + newDb);
        if (newDb == null) {
            return false;
        }
        DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
        if (dBGroupTableManager == null) {
            dBGroupTableManager = new DBGroupTableManager();
            newDb.setTag(DBGroupTableManager.KEY, dBGroupTableManager);
        }
        return dBGroupTableManager.isExistGroupTable(context, str);
    }

    public static int updateGroupInfo(Context context, GroupInfo groupInfo) {
        if (context == null || groupInfo == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        if ((!((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, groupInfo.getGroupId()) ? createGroup(context, groupInfo.getGroupId()) : 0) < 0) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return newDb.update("groupinfo", getGroupInfoCv(groupInfo), "group_id = ? ", new String[]{groupInfo.getGroupId()}).intValue();
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

    public static ArrayList<String> getGroupList(Context context, boolean z, int i, int i2) {
        String str;
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            String str2 = (z ? "active_state = 1 AND state = 0" : "active_state = 1") + " AND group_type != 2";
            if (i > 0) {
                str = String.valueOf(i);
                if (i2 > 0) {
                    str = str + " offset " + i2;
                }
            } else {
                str = null;
            }
            return newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public String onParse(Cursor cursor) {
                    return cursor.getString(cursor.getColumnIndex("group_id"));
                }
            }, "groupinfo", new String[]{"group_id"}, str2, null, null, null, "create_time DESC", str);
        }
        return null;
    }

    public static long addMemberToGroup(Context context, String str, List<GroupMember> list) {
        if (context == null || TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return -7001L;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return -70003L;
        }
        if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
            ArrayList arrayList = new ArrayList();
            for (GroupMember groupMember : list) {
                ContentValues groupMemberCv = getGroupMemberCv(groupMember);
                if (groupMemberCv != null) {
                    arrayList.add(groupMemberCv);
                }
            }
            List<Long> insert = newDb.insert("groupmember", arrayList);
            if (insert != null && insert.size() > 0) {
                return insert.get(0).longValue();
            }
            return -7100L;
        }
        return -7008L;
    }

    public static int updateMemberToGroup(Context context, String str, GroupMember groupMember) {
        if (context == null || TextUtils.isEmpty(str) || groupMember == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
            return newDb.update(DBTableDefine.getGroupMessageTableName(str), getGroupMemberCv(groupMember), "group_id = ? AND bduid = ?", new String[]{groupMember.getGroupid(), String.valueOf(groupMember.getBduid())}).intValue();
        }
        return DBResponseCode.ERROR_GROUP_NOT_EXIST;
    }

    public static int updateMemberNickName(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("nickname", str3);
        return newDb.update("groupmember", contentValues, "group_id = ? AND bduid = ?", new String[]{str, str2}).intValue();
    }

    public static ArrayList<GroupMember> getGroupMember(Context context, String str, ArrayList<String> arrayList, int i) {
        ArrayList<GroupMember> arrayList2;
        GroupMember groupMember;
        String str2;
        String str3;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            if (arrayList == null || arrayList.size() <= 0) {
                str2 = "";
            } else {
                String str4 = " AND ( bduid = " + arrayList.get(0);
                int i2 = 1;
                while (i2 < arrayList.size()) {
                    String str5 = str4 + " OR bduid = " + arrayList.get(i2);
                    i2++;
                    str4 = str5;
                }
                str2 = str4 + " ) ";
            }
            String str6 = "";
            if (i < 0) {
                str6 = "join_time DESC ";
                str3 = String.valueOf(Math.abs(i));
            } else if (i > 0) {
                str6 = "join_time ASC  ";
                str3 = String.valueOf(i);
            } else if (i == 0) {
                str6 = "join_time ASC  ";
                str3 = null;
            } else {
                str3 = null;
            }
            arrayList2 = newDb.query(new IResultParse<GroupMember>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.5
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public GroupMember onParse(Cursor cursor) {
                    String string = cursor.getString(cursor.getColumnIndex("group_id"));
                    long j = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME));
                    int i3 = cursor.getInt(cursor.getColumnIndex("role"));
                    String string2 = cursor.getString(cursor.getColumnIndex("name"));
                    String string3 = cursor.getString(cursor.getColumnIndex("nickname"));
                    long j2 = cursor.getLong(cursor.getColumnIndex("bduid"));
                    long j3 = cursor.getLong(cursor.getColumnIndex("uk"));
                    int i4 = cursor.getInt(cursor.getColumnIndex("status"));
                    GroupMember groupMember2 = new GroupMember(string, j3, string2, j2, i3, j);
                    groupMember2.setValid(i4);
                    groupMember2.setNickName(string3);
                    return groupMember2;
                }
            }, "groupmember", null, "group_id = ? " + str2, new String[]{str}, null, null, str6, str3);
        } else {
            arrayList2 = null;
        }
        if (arrayList2 != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= arrayList2.size()) {
                    groupMember = null;
                    break;
                }
                groupMember = arrayList2.get(i3);
                if (1 != groupMember.getRole()) {
                    i3++;
                } else {
                    arrayList2.remove(i3);
                    break;
                }
            }
            if (groupMember != null) {
                arrayList2.add(0, groupMember);
            }
        }
        return arrayList2;
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
                int i = cursor.getInt(cursor.getColumnIndex("role"));
                String string2 = cursor.getString(cursor.getColumnIndex("name"));
                String string3 = cursor.getString(cursor.getColumnIndex("nickname"));
                long j2 = cursor.getLong(cursor.getColumnIndex("bduid"));
                long j3 = cursor.getLong(cursor.getColumnIndex("uk"));
                int i2 = cursor.getInt(cursor.getColumnIndex("status"));
                GroupMember groupMember = new GroupMember(string, j3, string2, j2, i, j);
                groupMember.setValid(i2);
                groupMember.setNickName(string3);
                return groupMember;
            }
        }, "groupmember", null, "group_id = ? ", new String[]{str}, null, null, null, null);
    }

    public static int hasMemberInGroup(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
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
        return 0;
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

    public static String getNickName(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        ArrayList query = newDb != null ? newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.db.IResultParse
            public String onParse(Cursor cursor) {
                return cursor.getString(cursor.getColumnIndex("nickname"));
            }
        }, "groupmember", new String[]{"nickname"}, "group_id = ?  AND bduid = ? ", new String[]{str, str2}, null, null, null, null) : null;
        if (query == null || query.size() <= 0) {
            return null;
        }
        return (String) query.get(0);
    }

    public static int quitGroup(Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        int intValue = newDb.execTransaction(new ITransaction() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.10
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
        return intValue;
    }

    public static int delGroupMember(Context context, String str, ArrayList<String> arrayList) {
        if (context == null || arrayList == null || arrayList.size() == 0) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        LogUtils.d("GroupInfoDAOIMPL", "delGroupMember " + arrayList.toString());
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        String str2 = " ( " + arrayList.get(0);
        int i = 1;
        while (i < arrayList.size()) {
            String str3 = str2 + ", " + arrayList.get(i);
            i++;
            str2 = str3;
        }
        return newDb.delete("groupmember", "group_id = ? AND bduid in " + (str2 + " ) "), new String[]{str}).intValue();
    }

    public static int deletedGroupMember(Context context, String str) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", (Integer) 1);
        return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
    }

    public static int updateGroupMemberRole(Context context, String str, String str2, int i) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("role", Integer.valueOf(i));
        return newDb.update("groupmember", contentValues, "group_id = ? AND bduid = ? ", new String[]{str, str2}).intValue();
    }

    public static int updateMasterAsCommon(Context context, String str, int i) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("role", Integer.valueOf(i));
        return newDb.update("groupmember", contentValues, "group_id = ? AND role = 2 ", new String[]{str}).intValue();
    }

    public static ArrayList<GroupInfo> getGroupInfo(Context context, ArrayList<String> arrayList) {
        DBOperation newDb;
        if (context == null || arrayList == null || arrayList.size() == 0 || (newDb = DBOperationFactory.getNewDb(context)) == null) {
            return null;
        }
        String str = " ( " + arrayList.get(0);
        int i = 1;
        while (i < arrayList.size()) {
            String str2 = str + ", " + arrayList.get(i);
            i++;
            str = str2;
        }
        return newDb.query(sGroupInfoParse, "groupinfo", null, "group_id in " + (str + " ) "), null, null, null, null, null);
    }

    public static ArrayList<GroupInfo> getAllGroupInfo(Context context) {
        DBOperation newDb;
        if (context == null || (newDb = DBOperationFactory.getNewDb(context)) == null) {
            return null;
        }
        return newDb.query(sGroupInfoParse, "groupinfo", null, null, null, null, null, null, null);
    }

    public static int modifyGroupName(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || str2 == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        ConversationManagerImpl.getInstance(context).updateConversationName(str2, 1, String.valueOf(str));
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", str2);
        return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
    }

    public static int modifyGroupMemberNumber(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str) || i < 0) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_NUM, Integer.valueOf(i));
        return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
    }

    public static int modifyGroupMemberVersion(Context context, String str, long j) {
        if (context == null || TextUtils.isEmpty(str) || j < 0) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_VERSION, Long.valueOf(j));
        return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
    }

    public static int setGroupDisturb(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("disturb", Integer.valueOf(i));
            return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
        }
        return DBResponseCode.ERROR_GROUP_NOT_EXIST;
    }

    public static int setAllStarDisturbDefault(Context context) {
        if (context == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("disturb", (Integer) 1);
        return newDb.update("groupinfo", contentValues, "group_type = ? ", new String[]{"2"}).intValue();
    }

    public static int setGroupState(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", Integer.valueOf(i));
            return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
        }
        return DBResponseCode.ERROR_GROUP_NOT_EXIST;
    }

    public static int activeGroupState(Context context, String str) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
        if (dBGroupTableManager.isExistGroupTable(context, str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_ACTIVE_STATE, (Integer) 1);
            int intValue = newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            if (intValue > 0) {
                dBGroupTableManager.activeGroup(str);
            }
            return intValue;
        }
        return DBResponseCode.ERROR_GROUP_NOT_EXIST;
    }

    public static int setGroupPermit(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, Integer.valueOf(i));
            return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
        }
        return DBResponseCode.ERROR_GROUP_NOT_EXIST;
    }

    public static int setGroupType(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("group_type", Integer.valueOf(i));
            return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
        }
        return DBResponseCode.ERROR_GROUP_NOT_EXIST;
    }
}
