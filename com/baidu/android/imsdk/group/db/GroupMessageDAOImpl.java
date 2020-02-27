package com.baidu.android.imsdk.group.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.db.DBGroupTableManager;
import com.baidu.android.imsdk.db.DBOperation;
import com.baidu.android.imsdk.db.DBOperationFactory;
import com.baidu.android.imsdk.db.DBResponseCode;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.IResultParse;
import com.baidu.android.imsdk.db.ITransaction;
import com.baidu.android.imsdk.utils.LogUtils;
import com.google.android.exoplayer2.Format;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class GroupMessageDAOImpl {
    public static final String TAG = "GroupMessageDAOImpl";
    private static ChatMsgParse sGroupChatMsgParse = new ChatMsgParse();

    /* loaded from: classes3.dex */
    public enum MSGTYPEEXPLAN {
        EQUAL,
        UNEQUAL
    }

    /* loaded from: classes3.dex */
    public enum MessageType {
        DRAFT2SENDING,
        SENDING2FAIL,
        SENDING2SUCCESS
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ChatMsgParse implements IResultParse<ChatMsg> {
        Context mContext;

        private ChatMsgParse() {
        }

        public void setContext(Context context) {
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.android.imsdk.db.IResultParse
        public ChatMsg onParse(Cursor cursor) {
            if (cursor != null) {
                return GroupMessageDAOImpl.construGroupChatMsg(this.mContext, cursor);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class LocalChatMsgParse implements IResultParse<ChatMsg> {
        Context mContext;

        public LocalChatMsgParse(Context context) {
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.android.imsdk.db.IResultParse
        public ChatMsg onParse(Cursor cursor) {
            if (cursor != null) {
                return GroupMessageDAOImpl.construGroupChatMsg(this.mContext, cursor);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class GroupChatMsgParse implements IResultParse<ChatMsg> {
        Context mContext;

        public GroupChatMsgParse(Context context) {
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.android.imsdk.db.IResultParse
        public ChatMsg onParse(Cursor cursor) {
            if (cursor != null) {
                return GroupMessageDAOImpl.construGroupChatMsg(this.mContext, cursor);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ChatMsg construGroupChatMsg(Context context, Cursor cursor) {
        int i = cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_ROW_ID));
        int i2 = cursor.getInt(cursor.getColumnIndex("type"));
        long j = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupMessageColumns.COLUMN_FROM_USER));
        long j2 = cursor.getLong(cursor.getColumnIndex("msgid"));
        long j3 = cursor.getLong(cursor.getColumnIndex("time"));
        int i3 = cursor.getInt(cursor.getColumnIndex("is_read"));
        int i4 = cursor.getInt(cursor.getColumnIndex("status"));
        String string = cursor.getString(cursor.getColumnIndex("content"));
        long j4 = cursor.getLong(cursor.getColumnIndex("groupid"));
        int i5 = cursor.getInt(cursor.getColumnIndex("cmd"));
        String string2 = cursor.getString(cursor.getColumnIndex("local_url"));
        boolean z = cursor.getInt(cursor.getColumnIndex("isclicked")) == 1;
        int i6 = cursor.getInt(cursor.getColumnIndex("device_flag"));
        String string3 = cursor.getString(cursor.getColumnIndex("sendid"));
        String string4 = cursor.getString(cursor.getColumnIndex(DBTableDefine.GroupMessageColumns.COLUMN_FROM_BUID));
        ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(context, 1, i2, i5);
        if (newChatMsg == null) {
            return null;
        }
        newChatMsg.setCategory(1);
        newChatMsg.setContacter(j4);
        newChatMsg.setFromUser(j);
        newChatMsg.setMsgContent(string);
        newChatMsg.setRowId(i);
        newChatMsg.setMsgId(j2);
        newChatMsg.setMsgTime(j3);
        newChatMsg.setMsgReaded(i3);
        newChatMsg.setStatus(i4);
        newChatMsg.setNotifyCmd(i5);
        newChatMsg.setLocalUrl(string2);
        newChatMsg.setIsZhida(false);
        newChatMsg.setIsClicked(z);
        newChatMsg.setPaid(-1L);
        newChatMsg.setMsgType(i2);
        newChatMsg.setDeviceFlag(i6);
        newChatMsg.setSendMsgId(string3);
        newChatMsg.setSenderUid(string4);
        return newChatMsg;
    }

    private static ContentValues constructionGroupMessageContentValues(ChatMsg chatMsg) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("groupid", Long.valueOf(chatMsg.getContacter()));
        contentValues.put(DBTableDefine.GroupMessageColumns.COLUMN_FROM_USER, Long.valueOf(chatMsg.getFromUser()));
        contentValues.put(DBTableDefine.GroupMessageColumns.COLUMN_FROM_BUID, chatMsg.getSenderUid());
        contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
        contentValues.put("sendid", chatMsg.getSendMsgId());
        contentValues.put("content", chatMsg.getMsgContent());
        contentValues.put("type", Integer.valueOf(chatMsg.getRealMsgType()));
        contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
        contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
        int i = chatMsg.isMsgRead() ? 1 : 0;
        if (chatMsg.isStarMessage() && chatMsg.isNotifyMessage()) {
            i = 1;
        }
        contentValues.put("is_read", Integer.valueOf(i));
        contentValues.put("cmd", Integer.valueOf(chatMsg.getNotifyCmd()));
        contentValues.put("local_url", chatMsg.getLocalUrl());
        contentValues.put("isclicked", Integer.valueOf(chatMsg.isClicked() ? 1 : 0));
        contentValues.put("device_flag", Integer.valueOf(chatMsg.getDeviceFlag()));
        contentValues.put("msg_key", chatMsg.getMsgKey());
        return contentValues;
    }

    public static long addSingleChatMsg(Context context, ChatMsg chatMsg) {
        if (chatMsg == null || context == null) {
            LogUtils.e(TAG, "parameter should not be null!");
            return -7001L;
        } else if (1 != chatMsg.getCategory()) {
            LogUtils.e(TAG, "The msg is not group msg!");
            return -7001L;
        } else {
            String contacterId = chatMsg.getContacterId();
            if (TextUtils.isEmpty(contacterId)) {
                LogUtils.e(TAG, "groupid should not be null or \"\"!");
                return -7001L;
            }
            switch (chatMsg.getStatus()) {
                case 0:
                    return addSuccessChatMsg(context, chatMsg, contacterId);
                case 1:
                case 2:
                case 3:
                    return addLocalChatMsg(context, chatMsg, contacterId);
                default:
                    return -1L;
            }
        }
    }

    private static long addSuccessChatMsg(Context context, ChatMsg chatMsg, String str) {
        int createGroup;
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            LogUtils.e(TAG, " operation is null");
            return -70003L;
        } else if (!((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str) && (createGroup = GroupInfoDAOImpl.createGroup(context, str)) < 0) {
            return createGroup;
        } else {
            long longValue = newDb.insert(DBTableDefine.getGroupMessageTableName(str), constructionGroupMessageContentValues(chatMsg)).longValue();
            chatMsg.setRowId(longValue);
            return longValue;
        }
    }

    private static long addLocalChatMsg(Context context, ChatMsg chatMsg, String str) {
        int createGroup;
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            LogUtils.e(TAG, " operation is null");
            return -70003L;
        } else if (!((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str) && (createGroup = GroupInfoDAOImpl.createGroup(context, str)) < 0) {
            return createGroup;
        } else {
            long longValue = newDb.insert(DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, constructionGroupMessageContentValues(chatMsg)).longValue();
            chatMsg.setRowId(longValue);
            return longValue;
        }
    }

    public static boolean isActiveGroup(Context context, String str) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return false;
        }
        return ((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isActive(context, str);
    }

    public static ArrayList<Long> addChatMsg(Context context, String str, ArrayList<ChatMsg> arrayList) {
        ContentValues constructionGroupMessageContentValues;
        ArrayList<Long> arrayList2 = new ArrayList<>();
        if (context == null || arrayList == null || arrayList.size() <= 0) {
            arrayList2.add(-7001L);
            return arrayList2;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatMsg> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatMsg next = it.next();
                    if (next.getMsgType() != 1012 && (constructionGroupMessageContentValues = constructionGroupMessageContentValues(next)) != null) {
                        arrayList3.add(constructionGroupMessageContentValues);
                    }
                }
                List<Long> insert = newDb.insert(DBTableDefine.getGroupMessageTableName(str), arrayList3);
                if (insert != null && insert.size() > 0) {
                    return (ArrayList) insert;
                }
                arrayList2.add(-7100L);
            } else {
                arrayList2.add(-7008L);
            }
        } else {
            arrayList2.add(-70003L);
        }
        return arrayList2;
    }

    public static int getUnReadCount(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        String groupMessageTableName = DBTableDefine.getGroupMessageTableName(str);
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
            ArrayList query = newDb.query(new IResultParse<Integer>() { // from class: com.baidu.android.imsdk.group.db.GroupMessageDAOImpl.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public Integer onParse(Cursor cursor) {
                    return Integer.valueOf(cursor.getInt(0));
                }
            }, groupMessageTableName, new String[]{"count(*) "}, "is_read = ?", new String[]{String.valueOf(0)}, "is_read", null, null, null);
            LogUtils.e(TAG, "rets " + query + ",groupid: " + str);
            if (query == null || query.size() <= 0) {
                return 0;
            }
            return ((Integer) query.get(0)).intValue();
        }
        return DBResponseCode.ERROR_GROUP_NOT_EXIST;
    }

    public static long[] getGroupSystemMessageType() {
        return new long[]{101, 1006, 1001, 1002, 1004, 1003, 1005, 1007, 1008, 1009, 1010, 1011, 2001, 2010};
    }

    public static long[] getStarGroupSystemMessageType() {
        return new long[]{1001, 1002, 1004, 1003, 1005, 1007, 1008, 1009, 1010, 1011, 2010};
    }

    public static ArrayList<ChatMsg> fetchChatMsgExceptGroupSystem(Context context, String str, ChatMsg chatMsg, long j, boolean z) {
        if (chatMsg != null) {
            return fetchChatMsgInteranl(context, str, 1, chatMsg.getMsgId(), j, chatMsg.getRowId(), z, getGroupSystemMessageType(), MSGTYPEEXPLAN.UNEQUAL);
        }
        return fetchChatMsgInteranl(context, str, 1, Format.OFFSET_SAMPLE_RELATIVE, -Math.abs(j), -1L, z, getGroupSystemMessageType(), MSGTYPEEXPLAN.UNEQUAL);
    }

    public static ArrayList<ChatMsg> fetchGroupSystemMsg(Context context, String str, ChatMsg chatMsg, long j, boolean z) {
        if (chatMsg != null) {
            return fetchChatMsgInteranl(context, str, 1, chatMsg.getMsgId(), j, chatMsg.getRowId(), z, getGroupSystemMessageType(), MSGTYPEEXPLAN.EQUAL);
        }
        return fetchChatMsgInteranl(context, str, 1, Format.OFFSET_SAMPLE_RELATIVE, -Math.abs(j), -1L, z, getGroupSystemMessageType(), MSGTYPEEXPLAN.EQUAL);
    }

    public static ArrayList<ChatMsg> fetchAllChatMsg(Context context, String str, ChatMsg chatMsg, long j, boolean z) {
        if (chatMsg != null) {
            return fetchChatMsgInteranl(context, str, 1, chatMsg.getMsgId(), j, chatMsg.getRowId(), z, null, MSGTYPEEXPLAN.EQUAL);
        }
        return fetchChatMsgInteranl(context, str, 1, Format.OFFSET_SAMPLE_RELATIVE, -Math.abs(j), -1L, z, null, MSGTYPEEXPLAN.UNEQUAL);
    }

    public static ArrayList<ChatMsg> fetchAllChatMsg(Context context, String str, ChatMsg chatMsg, long j, boolean z, long[] jArr) {
        if (chatMsg != null) {
            return fetchChatMsgInteranl(context, str, 1, chatMsg.getMsgId(), j, chatMsg.getRowId(), z, jArr, MSGTYPEEXPLAN.UNEQUAL);
        }
        return fetchChatMsgInteranl(context, str, 1, Format.OFFSET_SAMPLE_RELATIVE, -Math.abs(j), -1L, z, jArr, MSGTYPEEXPLAN.UNEQUAL);
    }

    public static ArrayList<ChatMsg> fetchLastChatMsg(Context context, String str, ChatMsg chatMsg, long j, boolean z) {
        return fetchChatMsgInteranl(context, str, 1, Format.OFFSET_SAMPLE_RELATIVE, -Math.abs(j), -1L, z, getStarGroupSystemMessageType(), MSGTYPEEXPLAN.UNEQUAL);
    }

    private static ArrayList<ChatMsg> fetchChatMsgInteranl(Context context, String str, int i, long j, long j2, long j3, boolean z, long[] jArr, MSGTYPEEXPLAN msgtypeexplan) {
        String str2 = "msgid ASC , _id ASC";
        String str3 = " > ? ";
        if (j2 < 0) {
            str3 = " < ? ";
            str2 = "msgid DESC , _id DESC";
        } else if (0 == j2) {
            str3 = " = ? ";
        }
        String str4 = "msgid" + str3;
        String[] strArr = {String.valueOf(j)};
        if (jArr != null && jArr.length > 0) {
            String str5 = " in ";
            switch (msgtypeexplan) {
                case UNEQUAL:
                    str5 = " not in ";
                    break;
            }
            String str6 = " ( " + jArr[0];
            for (int i2 = 1; i2 < jArr.length; i2++) {
                str6 = str6 + Constants.ACCEPT_TIME_SEPARATOR_SP + jArr[i2];
            }
            str4 = str4 + " AND type" + str5 + (str6 + " )");
        }
        sGroupChatMsgParse.setContext(context);
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return null;
        }
        DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
        if (dBGroupTableManager != null && !dBGroupTableManager.isExistGroupTable(context, str)) {
            return null;
        }
        ArrayList<ChatMsg> query = newDb.query(sGroupChatMsgParse, "(select * from " + DBTableDefine.getGroupMessageTableName(str) + " union all select * from " + DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE + " where groupid = " + str + " AND status != 3 )", null, str4, strArr, null, null, str2, String.valueOf(Math.abs(j2)));
        if (query != null && query.size() > 0) {
            Iterator<ChatMsg> it = query.iterator();
            while (it.hasNext()) {
                LogUtils.e(TAG, it.next().toString());
            }
            if ((z && j2 < 0) || (!z && j2 > 0)) {
                Collections.reverse(query);
            }
        }
        return query;
    }

    public static int setMsgReaded(Context context, String str, long j) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
        if (dBGroupTableManager != null && !dBGroupTableManager.isExistGroupTable(context, str)) {
            GroupInfoDAOImpl.createGroup(context, str);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_read", (Integer) 1);
        return newDb.update(DBTableDefine.getGroupMessageTableName(str), contentValues, "msgid = ? ", new String[]{String.valueOf(j)}).intValue();
    }

    public static int setAllMsgRead(Context context, String str, long j) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
        if (dBGroupTableManager != null && !dBGroupTableManager.isExistGroupTable(context, str)) {
            return DBResponseCode.ERROR_GROUP_NOT_EXIST;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_read", (Integer) 1);
        return newDb.update(DBTableDefine.getGroupMessageTableName(str), contentValues, "is_read = ? AND msgid <= ? ", new String[]{String.valueOf(0), String.valueOf(j)}).intValue();
    }

    public static long getMaxMsgid(Context context, String str) {
        ArrayList arrayList = null;
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
            if (dBGroupTableManager != null && !dBGroupTableManager.isExistGroupTable(context, str)) {
                return -1L;
            }
            arrayList = newDb.query(new IResultParse<Long>() { // from class: com.baidu.android.imsdk.group.db.GroupMessageDAOImpl.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public Long onParse(Cursor cursor) {
                    long j = -1;
                    if (cursor != null) {
                        j = cursor.getLong(cursor.getColumnIndex("msgid"));
                    }
                    return Long.valueOf(j);
                }
            }, DBTableDefine.getGroupMessageTableName(str), new String[]{"msgid"}, null, null, null, null, "msgid DESC", String.valueOf(1));
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return -1L;
        }
        return ((Long) arrayList.get(0)).longValue();
    }

    public static int markMsgClicked(Context context, ChatMsg chatMsg) {
        int i;
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        String valueOf = String.valueOf(chatMsg.getContacter());
        if (newDb != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isclicked", (Integer) 1);
            i = newDb.update(DBTableDefine.getGroupMessageTableName(valueOf), contentValues, "msgid = ? ", new String[]{String.valueOf(chatMsg.getMsgId())}).intValue();
        } else {
            i = -70003;
        }
        ArrayList<ChatMsg> fetchAllChatMsg = fetchAllChatMsg(context, valueOf, null, -1L, true);
        if (fetchAllChatMsg == null || fetchAllChatMsg.size() == 0) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        if (chatMsg.getMsgId() == fetchAllChatMsg.get(0).getMsgId()) {
            ChatMessageDBManager.getInstance(context).updateChatSession(chatMsg);
            return i;
        }
        return i;
    }

    public static int delMsgsOfCertainContacter(Context context, String str, long j) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        if (-1 == j) {
            return newDb.delete(DBTableDefine.getGroupMessageTableName(str), null, null).intValue();
        }
        return newDb.delete(DBTableDefine.getGroupMessageTableName(str), "msgid <= ? ", new String[]{String.valueOf(j)}).intValue();
    }

    public static int deleteMsgs(Context context, String str, long[] jArr) {
        if (jArr == null || jArr.length <= 0) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        String str2 = " ( " + jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            str2 = str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + jArr[i];
        }
        return newDb.delete(DBTableDefine.getGroupMessageTableName(str), "msgid in " + (str2 + " )"), null).intValue();
    }

    public static int deleteChatMsg(Context context, ChatMsg chatMsg) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        String valueOf = String.valueOf(chatMsg.getContacter());
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return newDb.delete(DBTableDefine.getGroupMessageTableName(valueOf), "msgid = ? ", new String[]{String.valueOf(chatMsg.getMsgId())}).intValue();
    }

    public static int updateMsgStatus(Context context, final ChatMsg chatMsg) {
        if (context == null || chatMsg == null) {
            return DBResponseCode.ERROR_PARAMETER;
        }
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        if (chatMsg.getStatus() != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
            contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
            contentValues.put("content", chatMsg.getJsonContent());
            contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
            return newDb.update(DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, contentValues, "_id = ? ", new String[]{String.valueOf(chatMsg.getRowId())}).intValue();
        }
        final long rowId = chatMsg.getRowId();
        final ContentValues constructionGroupMessageContentValues = constructionGroupMessageContentValues(chatMsg);
        return newDb.execTransaction(new ITransaction() { // from class: com.baidu.android.imsdk.group.db.GroupMessageDAOImpl.3
            @Override // com.baidu.android.imsdk.db.ITransaction
            public void execTransaction(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.insert(DBTableDefine.getGroupMessageTableName(String.valueOf(ChatMsg.this.getContacter())), null, constructionGroupMessageContentValues);
                sQLiteDatabase.delete(DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, "_id = ? ", new String[]{String.valueOf(rowId)});
            }
        }).intValue();
    }

    public static ChatMsg getDraftMsg(Context context, String str) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            sGroupChatMsgParse.setContext(context);
            ArrayList query = newDb.query(sGroupChatMsgParse, DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, null, "groupid = ? AND status = ?", new String[]{str, String.valueOf(3)}, null, null, null, null);
            if (query == null || query.size() <= 0) {
                return null;
            }
            return (ChatMsg) query.get(0);
        }
        return null;
    }

    public static int deleteDraftMsg(Context context, String str) {
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb == null) {
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return newDb.delete(DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, "groupid = ? AND status = ?", new String[]{str, String.valueOf(3)}).intValue();
    }

    public static int updateDraftMsg(Context context, String str, ChatMsg chatMsg) {
        int i = DBResponseCode.ERROR_DB_OPEN;
        DBOperation newDb = DBOperationFactory.getNewDb(context);
        if (newDb != null) {
            i = newDb.update(DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, constructionGroupMessageContentValues(chatMsg), "groupid = ? AND status = ?", new String[]{str, String.valueOf(3)}).intValue();
        }
        ChatMessageDBManager.getInstance(context).updateChatSession(chatMsg);
        return i;
    }
}
