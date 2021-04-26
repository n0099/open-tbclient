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
import java.util.List;
/* loaded from: classes.dex */
public class DBBase {
    public static final String TAG = "DBBase";
    public static Object mSyncLock = new Object();
    public Context mContext = null;

    /* loaded from: classes.dex */
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

    public long add(String str, String[] strArr, String str2, String[] strArr2, ContentValues contentValues) {
        long insert;
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
            return -1L;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor query = openDatabase.query(str, strArr, str2, strArr2, null, null, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return -1L;
                }
                try {
                    if (query.getCount() > 0) {
                        insert = openDatabase.update(str, contentValues, str2, strArr2);
                    } else {
                        insert = openDatabase.insert(str, null, contentValues);
                    }
                    if (query != null) {
                        query.close();
                    }
                    return insert;
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    LogUtils.e(TAG, "deleteCmdMsg:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1L;
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public int delete(String str, String str2, String[] strArr) {
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
            return -1;
        }
        try {
            return openDatabase.delete(str, str2, strArr);
        } catch (Exception e2) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            LogUtils.e(TAG, "deleteCmdMsg:", e2);
            return -1;
        }
    }

    public long insert(String str, ContentValues contentValues) {
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
            return -1L;
        }
        try {
            return openDatabase.insert(str, null, contentValues);
        } catch (Exception e2) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            LogUtils.e(TAG, "saveCmdMsg:", e2);
            return -1L;
        }
    }

    public String makePlaceholders(int i2) {
        if (i2 < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder((i2 * 2) - 1);
        sb.append("?");
        for (int i3 = 1; i3 < i2; i3++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public SQLiteDatabase openDatabase() {
        SQLiteDatabase openDatabase;
        synchronized (mSyncLock) {
            openDatabase = DBResource.getInstance(this.mContext).openDatabase();
        }
        return openDatabase;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, CursorParse cursorParse) {
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = openDatabase.query(str, strArr, str2, strArr2, str3, str4, str5);
                cursorParse.parseCursor(cursor);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            try {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(LogUtils.TAG, "query:", e2);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
                throw th;
            }
        }
    }

    public long queryCount(String str, String[] strArr, String str2, String[] strArr2) {
        try {
            return queryCount(openDatabase(), str, strArr, str2, strArr2);
        } catch (Exception e2) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            LogUtils.e(LogUtils.TAG, "queryCount", e2);
            return -1L;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, SGET, INVOKE, INVOKE, SGET, INVOKE] complete} */
    public Long querymax(String str) {
        long j;
        Cursor cursor = null;
        try {
            try {
                cursor = openDatabase().rawQuery(str, null);
                cursor.moveToFirst();
                j = cursor.getLong(0);
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused) {
                        LogUtils.e(TAG, "close curse exception");
                    }
                }
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                String str2 = TAG;
                LogUtils.e(str2, "querymax " + e2.getMessage());
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                        LogUtils.e(TAG, "close curse exception");
                    }
                }
                j = 0;
            }
            return Long.valueOf(j);
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused3) {
                    LogUtils.e(TAG, "close curse exception");
                }
            }
            throw th;
        }
    }

    public void setContext(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
    }

    public int update(String str, String str2, String[] strArr, ContentValues contentValues) {
        UpdateArgs updateArgs = new UpdateArgs(str2, strArr, contentValues);
        ArrayList arrayList = new ArrayList();
        if (arrayList.add(updateArgs)) {
            return updateBatch(str, arrayList);
        }
        return -1;
    }

    public int updateBatch(String str, List<UpdateArgs> list) {
        IMTrack.CrashBuilder crashBuilder;
        int i2 = -1;
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return -1;
        }
        SQLiteDatabase openDatabase = openDatabase();
        try {
            if (openDatabase == null) {
                LogUtils.e(TAG, "updateBatch open db = null");
                return -1;
            }
            try {
                openDatabase.beginTransaction();
                for (UpdateArgs updateArgs : list) {
                    i2 = openDatabase.update(str, updateArgs.values, updateArgs.query, updateArgs.args);
                    if (i2 < 0) {
                        break;
                    }
                }
                if (i2 >= 0) {
                    openDatabase.setTransactionSuccessful();
                }
                if (openDatabase != null) {
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e2) {
                        e = e2;
                        crashBuilder = new IMTrack.CrashBuilder(this.mContext);
                        crashBuilder.exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "updateBatch", e);
                        return i2;
                    }
                }
            } catch (Exception e3) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                LogUtils.e(TAG, String.format("update table %s exception!", str), e3);
                if (openDatabase != null) {
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e4) {
                        e = e4;
                        crashBuilder = new IMTrack.CrashBuilder(this.mContext);
                        crashBuilder.exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "updateBatch", e);
                        return i2;
                    }
                }
            }
            return i2;
        } catch (Throwable th) {
            if (openDatabase != null) {
                try {
                    openDatabase.endTransaction();
                } catch (Exception e5) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e5)).build();
                    LogUtils.e(TAG, "updateBatch", e5);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long queryCount(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2) {
        if (sQLiteDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
            return -1L;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor query = sQLiteDatabase.query(str, strArr, str2, strArr2, null, null, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return -1L;
                }
                long count = query.getCount();
                if (query != null) {
                    query.close();
                }
                return count;
            } catch (Exception e2) {
                try {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "queryCount", e2);
                    if (0 != 0) {
                        cursor.close();
                    }
                    return -1L;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
    }

    public int delete(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        if (sQLiteDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
            return -1;
        }
        try {
            return sQLiteDatabase.delete(str, str2, strArr);
        } catch (Exception e2) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            LogUtils.e(TAG, "deleteCmdMsg:", e2);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CursorParse cursorParse) {
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = openDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
                cursorParse.parseCursor(cursor);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            try {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(LogUtils.TAG, "query:", e2);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
                throw th;
            }
        }
    }
}
