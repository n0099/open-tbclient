package com.baidu.clientupdate.download;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.util.LogUtil;
/* loaded from: classes5.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static a f1736a = null;

    /* renamed from: b  reason: collision with root package name */
    private Context f1737b;

    public a(Context context) {
        super(context, "lcupdatedown.db", (SQLiteDatabase.CursorFactory) null, 3);
        this.f1737b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f1736a == null) {
                f1736a = new a(context);
            }
            aVar = f1736a;
        }
        return aVar;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            sQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, _data TEXT, saved_path_for_user TEXT, mimetype TEXT, etag TEXT, visibility INTEGER, status INTEGER, total_bytes INTEGER, current_bytes INTEGER, notificationneeded INTEGER, notificationshowed BOOLEAN NOT NULL DEFAULT 0, saved_source_key_user TEXT, failreason TEXT);");
        } catch (SQLException e) {
            LogUtil.logE("DownloadDBHelper", "couldn't create table in downloads database");
        }
    }

    static String b(long[] jArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                sb.append("OR ");
            }
            sb.append(IMConstants.MSG_ROW_ID);
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS logs");
            sQLiteDatabase.execSQL("CREATE TABLE logs(ug TEXT,nm TEXT, sessioninfo TEXT, stm TEXT, sc TEXT, etm TEXT, mg TEXT, ex TEXT,flag TEXT  DEFAULT '0',PRIMARY KEY(nm));");
        } catch (SQLException e) {
            LogUtil.logE("DownloadDBHelper", "couldn't create table in logs database");
        }
    }

    private ContentValues c(com.baidu.clientupdate.a.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ug", aVar.f1707b);
        contentValues.put("sessioninfo", aVar.f1706a + "\"tm\":\"" + (System.currentTimeMillis() / 1000) + "\"}");
        contentValues.put("nm", aVar.c);
        contentValues.put("stm", aVar.e.toString());
        contentValues.put(Config.STAT_SDK_CHANNEL, aVar.f.toString());
        contentValues.put("etm", aVar.g.toString());
        contentValues.put("mg", aVar.h.toString());
        contentValues.put(Config.EXCEPTION_PART, aVar.i.toString());
        return contentValues;
    }

    private ContentValues c(Download download) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", download.mFileName);
        contentValues.put("saved_path_for_user", download.mSavedPath);
        contentValues.put(DownloadDataConstants.Columns.COLUMN_URI, download.mUrl);
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, download.mMimeType);
        contentValues.put("etag", download.mETag);
        contentValues.put("status", Integer.valueOf(download.mState.ordinal()));
        contentValues.put("total_bytes", Long.valueOf(download.mFileLength));
        contentValues.put(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, Long.valueOf(download.mCurrentLength));
        contentValues.put("notificationneeded", Integer.valueOf(download.mNeedNotification ? 1 : 0));
        contentValues.put("notificationshowed", Boolean.valueOf(download.mNotificationShowed));
        contentValues.put("saved_source_key_user", download.mSourceKey);
        contentValues.put("failreason", download.mFailReason);
        return contentValues;
    }

    static String[] c(long[] jArr) {
        String[] strArr = new String[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            strArr[i] = Long.toString(jArr[i]);
        }
        return strArr;
    }

    public int a(long... jArr) {
        int i = 0;
        if (jArr == null || jArr.length == 0) {
            return 0;
        }
        try {
            SQLiteDatabase writableDatabase = a(this.f1737b).getWritableDatabase();
            writableDatabase.beginTransaction();
            i = writableDatabase.delete("downloads", b(jArr), c(jArr));
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return i;
        } catch (Exception e) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
            return i;
        }
    }

    public long a(com.baidu.clientupdate.a.a aVar) {
        long j = -1;
        try {
            SQLiteDatabase writableDatabase = a(this.f1737b).getWritableDatabase();
            ContentValues c = c(aVar);
            writableDatabase.beginTransaction();
            j = writableDatabase.insert("logs", null, c);
            com.baidu.util.a.a(this.f1737b).b("lcsdk_xml", "time", System.currentTimeMillis());
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return j;
        } catch (Exception e) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
            return j;
        }
    }

    public long a(Download download) {
        long j = -1;
        try {
            SQLiteDatabase writableDatabase = a(this.f1737b).getWritableDatabase();
            ContentValues c = c(download);
            writableDatabase.beginTransaction();
            j = writableDatabase.insert("downloads", null, c);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            download.mId = j;
            return j;
        } catch (Exception e) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
            return j;
        }
    }

    public Cursor a() {
        Exception e;
        Cursor cursor;
        try {
            SQLiteDatabase readableDatabase = a(this.f1737b).getReadableDatabase();
            readableDatabase.beginTransaction();
            Cursor query = readableDatabase.query("downloads", null, null, null, null, null, null);
            try {
                readableDatabase.setTransactionSuccessful();
                readableDatabase.endTransaction();
                return query;
            } catch (Exception e2) {
                e = e2;
                cursor = query;
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
                if (cursor != null) {
                    cursor.close();
                    return cursor;
                }
                return cursor;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        }
    }

    public Cursor a(String str) {
        Exception e;
        Cursor cursor;
        IllegalStateException e2;
        Cursor cursor2;
        SQLiteDatabase readableDatabase;
        Cursor query;
        try {
            readableDatabase = a(this.f1737b).getReadableDatabase();
            readableDatabase.beginTransaction();
            query = readableDatabase.query("logs", null, "nm=?", new String[]{str}, null, null, null);
        } catch (IllegalStateException e3) {
            e2 = e3;
            cursor2 = null;
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        }
        try {
            readableDatabase.setTransactionSuccessful();
            readableDatabase.endTransaction();
            return query;
        } catch (IllegalStateException e5) {
            e2 = e5;
            cursor2 = query;
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            if (cursor2 != null) {
                cursor2.close();
            }
            b();
            return cursor2;
        } catch (Exception e6) {
            e = e6;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
            return cursor;
        }
    }

    public int b() {
        int i = 0;
        try {
            SQLiteDatabase writableDatabase = a(this.f1737b).getWritableDatabase();
            writableDatabase.beginTransaction();
            i = writableDatabase.delete("logs", null, null);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return i;
        } catch (Exception e) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
            return i;
        }
    }

    public void b(com.baidu.clientupdate.a.a aVar) {
        try {
            SQLiteDatabase writableDatabase = a(this.f1737b).getWritableDatabase();
            writableDatabase.beginTransaction();
            writableDatabase.update("logs", c(aVar), "nm = ?", new String[]{aVar.c});
            com.baidu.util.a.a(this.f1737b).b("lcsdk_xml", "time", System.currentTimeMillis());
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (IllegalStateException e) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
            b();
        } catch (Exception e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
        }
    }

    public void b(Download download) {
        try {
            SQLiteDatabase writableDatabase = a(this.f1737b).getWritableDatabase();
            writableDatabase.beginTransaction();
            writableDatabase.update("downloads", c(download), "_id = ?", new String[]{Long.toString(download.mId)});
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Exception e) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
        }
    }

    public int c() {
        int i = 0;
        try {
            SQLiteDatabase writableDatabase = a(this.f1737b).getWritableDatabase();
            writableDatabase.beginTransaction();
            i = writableDatabase.delete("logs", "flag=?", new String[]{"1"});
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return i;
        } catch (Exception e) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
            return i;
        }
    }

    public void d() {
        try {
            SQLiteDatabase writableDatabase = a(this.f1737b).getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(FrsActivityConfig.FLAG, "1");
            writableDatabase.update("logs", contentValues, null, null);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (IllegalStateException e) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
            b();
        } catch (Exception e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
        }
    }

    public void e() {
        try {
            SQLiteDatabase writableDatabase = a(this.f1737b).getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(FrsActivityConfig.FLAG, "0");
            writableDatabase.update("logs", contentValues, null, null);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (IllegalStateException e) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
            b();
        } catch (Exception e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
        }
    }

    public Cursor f() {
        Exception e;
        Cursor cursor;
        IllegalStateException e2;
        Cursor cursor2;
        try {
            SQLiteDatabase readableDatabase = a(this.f1737b).getReadableDatabase();
            readableDatabase.beginTransaction();
            Cursor query = readableDatabase.query("logs", null, null, null, null, null, null);
            try {
                readableDatabase.setTransactionSuccessful();
                readableDatabase.endTransaction();
                return query;
            } catch (IllegalStateException e3) {
                e2 = e3;
                cursor2 = query;
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                if (cursor2 != null) {
                    cursor2.close();
                }
                b();
                return cursor2;
            } catch (Exception e4) {
                e = e4;
                cursor = query;
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
                if (cursor != null) {
                    cursor.close();
                    return cursor;
                }
                return cursor;
            }
        } catch (IllegalStateException e5) {
            e2 = e5;
            cursor2 = null;
        } catch (Exception e6) {
            e = e6;
            cursor = null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x006c: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:26:0x006c */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g() {
        Cursor cursor;
        Cursor cursor2;
        boolean z;
        Cursor cursor3 = null;
        try {
            try {
                try {
                    SQLiteDatabase readableDatabase = a(this.f1737b).getReadableDatabase();
                    readableDatabase.beginTransaction();
                    cursor2 = readableDatabase.query("logs", null, "nm=?", new String[]{"a6"}, null, null, null);
                    try {
                        readableDatabase.setTransactionSuccessful();
                        readableDatabase.endTransaction();
                    } catch (IllegalStateException e) {
                        e = e;
                        LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
                        b();
                        if (cursor2 != null) {
                            cursor2.close();
                            return false;
                        }
                        z = false;
                        return z;
                    } catch (Exception e2) {
                        e = e2;
                        cursor3 = cursor2;
                        LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
                        if (cursor3 != null) {
                            cursor3.close();
                            z = false;
                            return z;
                        }
                        z = false;
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    throw th;
                }
            } catch (IllegalStateException e3) {
                e = e3;
                cursor2 = null;
            } catch (Exception e4) {
                e = e4;
            }
            if (cursor2 != null) {
                if (cursor2.getCount() != 0) {
                    z = true;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return z;
                }
            }
            z = false;
            if (cursor2 != null) {
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            cursor3 = cursor;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x006c: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:26:0x006c */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h() {
        Cursor cursor;
        Cursor cursor2;
        boolean z;
        Cursor cursor3 = null;
        try {
            try {
                try {
                    SQLiteDatabase readableDatabase = a(this.f1737b).getReadableDatabase();
                    readableDatabase.beginTransaction();
                    cursor2 = readableDatabase.query("logs", null, "nm=?", new String[]{"a9"}, null, null, null);
                    try {
                        readableDatabase.setTransactionSuccessful();
                        readableDatabase.endTransaction();
                    } catch (IllegalStateException e) {
                        e = e;
                        LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
                        b();
                        if (cursor2 != null) {
                            cursor2.close();
                            return false;
                        }
                        z = false;
                        return z;
                    } catch (Exception e2) {
                        e = e2;
                        cursor3 = cursor2;
                        LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e));
                        if (cursor3 != null) {
                            cursor3.close();
                            z = false;
                            return z;
                        }
                        z = false;
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    throw th;
                }
            } catch (IllegalStateException e3) {
                e = e3;
                cursor2 = null;
            } catch (Exception e4) {
                e = e4;
            }
            if (cursor2 != null) {
                if (cursor2.getCount() != 0) {
                    z = true;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return z;
                }
            }
            z = false;
            if (cursor2 != null) {
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            cursor3 = cursor;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        LogUtil.logD("DownloadDBHelper", "populating new database");
        a(sQLiteDatabase);
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        LogUtil.logD("DownloadDBHelper", i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
        onCreate(sQLiteDatabase);
    }
}
