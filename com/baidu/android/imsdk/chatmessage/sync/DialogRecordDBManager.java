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
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class DialogRecordDBManager extends DBBase {
    public static final String TAG = "DialogRecordDBManager";
    public static DialogRecordDBManager mInstance;

    /* loaded from: classes.dex */
    public class Parse implements CursorParse {
        public int count;
        public List<DialogRecord> result = null;

        public Parse(int i) {
            this.count = i;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public Object getResult() {
            return this.result;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Cursor cursor2 = cursor;
            if (cursor2 != null) {
                this.result = new ArrayList();
                while (cursor.moveToNext()) {
                    int i = cursor2.getInt(cursor2.getColumnIndex("category"));
                    long j = cursor2.getLong(cursor2.getColumnIndex("contacter"));
                    long j2 = cursor2.getLong(cursor2.getColumnIndex(TableDefine.DRColumns.COLUMN_MAXMSGID));
                    long j3 = cursor2.getLong(cursor2.getColumnIndex(TableDefine.DRColumns.COLUMN_DAILOGUE_MSGID));
                    int i2 = cursor2.getInt(cursor2.getColumnIndex("state"));
                    long j4 = cursor2.getLong(cursor2.getColumnIndex("update_time"));
                    int i3 = cursor2.getInt(cursor2.getColumnIndex(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT));
                    DialogRecord dialogRecord = new DialogRecord();
                    String str = DialogRecordDBManager.TAG;
                    LogUtils.i(str, "parseCursor dialogRecord : " + dialogRecord);
                    dialogRecord.setCategory(i).setContacter(j).setState(i2).setJumpToRecent(i3).setMaxMsgid(j2).setUpdateTime(j4).setDialogueMsgid(j3);
                    this.result.add(dialogRecord);
                    cursor2 = cursor;
                }
            }
        }
    }

    public DialogRecordDBManager(Context context) {
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
        String str = TAG;
        LogUtils.i(str, "add DialogRecord : " + dialogRecord);
        LinkedList linkedList = new LinkedList();
        linkedList.add(dialogRecord);
        return addBatch(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long addBatch(List<DialogRecord> list) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        long j = -1;
        if (list == null) {
            return -1L;
        }
        long j2 = 0;
        if (list.size() == 0) {
            return 0L;
        }
        Cursor cursor2 = null;
        try {
            try {
                sQLiteDatabase = openDatabase();
                try {
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e3) {
            e = e3;
            sQLiteDatabase = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            LogUtils.e(TAG, "getWritableDb fail!");
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            return -1L;
        }
        sQLiteDatabase.beginTransaction();
        Iterator<DialogRecord> it = list.iterator();
        Cursor cursor3 = null;
        while (true) {
            try {
                if (!it.hasNext()) {
                    cursor = cursor3;
                    break;
                }
                DialogRecord next = it.next();
                String[] strArr = {String.valueOf(next.getCategory()), String.valueOf(next.getContacter())};
                Cursor query = sQLiteDatabase.query(TableDefine.DB_TABLE_DIALOG_RECORD, null, "category=? AND contacter=?", strArr, null, null, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    return j;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(TableDefine.DRColumns.COLUMN_MAXMSGID, Long.valueOf(next.getMaxMsgid()));
                    contentValues.put("state", Integer.valueOf(next.getState()));
                    contentValues.put("update_time", Long.valueOf(next.getUpdateTime()));
                    contentValues.put(TableDefine.DRColumns.COLUMN_DAILOGUE_MSGID, Long.valueOf(next.getDialogueMsgid()));
                    if (query.getCount() > 0) {
                        contentValues.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, (Integer) 0);
                        j = sQLiteDatabase.update(TableDefine.DB_TABLE_DIALOG_RECORD, contentValues, "category=? AND contacter=?", strArr);
                    } else {
                        contentValues.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, (Integer) 1);
                        contentValues.put("category", Integer.valueOf(next.getCategory()));
                        contentValues.put("contacter", Long.valueOf(next.getContacter()));
                        j = sQLiteDatabase.insert(TableDefine.DB_TABLE_DIALOG_RECORD, null, contentValues);
                    }
                    if (query != null) {
                        query.close();
                        cursor3 = null;
                    } else {
                        cursor3 = query;
                    }
                    if (j < 0) {
                        cursor = cursor3;
                        j2 = 0;
                        break;
                    }
                    j2 = 0;
                } catch (Exception e4) {
                    e = e4;
                    cursor2 = query;
                    try {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "deleteCmdMsg:", e);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        return j;
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor2 = query;
                    if (cursor2 != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                cursor2 = cursor3;
            } catch (Throwable th5) {
                th = th5;
                cursor2 = cursor3;
            }
        }
        if (j >= j2) {
            sQLiteDatabase.setTransactionSuccessful();
        }
        if (cursor != null) {
            cursor.close();
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.endTransaction();
        }
        return j;
    }

    public int delete(int i, long j) {
        int delete = delete(TableDefine.DB_TABLE_DIALOG_RECORD, "category=? AND contacter=?", new String[]{String.valueOf(i), String.valueOf(j)});
        LogUtils.d("delete dialog record ", delete + GlideException.IndentedAppendable.INDENT + j + i);
        return delete;
    }

    public List<DialogRecord> getDialogRecord(int i) {
        if (i == 0) {
            return null;
        }
        Parse parse = new Parse(i);
        query(TableDefine.DB_TABLE_DIALOG_RECORD, null, "localmsgid < dialogueMsgid", null, null, null, "update_time desc", parse);
        return (List) parse.getResult();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
        if (0 == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getMaxMsgid() {
        Cursor cursor = null;
        long j = -1;
        try {
            try {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getWritableDb fail!");
                    return -1L;
                }
                cursor = openDatabase.rawQuery("select max(localmsgid) from dialog_record", null);
                if (cursor != null) {
                    j = 0;
                    if (cursor.moveToNext()) {
                        j = cursor.getLong(0);
                    }
                }
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "maxMsgid:", e2);
            }
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    public List<DialogRecord> getUnCompleteDialogRecord() {
        Parse parse = new Parse(1);
        query(TableDefine.DB_TABLE_DIALOG_RECORD, null, "localmsgid < dialogueMsgid", null, null, null, "update_time desc", parse);
        return (List) parse.getResult();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0068 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getUnCompleteItemCount() {
        int i = 0;
        Cursor cursor = null;
        int i2 = -1;
        try {
            try {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getWritableDb fail!");
                    return -1;
                }
                cursor = openDatabase.rawQuery("select count(*) from dialog_record where localmsgid < dialogueMsgid", null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            i = cursor.getInt(0);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        i2 = 0;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getUnCompleteItemCount:", e);
                        return i2;
                    }
                } else {
                    i = -1;
                }
                try {
                    String str = TAG;
                    LogUtils.i(str, "getUnCompleteItemCount : " + i);
                    if (cursor != null) {
                        cursor.close();
                        return i;
                    }
                    return i;
                } catch (Exception e3) {
                    i2 = i;
                    e = e3;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "getUnCompleteItemCount:", e);
                    return i2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
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

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
        if (r1 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getUnCompleteItemCount(long j) {
        int i = 0;
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getWritableDb fail!");
                    return -1;
                }
                cursor = openDatabase.rawQuery("select count(*) from dialog_record where localmsgid < dialogueMsgid AND contacter = " + j, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            i = cursor.getInt(0);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getUnCompleteItemCount:", e);
                    }
                } else {
                    i = -1;
                }
                String str = TAG;
                LogUtils.i(str, "getUnCompleteItemCount : " + i);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (Exception e3) {
            e = e3;
            i = -1;
        }
    }
}
