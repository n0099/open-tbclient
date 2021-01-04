package com.baidu.android.imsdk.chatmessage.sync;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.baidu.android.imsdk.db.CursorParse;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class DialogRecordDBManager extends DBBase {
    public static final String TAG = DialogRecordDBManager.class.getSimpleName();
    private static DialogRecordDBManager mInstance;

    private DialogRecordDBManager(Context context) {
        this.mContext = context;
    }

    public static DialogRecordDBManager getInstance(Context context) {
        synchronized (DialogRecordDBManager.class) {
            if (mInstance == null) {
                mInstance = new DialogRecordDBManager(context.getApplicationContext());
            }
        }
        return mInstance;
    }

    public long add(DialogRecord dialogRecord) {
        LogUtils.i(TAG, "add DialogRecord : " + dialogRecord);
        LinkedList linkedList = new LinkedList();
        linkedList.add(dialogRecord);
        return addBatch(linkedList);
    }

    public int delete(int i, long j) {
        int delete = delete(TableDefine.DB_TABLE_DIALOG_RECORD, "category=? AND contacter=?", new String[]{String.valueOf(i), String.valueOf(j)});
        LogUtils.d("delete dialog record ", delete + "  " + j + i);
        return delete;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [110=6, 111=5, 113=5, 114=5] */
    public long addBatch(List<DialogRecord> list) {
        Throwable th;
        Exception e;
        SQLiteDatabase openDatabase;
        if (list == null) {
            return -1L;
        }
        if (list.size() == 0) {
            return 0L;
        }
        long j = -1;
        Cursor cursor = null;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                openDatabase = openDatabase();
                try {
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = openDatabase;
                    }
                } catch (Exception e2) {
                    e = e2;
                    sQLiteDatabase = openDatabase;
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (openDatabase == null) {
                LogUtils.e(TAG, "getWritableDb fail!");
                if (0 != 0) {
                    cursor.close();
                }
                if (openDatabase != null) {
                    openDatabase.endTransaction();
                }
                return -1L;
            }
            openDatabase.beginTransaction();
            Iterator<DialogRecord> it = list.iterator();
            Cursor cursor2 = null;
            long j2 = -1;
            while (true) {
                try {
                    if (!it.hasNext()) {
                        cursor = cursor2;
                        j = j2;
                        break;
                    }
                    DialogRecord next = it.next();
                    String[] strArr = {String.valueOf(next.getCategory()), String.valueOf(next.getContacter())};
                    cursor = openDatabase.query(TableDefine.DB_TABLE_DIALOG_RECORD, null, "category=? AND contacter=?", strArr, null, null, null);
                    if (cursor == null) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (openDatabase != null) {
                            openDatabase.endTransaction();
                        }
                        return j2;
                    }
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(TableDefine.DRColumns.COLUMN_MAXMSGID, Long.valueOf(next.getMaxMsgid()));
                        contentValues.put("state", Integer.valueOf(next.getState()));
                        contentValues.put("update_time", Long.valueOf(next.getUpdateTime()));
                        contentValues.put(TableDefine.DRColumns.COLUMN_DAILOGUE_MSGID, Long.valueOf(next.getDialogueMsgid()));
                        if (cursor.getCount() > 0) {
                            contentValues.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, (Integer) 0);
                            j2 = openDatabase.update(TableDefine.DB_TABLE_DIALOG_RECORD, contentValues, "category=? AND contacter=?", strArr);
                        } else {
                            contentValues.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, (Integer) 1);
                            contentValues.put("category", Integer.valueOf(next.getCategory()));
                            contentValues.put("contacter", Long.valueOf(next.getContacter()));
                            j2 = openDatabase.insert(TableDefine.DB_TABLE_DIALOG_RECORD, null, contentValues);
                        }
                        if (cursor != null) {
                            cursor.close();
                            cursor = null;
                        }
                        if (j2 < 0) {
                            j = j2;
                            break;
                        }
                        cursor2 = cursor;
                    } catch (Exception e4) {
                        e = e4;
                        sQLiteDatabase = openDatabase;
                        j = j2;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "deleteCmdMsg:", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                            return j;
                        }
                        return j;
                    }
                } catch (Exception e5) {
                    e = e5;
                    sQLiteDatabase = openDatabase;
                    cursor = cursor2;
                    j = j2;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = openDatabase;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    throw th;
                }
            }
            if (j >= 0) {
                openDatabase.setTransactionSuccessful();
            }
            if (cursor != null) {
                cursor.close();
            }
            if (openDatabase != null) {
                openDatabase.endTransaction();
                return j;
            }
            return j;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [143=4, 144=4] */
    public long getMaxMsgid() {
        Cursor cursor = null;
        long j = -1;
        try {
            try {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getWritableDb fail!");
                } else {
                    Cursor rawQuery = openDatabase.rawQuery("select max(localmsgid) from dialog_record", null);
                    if (rawQuery != null) {
                        j = 0;
                        if (rawQuery.moveToNext()) {
                            j = rawQuery.getLong(0);
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "maxMsgid:", e);
                if (0 != 0) {
                    cursor.close();
                }
            }
            return j;
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    public List<DialogRecord> getDialogRecord(int i) {
        if (i == 0) {
            return null;
        }
        Parse parse = new Parse(i);
        query(TableDefine.DB_TABLE_DIALOG_RECORD, null, "localmsgid < dialogueMsgid", null, null, null, "update_time desc", parse);
        return (List) parse.getResult();
    }

    public DialogRecord getDialogRecord(int i, long j) {
        Parse parse = new Parse(1);
        query(TableDefine.DB_TABLE_DIALOG_RECORD, null, "category=? AND contacter=?", new String[]{String.valueOf(i), String.valueOf(j)}, null, null, null, parse);
        List list = (List) parse.getResult();
        if (list == null || list.size() == 0) {
            return null;
        }
        return (DialogRecord) list.get(0);
    }

    /* loaded from: classes4.dex */
    public class Parse implements CursorParse {
        int count;
        List<DialogRecord> result = null;

        public Parse(int i) {
            this.count = i;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor != null) {
                this.result = new ArrayList();
                while (cursor.moveToNext()) {
                    int i = cursor.getInt(cursor.getColumnIndex("category"));
                    long j = cursor.getLong(cursor.getColumnIndex("contacter"));
                    long j2 = cursor.getLong(cursor.getColumnIndex(TableDefine.DRColumns.COLUMN_MAXMSGID));
                    long j3 = cursor.getLong(cursor.getColumnIndex(TableDefine.DRColumns.COLUMN_DAILOGUE_MSGID));
                    int i2 = cursor.getInt(cursor.getColumnIndex("state"));
                    long j4 = cursor.getLong(cursor.getColumnIndex("update_time"));
                    int i3 = cursor.getInt(cursor.getColumnIndex(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT));
                    DialogRecord dialogRecord = new DialogRecord();
                    LogUtils.i(DialogRecordDBManager.TAG, "parseCursor dialogRecord : " + dialogRecord);
                    dialogRecord.setCategory(i).setContacter(j).setState(i2).setJumpToRecent(i3).setMaxMsgid(j2).setUpdateTime(j4).setDialogueMsgid(j3);
                    this.result.add(dialogRecord);
                }
            }
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public Object getResult() {
            return this.result;
        }
    }

    public List<DialogRecord> getUnCompleteDialogRecord() {
        Parse parse = new Parse(1);
        query(TableDefine.DB_TABLE_DIALOG_RECORD, null, "localmsgid < dialogueMsgid", null, null, null, "update_time desc", parse);
        return (List) parse.getResult();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [244=4, 245=4] */
    public int getUnCompleteItemCount() {
        Cursor cursor = null;
        int i = -1;
        try {
            try {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getWritableDb fail!");
                } else {
                    cursor = openDatabase.rawQuery("select count(*) from dialog_record where localmsgid < dialogueMsgid", null);
                    if (cursor != null) {
                        try {
                            i = cursor.moveToNext() ? cursor.getInt(0) : 0;
                        } catch (Exception e) {
                            e = e;
                            i = 0;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getUnCompleteItemCount:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return i;
                        }
                    }
                    LogUtils.i(TAG, "getUnCompleteItemCount : " + i);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            return i;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [276=4, 277=4] */
    public int getUnCompleteItemCount(long j) {
        Cursor cursor = null;
        int i = -1;
        try {
            try {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getWritableDb fail!");
                } else {
                    cursor = openDatabase.rawQuery("select count(*) from dialog_record where localmsgid < dialogueMsgid AND contacter = " + j, null);
                    if (cursor != null) {
                        try {
                            i = cursor.moveToNext() ? cursor.getInt(0) : 0;
                        } catch (Exception e) {
                            e = e;
                            i = 0;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getUnCompleteItemCount:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return i;
                        }
                    }
                    LogUtils.i(TAG, "getUnCompleteItemCount : " + i);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            return i;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
