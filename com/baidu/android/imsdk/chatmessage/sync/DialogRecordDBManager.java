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
/* loaded from: classes6.dex */
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [110=6, 111=5, 113=5, 114=5, 115=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x0016 */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016a  */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19, types: [long] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long addBatch(List<DialogRecord> list) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        long j;
        Exception exc;
        Cursor cursor2;
        long j2;
        ?? r2;
        Cursor cursor3;
        if (list == null) {
            return -1L;
        }
        if (list.size() == 0) {
            return 0L;
        }
        Cursor cursor4 = null;
        r6 = null;
        cursor4 = null;
        Cursor cursor5 = null;
        try {
            SQLiteDatabase openDatabase = openDatabase();
            try {
                try {
                    if (openDatabase == null) {
                        LogUtils.e(TAG, "getWritableDb fail!");
                        if (0 != 0) {
                            cursor4.close();
                        }
                        if (openDatabase != null) {
                            openDatabase.endTransaction();
                            closeDatabase();
                        }
                        r2 = -1;
                    } else {
                        openDatabase.beginTransaction();
                        Iterator<DialogRecord> it = list.iterator();
                        Cursor cursor6 = null;
                        long j3 = -1;
                        while (true) {
                            try {
                                if (!it.hasNext()) {
                                    cursor2 = cursor6;
                                    j2 = j3;
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
                                        closeDatabase();
                                    }
                                    r2 = j3;
                                    cursor5 = strArr;
                                } else {
                                    try {
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put(TableDefine.DRColumns.COLUMN_MAXMSGID, Long.valueOf(next.getMaxMsgid()));
                                        contentValues.put("state", Integer.valueOf(next.getState()));
                                        contentValues.put("update_time", Long.valueOf(next.getUpdateTime()));
                                        contentValues.put(TableDefine.DRColumns.COLUMN_DAILOGUE_MSGID, Long.valueOf(next.getDialogueMsgid()));
                                        if (cursor.getCount() > 0) {
                                            contentValues.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, (Integer) 0);
                                            j3 = openDatabase.update(TableDefine.DB_TABLE_DIALOG_RECORD, contentValues, "category=? AND contacter=?", strArr);
                                        } else {
                                            contentValues.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, (Integer) 1);
                                            contentValues.put("category", Integer.valueOf(next.getCategory()));
                                            contentValues.put("contacter", Long.valueOf(next.getContacter()));
                                            j3 = openDatabase.insert(TableDefine.DB_TABLE_DIALOG_RECORD, null, contentValues);
                                        }
                                        if (cursor != null) {
                                            cursor.close();
                                            cursor3 = null;
                                        } else {
                                            cursor3 = cursor;
                                        }
                                        if (j3 < 0) {
                                            j2 = j3;
                                            cursor2 = cursor3;
                                            break;
                                        }
                                        cursor6 = cursor3;
                                    } catch (Exception e) {
                                        sQLiteDatabase = openDatabase;
                                        cursor4 = cursor;
                                        exc = e;
                                        j = j3;
                                        try {
                                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(exc)).build();
                                            LogUtils.e(TAG, "deleteCmdMsg:", exc);
                                            if (cursor4 != null) {
                                                cursor4.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.endTransaction();
                                                closeDatabase();
                                                return j;
                                            }
                                            return j;
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor = cursor4;
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.endTransaction();
                                                closeDatabase();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        sQLiteDatabase = openDatabase;
                                        th = th2;
                                        if (cursor != null) {
                                        }
                                        if (sQLiteDatabase != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Exception e2) {
                                exc = e2;
                                sQLiteDatabase = openDatabase;
                                cursor4 = cursor6;
                                j = j3;
                            } catch (Throwable th3) {
                                sQLiteDatabase = openDatabase;
                                cursor = cursor6;
                                th = th3;
                            }
                        }
                        if (j2 >= 0) {
                            try {
                                openDatabase.setTransactionSuccessful();
                            } catch (Throwable th4) {
                                sQLiteDatabase = openDatabase;
                                cursor = cursor2;
                                th = th4;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                throw th;
                            }
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (openDatabase != null) {
                            openDatabase.endTransaction();
                            closeDatabase();
                            r2 = j2;
                            cursor5 = cursor2;
                        } else {
                            r2 = j2;
                            cursor5 = cursor2;
                        }
                    }
                    return r2;
                } catch (Throwable th5) {
                    sQLiteDatabase = r2;
                    cursor = cursor5;
                    th = th5;
                }
            } catch (Exception e3) {
                j = -1;
                exc = e3;
                sQLiteDatabase = openDatabase;
            }
        } catch (Exception e4) {
            j = -1;
            exc = e4;
            sQLiteDatabase = null;
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabase = null;
            cursor = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [144=5, 145=4, 147=4, 148=4] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getMaxMsgid() {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        long j = -1;
        try {
            try {
                sQLiteDatabase = openDatabase();
                try {
                    if (sQLiteDatabase == null) {
                        LogUtils.e(TAG, "getWritableDb fail!");
                        if (0 != 0) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            closeDatabase();
                        }
                    } else {
                        cursor = sQLiteDatabase.rawQuery("select max(localmsgid) from dialog_record", null);
                        if (cursor != null) {
                            try {
                                j = cursor.moveToNext() ? cursor.getLong(0) : 0L;
                            } catch (Exception e) {
                                e = e;
                                j = 0;
                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                LogUtils.e(TAG, "maxMsgid:", e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    closeDatabase();
                                }
                                return j;
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            closeDatabase();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor.close();
                }
                if (0 != 0) {
                    closeDatabase();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            sQLiteDatabase = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            if (0 != 0) {
            }
            throw th;
        }
        return j;
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

    /* loaded from: classes6.dex */
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [248=5, 249=4, 251=4, 252=4] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getUnCompleteItemCount() {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        int i = -1;
        try {
            try {
                sQLiteDatabase = openDatabase();
                try {
                    if (sQLiteDatabase == null) {
                        LogUtils.e(TAG, "getWritableDb fail!");
                        if (0 != 0) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            closeDatabase();
                        }
                    } else {
                        cursor = sQLiteDatabase.rawQuery("select count(*) from dialog_record where localmsgid < dialogueMsgid", null);
                        if (cursor != null) {
                            try {
                                i = cursor.moveToNext() ? cursor.getInt(0) : 0;
                            } catch (Exception e) {
                                i = 0;
                                e = e;
                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                LogUtils.e(TAG, "getUnCompleteItemCount:", e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    closeDatabase();
                                }
                                return i;
                            }
                        }
                        LogUtils.i(TAG, "getUnCompleteItemCount : " + i);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            closeDatabase();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    closeDatabase();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            sQLiteDatabase = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
            if (cursor != null) {
            }
            if (sQLiteDatabase != null) {
            }
            throw th;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [283=5, 284=4, 286=4, 287=4] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getUnCompleteItemCount(long j) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        int i = -1;
        try {
            try {
                sQLiteDatabase = openDatabase();
                try {
                    if (sQLiteDatabase == null) {
                        LogUtils.e(TAG, "getWritableDb fail!");
                        if (0 != 0) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            closeDatabase();
                        }
                    } else {
                        cursor = sQLiteDatabase.rawQuery("select count(*) from dialog_record where localmsgid < dialogueMsgid AND contacter = " + j, null);
                        if (cursor != null) {
                            try {
                                i = cursor.moveToNext() ? cursor.getInt(0) : 0;
                            } catch (Exception e) {
                                i = 0;
                                e = e;
                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                LogUtils.e(TAG, "getUnCompleteItemCount:", e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    closeDatabase();
                                }
                                return i;
                            }
                        }
                        LogUtils.i(TAG, "getUnCompleteItemCount : " + i);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            closeDatabase();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    closeDatabase();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            sQLiteDatabase = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
            if (cursor != null) {
            }
            if (sQLiteDatabase != null) {
            }
            throw th;
        }
        return i;
    }
}
