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
/* loaded from: classes18.dex */
public class DBBase {
    public static final String TAG = DBBase.class.getSimpleName();
    protected static Object mSyncLock = new Object();
    protected Context mContext = null;

    /* loaded from: classes18.dex */
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

    public void setContext(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long insert(String str, ContentValues contentValues) {
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
            return -1L;
        }
        try {
            return openDatabase.insert(str, null, contentValues);
        } catch (Exception e) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            LogUtils.e(TAG, "saveCmdMsg:", e);
            return -1L;
        }
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, SGET, CONST_STR, INVOKE, MOVE_EXCEPTION, INVOKE, IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, SGET, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
    public int updateBatch(String str, List<UpdateArgs> list) {
        int size;
        int i = -1;
        if (!TextUtils.isEmpty(str) && list != null && (size = list.size()) != 0) {
            SQLiteDatabase openDatabase = openDatabase();
            try {
                if (openDatabase == null) {
                    LogUtils.e(TAG, "updateBatch open db = null");
                } else {
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
                }
            } finally {
                if (openDatabase != null) {
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e4) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e4)).build();
                        LogUtils.e(TAG, "updateBatch", e4);
                    }
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int delete(String str, String str2, String[] strArr) {
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
            return -1;
        }
        try {
            return openDatabase.delete(str, str2, strArr);
        } catch (Exception e) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            LogUtils.e(TAG, "deleteCmdMsg:", e);
            return -1;
        }
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=5, 169=4] */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
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
                return -1L;
            }
            try {
                long update = cursor.getCount() > 0 ? openDatabase.update(str, contentValues, str2, strArr2) : openDatabase.insert(str, null, contentValues);
                if (cursor != null) {
                    cursor.close();
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
                    return -1L;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
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
        try {
            return queryCount(openDatabase(), str, strArr, str2, strArr2);
        } catch (Exception e) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            LogUtils.e(LogUtils.TAG, "queryCount", e);
            return -1L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [206=5, 207=4] */
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [229=4] */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, CursorParse cursorParse) {
        Cursor cursor;
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            return;
        }
        try {
            cursor = openDatabase.query(str, strArr, str2, strArr2, str3, str4, str5);
            try {
                try {
                    cursorParse.parseCursor(cursor);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e) {
                    e = e;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(LogUtils.TAG, "query:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [251=4] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CursorParse cursorParse) {
        Cursor cursor;
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            return;
        }
        try {
            cursor = openDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            try {
                try {
                    cursorParse.parseCursor(cursor);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e) {
                    e = e;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(LogUtils.TAG, "query:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
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
