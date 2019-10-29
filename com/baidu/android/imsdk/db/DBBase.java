package com.baidu.android.imsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class DBBase {
    public static final String TAG = DBBase.class.getSimpleName();
    protected static Object mSyncLock = new Object();
    protected Context mContext = null;

    /* loaded from: classes6.dex */
    public class UpdateArgs {
        public String[] args;
        public String query;
        public ContentValues values;

        public UpdateArgs(String str, String[] strArr, ContentValues contentValues) {
            this.query = str;
            this.args = strArr;
            this.values = contentValues;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SQLiteDatabase openDatabase() {
        SQLiteDatabase openDatabase;
        synchronized (mSyncLock) {
            openDatabase = DBResource.getInstance(this.mContext).openDatabase();
        }
        return openDatabase;
    }

    public void closeDatabase() {
        synchronized (mSyncLock) {
            DBResource.getInstance(this.mContext).closeDatabase();
        }
    }

    public void setContext(Context context) {
        synchronized (mSyncLock) {
            if (context != null) {
                this.mContext = context.getApplicationContext();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long insert(String str, ContentValues contentValues) {
        long j = -1;
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
        } else {
            try {
                try {
                    j = openDatabase.insert(str, null, contentValues);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "saveCmdMsg:", e);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                }
            } catch (Throwable th) {
                if (openDatabase != null) {
                    closeDatabase();
                }
                throw th;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int update(String str, String str2, String[] strArr, ContentValues contentValues) {
        UpdateArgs updateArgs = new UpdateArgs(str2, strArr, contentValues);
        ArrayList arrayList = new ArrayList();
        if (arrayList.add(updateArgs)) {
            return updateBatch(str, arrayList);
        }
        return -1;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, SGET, CONST_STR, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, SGET, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
    public int updateBatch(String str, List<UpdateArgs> list) {
        int size;
        int i = -1;
        if (!TextUtils.isEmpty(str) && list != null && (size = list.size()) != 0) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "updateBatch open db = null");
            } else {
                try {
                    try {
                        openDatabase.beginTransaction();
                        Iterator<UpdateArgs> it = list.iterator();
                        while (true) {
                            try {
                                size = i;
                                if (!it.hasNext()) {
                                    i = size;
                                    break;
                                }
                                UpdateArgs next = it.next();
                                i = openDatabase.update(str, next.values, next.query, next.args);
                                if (i < 0) {
                                    break;
                                }
                            } catch (Exception e) {
                                i = size;
                                e = e;
                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                LogUtils.e(TAG, String.format("update table %s exception!", str), e);
                                if (openDatabase != null) {
                                    try {
                                        openDatabase.endTransaction();
                                        closeDatabase();
                                    } catch (Exception e2) {
                                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                                        LogUtils.e(TAG, "updateBatch", e2);
                                    }
                                }
                                return i;
                            }
                        }
                        if (i >= 0) {
                            openDatabase.setTransactionSuccessful();
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } finally {
                    if (openDatabase != null) {
                        try {
                            openDatabase.endTransaction();
                            closeDatabase();
                        } catch (Exception e4) {
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e4)).build();
                            LogUtils.e(TAG, "updateBatch", e4);
                        }
                    }
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int delete(String str, String str2, String[] strArr) {
        SQLiteDatabase openDatabase = openDatabase();
        int i = -1;
        if (openDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
        } else {
            try {
                try {
                    i = openDatabase.delete(str, str2, strArr);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(TAG, "deleteCmdMsg:", e);
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                }
            } catch (Throwable th) {
                if (openDatabase != null) {
                    closeDatabase();
                }
                throw th;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int delete(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        if (sQLiteDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
            return -1;
        }
        try {
            return sQLiteDatabase.delete(str, str2, strArr);
        } catch (Exception e) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            LogUtils.e(TAG, "deleteCmdMsg:", e);
            return -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [185=5, 186=4, 188=4, 189=4] */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long add(String str, String[] strArr, String str2, String[] strArr2, ContentValues contentValues) {
        Cursor cursor;
        Cursor cursor2;
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
            return -1L;
        }
        try {
            cursor = openDatabase.query(str, strArr, str2, strArr2, null, null, null);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                if (openDatabase != null) {
                    closeDatabase();
                }
                return -1L;
            }
            try {
                long update = cursor.getCount() > 0 ? openDatabase.update(str, contentValues, str2, strArr2) : openDatabase.insert(str, null, contentValues);
                if (cursor != null) {
                    cursor.close();
                }
                if (openDatabase != null) {
                    closeDatabase();
                    return update;
                }
                return update;
            } catch (Exception e) {
                e = e;
                cursor2 = cursor;
                try {
                    LogUtils.e(TAG, "deleteCmdMsg:", e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                    return -1L;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (openDatabase != null) {
                        closeDatabase();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
                if (openDatabase != null) {
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long queryCount(String str, String[] strArr, String str2, String[] strArr2) {
        SQLiteDatabase openDatabase = openDatabase();
        try {
            try {
                long queryCount = queryCount(openDatabase, str, strArr, str2, strArr2);
                if (openDatabase != null) {
                    closeDatabase();
                }
                return queryCount;
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "queryCount", e);
                if (openDatabase != null) {
                    closeDatabase();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (openDatabase != null) {
                closeDatabase();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [230=5, 231=4] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected long queryCount(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2) {
        Cursor cursor;
        if (sQLiteDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
            return -1L;
        }
        try {
            Cursor query = sQLiteDatabase.query(str, strArr, str2, strArr2, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return -1L;
            }
            try {
                long count = query.getCount();
                if (query != null) {
                    query.close();
                    return count;
                }
                return count;
            } catch (Exception e) {
                e = e;
                cursor = query;
                try {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(LogUtils.TAG, "queryCount", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1L;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0055 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0011 */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, CursorParse cursorParse) {
        Cursor cursor;
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            return;
        }
        String str6 = str;
        try {
            try {
                cursor = openDatabase.query(str6, strArr, str2, strArr2, str3, str4, str5);
                try {
                    cursorParse.parseCursor(cursor);
                    if (cursor != null) {
                        cursor.close();
                    }
                    closeDatabase();
                    str6 = cursor;
                } catch (Exception e) {
                    e = e;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(LogUtils.TAG, "query:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    closeDatabase();
                    str6 = cursor;
                }
            } catch (Throwable th) {
                th = th;
                if (str6 != 0) {
                    str6.close();
                }
                closeDatabase();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            str6 = 0;
            if (str6 != 0) {
            }
            closeDatabase();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [276=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0056 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0058 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0014 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CursorParse cursorParse) {
        Cursor cursor;
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            return;
        }
        String str7 = str;
        try {
            try {
                cursor = openDatabase.query(str7, strArr, str2, strArr2, str3, str4, str5, str6);
                try {
                    cursorParse.parseCursor(cursor);
                    if (cursor != null) {
                        cursor.close();
                    }
                    closeDatabase();
                    str7 = cursor;
                } catch (Exception e) {
                    e = e;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(LogUtils.TAG, "query:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    closeDatabase();
                    str7 = cursor;
                }
            } catch (Throwable th) {
                th = th;
                if (str7 != 0) {
                    str7.close();
                }
                closeDatabase();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            str7 = 0;
            if (str7 != 0) {
            }
            closeDatabase();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String makePlaceholders(int i) {
        if (i < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder((i * 2) - 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, SGET, CONST_STR, INVOKE, MOVE_EXCEPTION, INVOKE, SGET, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0008 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    protected Long querymax(String str) {
        Cursor cursor = null;
        cursor = null;
        long j = 0;
        try {
            try {
                cursor = openDatabase().rawQuery(str, null);
                cursor.moveToFirst();
                j = cursor.getLong(0);
                cursor = cursor;
                if (cursor != null) {
                    try {
                        cursor.close();
                        cursor = cursor;
                    } catch (Exception e) {
                        LogUtils.e(TAG, "close curse exception");
                        cursor = "close curse exception";
                    }
                }
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "querymax " + e2.getMessage());
                cursor = cursor;
                if (cursor != null) {
                    try {
                        cursor.close();
                        cursor = cursor;
                    } catch (Exception e3) {
                        LogUtils.e(TAG, "close curse exception");
                        cursor = "close curse exception";
                    }
                }
            }
            return Long.valueOf(j);
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                    LogUtils.e(TAG, "close curse exception");
                }
            }
            throw th;
        }
    }
}
