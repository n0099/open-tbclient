package com.baidu.searchbox.aideviceperformance.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baidu.searchbox.aideviceperformance.utils.Config;
/* loaded from: classes3.dex */
public abstract class DataBaseOpenHelper extends SQLiteOpenHelper {
    public static final boolean DEBUG = Config.isDebug();
    public static final String TAG = "DataBaseOpenHelper";
    public OnSqliteUpdateListener onSqliteUpdateListener;

    /* loaded from: classes3.dex */
    public interface OnSqliteUpdateListener {
        void onSqliteUpdateListener(SQLiteDatabase sQLiteDatabase, int i, int i2);
    }

    public abstract String getBatchDeleteSqlStr();

    public abstract int getRestrictionNum();

    public Boolean isEnableCountRestriction() {
        return Boolean.FALSE;
    }

    public DataBaseOpenHelper(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void delete(String str, String str2, String[] strArr) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                synchronized (this) {
                    sQLiteDatabase = getWritableDatabase();
                    sQLiteDatabase.delete(str, str2, strArr);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.w(TAG, "", e);
                }
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        OnSqliteUpdateListener onSqliteUpdateListener = this.onSqliteUpdateListener;
        if (onSqliteUpdateListener != null) {
            onSqliteUpdateListener.onSqliteUpdateListener(sQLiteDatabase, i, i2);
        }
    }

    public void deleteAll(String str) {
        delete(str, null, null);
    }

    public void setOnSqliteUpdateListener(OnSqliteUpdateListener onSqliteUpdateListener) {
        this.onSqliteUpdateListener = onSqliteUpdateListener;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void execSQL(String str, Object[] objArr) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                synchronized (this) {
                    sQLiteDatabase = getWritableDatabase();
                    sQLiteDatabase.execSQL(str, objArr);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.w(TAG, "", e);
                }
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    public Cursor query(String str, String str2) {
        Cursor query;
        try {
            synchronized (this) {
                query = getReadableDatabase().query(str, null, str2, null, null, null, null);
            }
            return query;
        } catch (Exception e) {
            if (DEBUG) {
                Log.w(TAG, "", e);
                return null;
            }
            return null;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        Cursor rawQuery;
        try {
            synchronized (this) {
                rawQuery = getReadableDatabase().rawQuery(str, strArr);
            }
            return rawQuery;
        } catch (Exception e) {
            if (DEBUG) {
                Log.w(TAG, "", e);
                return null;
            }
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x00b0 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a5, code lost:
        if (r9 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a7, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c4, code lost:
        if (r9 != null) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00ac: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:43:0x00ac */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cb A[Catch: all -> 0x00cf, TryCatch #9 {, blocks: (B:40:0x00a7, B:57:0x00c7, B:60:0x00cb, B:61:0x00ce), top: B:76:0x0002 }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void insert(String str, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase;
        Object[] objArr;
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase2 = 0;
            r0 = null;
            r0 = null;
            Cursor cursor = null;
            try {
                try {
                    sQLiteDatabase = getWritableDatabase();
                    try {
                        sQLiteDatabase.insert(str, null, contentValues);
                        try {
                            if (isEnableCountRestriction().booleanValue()) {
                                try {
                                    cursor = sQLiteDatabase.query(str, new String[]{"count(*)"}, null, null, null, null, null);
                                    cursor.moveToFirst();
                                    int i = cursor.getInt(0);
                                    if (DEBUG) {
                                        Log.d(TAG, "db name: " + getDatabaseName() + " total count: " + i);
                                    }
                                    if (i > getRestrictionNum()) {
                                        String batchDeleteSqlStr = getBatchDeleteSqlStr();
                                        if (DEBUG) {
                                            Log.d(TAG, "delete sql str: " + batchDeleteSqlStr);
                                        }
                                        sQLiteDatabase.execSQL(batchDeleteSqlStr);
                                    }
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e) {
                                            e = e;
                                            e.printStackTrace();
                                        }
                                    }
                                } catch (Exception e2) {
                                    if (DEBUG) {
                                        Log.w(TAG, "", e2);
                                    }
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e3) {
                                            e = e3;
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        if (0 != 0) {
                            sQLiteDatabase2.close();
                        }
                        if (DEBUG) {
                            Log.w(TAG, "", e);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase2 = objArr;
                    if (sQLiteDatabase2 != 0) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                sQLiteDatabase = null;
            } catch (Throwable th3) {
                th = th3;
                if (sQLiteDatabase2 != 0) {
                }
                throw th;
            }
        }
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        Cursor query;
        try {
            synchronized (this) {
                query = getReadableDatabase().query(str, strArr, str2, strArr2, str3, str4, str5);
            }
            return query;
        } catch (Exception e) {
            if (DEBUG) {
                Log.w(TAG, "", e);
                return null;
            }
            return null;
        }
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        Cursor query;
        try {
            synchronized (this) {
                query = getReadableDatabase().query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return query;
        } catch (Exception e) {
            if (DEBUG) {
                Log.w(TAG, "", e);
                return null;
            }
            return null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                synchronized (this) {
                    sQLiteDatabase = getWritableDatabase();
                    sQLiteDatabase.update(str, contentValues, str2, strArr);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.w(TAG, "", e);
                }
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }
}
