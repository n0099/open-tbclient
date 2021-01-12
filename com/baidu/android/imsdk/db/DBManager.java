package com.baidu.android.imsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.CmdQueueMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes3.dex */
public class DBManager extends DBBase {
    private static final String TAG = "DBManager";
    private static volatile DBManager mInstance = null;

    private DBManager(Context context) {
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

    public void cleanAllData() {
        synchronized (mSyncLock) {
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

    public boolean saveCmdMsg(String str, int i, String str2, String str3, int i2, int i3) {
        synchronized (mSyncLock) {
            LogUtils.d(TAG, "saveCmdMsg( uuid:" + str + "  ,methodId:" + i + " , cmdMsgBody:" + str2 + " , extra" + str3 + ")");
            if (getCmdQueueMsg(str, i3) == null) {
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
                r0 = insert(TableDefine.DB_TABLE_PA_CMD_QUEUE, contentValues) > 0;
            }
        }
        return r0;
    }

    public boolean deleteCmdMsg(String str) {
        boolean z;
        synchronized (mSyncLock) {
            LogUtils.d(TAG, "deleteCmdMsg( uuid:" + str + ")");
            z = delete(TableDefine.DB_TABLE_PA_CMD_QUEUE, "uuid=?", new String[]{str}) > 0;
        }
        return z;
    }

    public CmdQueueMsg getCmdQueueMsg(int i) {
        CmdQueueMsg result;
        synchronized (mSyncLock) {
            CmdQueueMsgParse cmdQueueMsgParse = new CmdQueueMsgParse();
            query(TableDefine.DB_TABLE_PA_CMD_QUEUE, null, "send_status=? AND type=?", new String[]{String.valueOf(1), String.valueOf(i)}, null, null, "priority desc", cmdQueueMsgParse);
            result = cmdQueueMsgParse.getResult();
        }
        return result;
    }

    public CmdQueueMsg getCmdQueueMsg(String str, int i) {
        CmdQueueMsg result;
        synchronized (mSyncLock) {
            CmdQueueMsgParse cmdQueueMsgParse = new CmdQueueMsgParse();
            query(TableDefine.DB_TABLE_PA_CMD_QUEUE, null, "uuid= ? AND type=?", new String[]{str, String.valueOf(i)}, null, null, null, cmdQueueMsgParse);
            result = cmdQueueMsgParse.getResult();
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class CmdQueueMsgParse implements CursorParse {
        CmdQueueMsg msg = null;

        CmdQueueMsgParse() {
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor != null && cursor.moveToFirst()) {
                this.msg = new CmdQueueMsg();
                String string = cursor.getString(cursor.getColumnIndex("uuid"));
                String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_PARAM));
                String str = "";
                if (!cursor.isNull(cursor.getColumnIndex("extra"))) {
                    str = cursor.getString(cursor.getColumnIndex("extra"));
                }
                int i = cursor.getInt(cursor.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_METHOD_ID));
                this.msg.setUuid(string);
                this.msg.setBody(string2);
                this.msg.setMethodId(i);
                this.msg.setExtra(str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public CmdQueueMsg getResult() {
            return this.msg;
        }
    }

    public boolean updateCmdMsgSendStatus(String str, int i) {
        boolean z;
        synchronized (mSyncLock) {
            LogUtils.d(TAG, "updateCmdMsgSendStatus( uuid:" + str + ", sendStatus:" + i + ")");
            ContentValues contentValues = new ContentValues();
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(i));
            z = update(TableDefine.DB_TABLE_PA_CMD_QUEUE, "uuid = ?", new String[]{str}, contentValues) > 0;
        }
        return z;
    }

    public boolean updateCmdMsgSendStatus(String str, String str2, String str3, int i) {
        boolean z;
        synchronized (mSyncLock) {
            LogUtils.d(TAG, "updateCmdMsgSendStatus( uuid:" + str + ", sendStatus:" + i + ")");
            ContentValues contentValues = new ContentValues();
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(i));
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_PARAM, str2);
            contentValues.put("extra", str3);
            z = update(TableDefine.DB_TABLE_PA_CMD_QUEUE, "uuid = ?", new String[]{str}, contentValues) > 0;
        }
        return z;
    }

    public int setCentainTypeIDel(int[] iArr) {
        int i = -1;
        synchronized (mSyncLock) {
            String makePlaceholders = makePlaceholders(iArr.length);
            if (makePlaceholders != null) {
                String[] transToStringArray = transToStringArray(iArr);
                if (transToStringArray != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, (Integer) 1);
                    i = update(TableDefine.DB_TABLE_PA_CMD_QUEUE, "type IN (" + makePlaceholders + ")", transToStringArray, contentValues);
                }
            }
        }
        return i;
    }

    private String[] transToStringArray(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        String[] strArr = new String[iArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(iArr[i]);
        }
        return strArr;
    }
}
