package com.baidu.clientupdate.download;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.appcompat.widget.SearchView;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.util.LogUtil;
/* loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static a f4633a;

    /* renamed from: b  reason: collision with root package name */
    public Context f4634b;

    public a(Context context) {
        super(context, "lcupdatedown.db", (SQLiteDatabase.CursorFactory) null, 3);
        this.f4634b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f4633a == null) {
                f4633a = new a(context);
            }
            aVar = f4633a;
        }
        return aVar;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            sQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, _data TEXT, saved_path_for_user TEXT, mimetype TEXT, etag TEXT, visibility INTEGER, status INTEGER, total_bytes INTEGER, current_bytes INTEGER, notificationneeded INTEGER, notificationshowed BOOLEAN NOT NULL DEFAULT 0, saved_source_key_user TEXT, failreason TEXT);");
        } catch (SQLException unused) {
            LogUtil.logE("DownloadDBHelper", "couldn't create table in downloads database");
        }
    }

    public static String b(long[] jArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (i2 > 0) {
                sb.append("OR ");
            }
            sb.append("_id");
            sb.append(" = ? ");
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS logs");
            sQLiteDatabase.execSQL("CREATE TABLE logs(ug TEXT,nm TEXT, sessioninfo TEXT, stm TEXT, sc TEXT, etm TEXT, mg TEXT, ex TEXT,flag TEXT  DEFAULT '0',PRIMARY KEY(nm));");
        } catch (SQLException unused) {
            LogUtil.logE("DownloadDBHelper", "couldn't create table in logs database");
        }
    }

    private ContentValues c(com.baidu.clientupdate.a.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ug", aVar.f4575b);
        contentValues.put("sessioninfo", aVar.f4574a + "\"tm\":\"" + (System.currentTimeMillis() / 1000) + "\"}");
        contentValues.put(SearchView.IME_OPTION_NO_MICROPHONE, aVar.f4576c);
        contentValues.put("stm", aVar.f4578e.toString());
        contentValues.put(Config.STAT_SDK_CHANNEL, aVar.f4579f.toString());
        contentValues.put("etm", aVar.f4580g.toString());
        contentValues.put("mg", aVar.f4581h.toString());
        contentValues.put(Config.EXCEPTION_PART, aVar.f4582i.toString());
        return contentValues;
    }

    private ContentValues c(Download download) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", download.mFileName);
        contentValues.put("saved_path_for_user", download.mSavedPath);
        contentValues.put("uri", download.mUrl);
        contentValues.put("mimetype", download.mMimeType);
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

    public static String[] c(long[] jArr) {
        String[] strArr = new String[jArr.length];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            strArr[i2] = Long.toString(jArr[i2]);
        }
        return strArr;
    }

    public int a(long... jArr) {
        int i2 = 0;
        if (jArr == null || jArr.length == 0) {
            return 0;
        }
        try {
            SQLiteDatabase writableDatabase = a(this.f4634b).getWritableDatabase();
            writableDatabase.beginTransaction();
            i2 = writableDatabase.delete("downloads", b(jArr), c(jArr));
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return i2;
        } catch (Exception e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            return i2;
        }
    }

    public long a(com.baidu.clientupdate.a.a aVar) {
        long j = -1;
        try {
            SQLiteDatabase writableDatabase = a(this.f4634b).getWritableDatabase();
            ContentValues c2 = c(aVar);
            writableDatabase.beginTransaction();
            j = writableDatabase.insert("logs", null, c2);
            com.baidu.util.a.a(this.f4634b).b("lcsdk_xml", "time", System.currentTimeMillis());
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return j;
        } catch (Exception e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            return j;
        }
    }

    public long a(Download download) {
        long j = -1;
        try {
            SQLiteDatabase writableDatabase = a(this.f4634b).getWritableDatabase();
            ContentValues c2 = c(download);
            writableDatabase.beginTransaction();
            j = writableDatabase.insert("downloads", null, c2);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            download.mId = j;
            return j;
        } catch (Exception e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            return j;
        }
    }

    public Cursor a() {
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = a(this.f4634b).getReadableDatabase();
            readableDatabase.beginTransaction();
            cursor = readableDatabase.query("downloads", null, null, null, null, null, null);
            readableDatabase.setTransactionSuccessful();
            readableDatabase.endTransaction();
            return cursor;
        } catch (Exception e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            if (cursor != null) {
                cursor.close();
                return cursor;
            }
            return cursor;
        }
    }

    public Cursor a(String str) {
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = a(this.f4634b).getReadableDatabase();
            readableDatabase.beginTransaction();
            cursor = readableDatabase.query("logs", null, "nm=?", new String[]{str}, null, null, null);
            readableDatabase.setTransactionSuccessful();
            readableDatabase.endTransaction();
            return cursor;
        } catch (IllegalStateException e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            if (cursor != null) {
                cursor.close();
            }
            b();
            return cursor;
        } catch (Exception e3) {
            if (cursor != null) {
                cursor.close();
            }
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
            return cursor;
        }
    }

    public int b() {
        int i2 = 0;
        try {
            SQLiteDatabase writableDatabase = a(this.f4634b).getWritableDatabase();
            writableDatabase.beginTransaction();
            i2 = writableDatabase.delete("logs", null, null);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return i2;
        } catch (Exception e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            return i2;
        }
    }

    public void b(com.baidu.clientupdate.a.a aVar) {
        try {
            SQLiteDatabase writableDatabase = a(this.f4634b).getWritableDatabase();
            writableDatabase.beginTransaction();
            writableDatabase.update("logs", c(aVar), "nm = ?", new String[]{aVar.f4576c});
            com.baidu.util.a.a(this.f4634b).b("lcsdk_xml", "time", System.currentTimeMillis());
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (IllegalStateException e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            b();
        } catch (Exception e3) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
        }
    }

    public void b(Download download) {
        try {
            SQLiteDatabase writableDatabase = a(this.f4634b).getWritableDatabase();
            writableDatabase.beginTransaction();
            writableDatabase.update("downloads", c(download), "_id = ?", new String[]{Long.toString(download.mId)});
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Exception e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
        }
    }

    public int c() {
        int i2 = 0;
        try {
            SQLiteDatabase writableDatabase = a(this.f4634b).getWritableDatabase();
            writableDatabase.beginTransaction();
            i2 = writableDatabase.delete("logs", "flag=?", new String[]{"1"});
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return i2;
        } catch (Exception e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            return i2;
        }
    }

    public void d() {
        try {
            SQLiteDatabase writableDatabase = a(this.f4634b).getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("flag", "1");
            writableDatabase.update("logs", contentValues, null, null);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (IllegalStateException e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            b();
        } catch (Exception e3) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
        }
    }

    public void e() {
        try {
            SQLiteDatabase writableDatabase = a(this.f4634b).getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("flag", "0");
            writableDatabase.update("logs", contentValues, null, null);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (IllegalStateException e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            b();
        } catch (Exception e3) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
        }
    }

    public Cursor f() {
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = a(this.f4634b).getReadableDatabase();
            readableDatabase.beginTransaction();
            cursor = readableDatabase.query("logs", null, null, null, null, null, null);
            readableDatabase.setTransactionSuccessful();
            readableDatabase.endTransaction();
            return cursor;
        } catch (IllegalStateException e2) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            if (cursor != null) {
                cursor.close();
            }
            b();
            return cursor;
        } catch (Exception e3) {
            LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
            if (cursor != null) {
                cursor.close();
                return cursor;
            }
            return cursor;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        if (r2 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g() {
        boolean z = false;
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase readableDatabase = a(this.f4634b).getReadableDatabase();
                readableDatabase.beginTransaction();
                cursor = readableDatabase.query("logs", null, "nm=?", new String[]{"a6"}, null, null, null);
                readableDatabase.setTransactionSuccessful();
                readableDatabase.endTransaction();
                if (cursor != null) {
                    if (cursor.getCount() != 0) {
                        z = true;
                    }
                }
            } catch (IllegalStateException e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                b();
            } catch (Exception e3) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
                if (cursor != null) {
                }
                return z;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        if (r2 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h() {
        boolean z = false;
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase readableDatabase = a(this.f4634b).getReadableDatabase();
                readableDatabase.beginTransaction();
                cursor = readableDatabase.query("logs", null, "nm=?", new String[]{"a9"}, null, null, null);
                readableDatabase.setTransactionSuccessful();
                readableDatabase.endTransaction();
                if (cursor != null) {
                    if (cursor.getCount() != 0) {
                        z = true;
                    }
                }
            } catch (IllegalStateException e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                b();
            } catch (Exception e3) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
                if (cursor != null) {
                }
                return z;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        LogUtil.logD("DownloadDBHelper", "populating new database");
        a(sQLiteDatabase);
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        LogUtil.logD("DownloadDBHelper", i2 + " to " + i3 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
        onCreate(sQLiteDatabase);
    }
}
