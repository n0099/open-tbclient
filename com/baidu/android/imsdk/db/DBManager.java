package com.baidu.android.imsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.CmdQueueMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class DBManager extends DBBase {
    public static final String TAG = "DBManager";
    public static volatile DBManager mInstance;

    /* loaded from: classes.dex */
    public class CmdQueueMsgParse implements CursorParse {
        public CmdQueueMsg msg = null;

        public CmdQueueMsgParse() {
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor == null || !cursor.moveToFirst()) {
                return;
            }
            this.msg = new CmdQueueMsg();
            String string = cursor.getString(cursor.getColumnIndex("uuid"));
            String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_PARAM));
            String string3 = !cursor.isNull(cursor.getColumnIndex("extra")) ? cursor.getString(cursor.getColumnIndex("extra")) : "";
            int i = cursor.getInt(cursor.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_METHOD_ID));
            this.msg.setUuid(string);
            this.msg.setBody(string2);
            this.msg.setMethodId(i);
            this.msg.setExtra(string3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public CmdQueueMsg getResult() {
            return this.msg;
        }
    }

    public DBManager(Context context) {
        setContext(context);
    }

    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }

    private String[] transToStringArray(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        int length = iArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = String.valueOf(iArr[i]);
        }
        return strArr;
    }

    public void cleanAllData() {
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase != null) {
                openDatabase.delete(TableDefine.DB_TABLE_CHAT_SESSION, null, null);
                openDatabase.delete("message", null, null);
                openDatabase.delete(TableDefine.DB_TABLE_USERINFO, null, null);
                openDatabase.delete("groupinfo", null, null);
                openDatabase.delete("groupmember", null, null);
            }
        }
    }

    public boolean deleteCmdMsg(String str) {
        boolean z;
        synchronized (DBBase.mSyncLock) {
            LogUtils.d("DBManager", "deleteCmdMsg( uuid:" + str + SmallTailInfo.EMOTION_SUFFIX);
            z = true;
            if (delete(TableDefine.DB_TABLE_PA_CMD_QUEUE, "uuid=?", new String[]{str}) <= 0) {
                z = false;
            }
        }
        return z;
    }

    public CmdQueueMsg getCmdQueueMsg(int i) {
        CmdQueueMsg result;
        synchronized (DBBase.mSyncLock) {
            CmdQueueMsgParse cmdQueueMsgParse = new CmdQueueMsgParse();
            query(TableDefine.DB_TABLE_PA_CMD_QUEUE, null, "send_status=? AND type=?", new String[]{String.valueOf(1), String.valueOf(i)}, null, null, "priority desc", cmdQueueMsgParse);
            result = cmdQueueMsgParse.getResult();
        }
        return result;
    }

    public boolean saveCmdMsg(String str, int i, String str2, String str3, int i2, int i3) {
        synchronized (DBBase.mSyncLock) {
            LogUtils.d("DBManager", "saveCmdMsg( uuid:" + str + "  ,methodId:" + i + " , cmdMsgBody:" + str2 + " , extra" + str3 + SmallTailInfo.EMOTION_SUFFIX);
            boolean z = true;
            if (getCmdQueueMsg(str, i3) != null) {
                return true;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("uuid", str);
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_METHOD_ID, Integer.valueOf(i));
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_PARAM, str2);
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, (Integer) 1);
            contentValues.put("priority", Integer.valueOf(i2));
            contentValues.put("type", Integer.valueOf(i3));
            if (str3 != null) {
                contentValues.put("extra", str3);
            }
            if (insert(TableDefine.DB_TABLE_PA_CMD_QUEUE, contentValues) <= 0) {
                z = false;
            }
            return z;
        }
    }

    public int setCentainTypeIDel(int[] iArr) {
        synchronized (DBBase.mSyncLock) {
            String makePlaceholders = makePlaceholders(iArr.length);
            if (makePlaceholders == null) {
                return -1;
            }
            String[] transToStringArray = transToStringArray(iArr);
            if (transToStringArray == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, (Integer) 1);
            return update(TableDefine.DB_TABLE_PA_CMD_QUEUE, "type IN (" + makePlaceholders + SmallTailInfo.EMOTION_SUFFIX, transToStringArray, contentValues);
        }
    }

    public boolean updateCmdMsgSendStatus(String str, int i) {
        boolean z;
        synchronized (DBBase.mSyncLock) {
            LogUtils.d("DBManager", "updateCmdMsgSendStatus( uuid:" + str + ", sendStatus:" + i + SmallTailInfo.EMOTION_SUFFIX);
            ContentValues contentValues = new ContentValues();
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(i));
            z = true;
            if (update(TableDefine.DB_TABLE_PA_CMD_QUEUE, "uuid = ?", new String[]{str}, contentValues) <= 0) {
                z = false;
            }
        }
        return z;
    }

    public CmdQueueMsg getCmdQueueMsg(String str, int i) {
        CmdQueueMsg result;
        synchronized (DBBase.mSyncLock) {
            CmdQueueMsgParse cmdQueueMsgParse = new CmdQueueMsgParse();
            query(TableDefine.DB_TABLE_PA_CMD_QUEUE, null, "uuid= ? AND type=?", new String[]{str, String.valueOf(i)}, null, null, null, cmdQueueMsgParse);
            result = cmdQueueMsgParse.getResult();
        }
        return result;
    }

    public boolean updateCmdMsgSendStatus(String str, String str2, String str3, int i) {
        boolean z;
        synchronized (DBBase.mSyncLock) {
            LogUtils.d("DBManager", "updateCmdMsgSendStatus( uuid:" + str + ", sendStatus:" + i + SmallTailInfo.EMOTION_SUFFIX);
            ContentValues contentValues = new ContentValues();
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(i));
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_PARAM, str2);
            contentValues.put("extra", str3);
            z = true;
            if (update(TableDefine.DB_TABLE_PA_CMD_QUEUE, "uuid = ?", new String[]{str}, contentValues) <= 0) {
                z = false;
            }
        }
        return z;
    }
}
