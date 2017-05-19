package com.baidu.android.pushservice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.baidu.android.pushservice.pushinfo.tieba.PushInfoDatabase;
/* loaded from: classes.dex */
public class PushInfoProvider extends ContentProvider {
    public static final String DATABASE_PUSHINFO = "pushinfo";
    public static final String DATABASE_PUSHINFO_V3 = "pushinfo_v3";
    public static final String DATABASE_PUSHINFO_VERIF = "verif";
    private static final int PUSH_INFO = 1;
    public static final String PUSH_PROVIDER_AUTHORITIES_SUFFIX = ".bdpush";
    private static final int PUSH_VERIF_INFO = 2;
    public static final String TABLENAME_PUSHSHARE = "PushShareInfo";
    private static final String TAG = "PushInfoProvider";
    private static Context mContext;
    private static Object myLock = new Object();
    private static final UriMatcher uriMatcher = new UriMatcher(-1);
    SQLiteDatabase db;

    /* loaded from: classes.dex */
    enum PushInfoEnum {
        PushInfoId,
        PushPriority,
        PushVersion,
        PushChannelID,
        PushCurPkgName,
        PushWebAppBindInfo,
        PushLightAppBindInfo,
        PushSDKClientBindInfo,
        PushClientsBindInfo,
        PushSelfBindInfo;
        
        static final String TABLE_NAME = "PushShareInfo";
    }

    /* loaded from: classes.dex */
    enum PushVerifInfoEnum {
        verifId,
        msgId,
        md5Infos,
        appId,
        time;
        
        static final String TABLE_NAME = "PushVerifInfo";
    }

    private static boolean isNeedWriteWRSP(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if ((packageInfo != null ? packageInfo.applicationInfo.targetSdkVersion : 0) >= 24) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return false;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e + "");
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        mContext = getContext();
        uriMatcher.addURI(mContext.getPackageName() + PUSH_PROVIDER_AUTHORITIES_SUFFIX, !isNeedWriteWRSP(mContext) ? DATABASE_PUSHINFO_V3 : DATABASE_PUSHINFO, 1);
        uriMatcher.addURI(mContext.getPackageName() + PUSH_PROVIDER_AUTHORITIES_SUFFIX, DATABASE_PUSHINFO_VERIF, 2);
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0015 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x000a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Object, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (myLock) {
            try {
                cursor = uriMatcher.match(uri);
                try {
                    switch (cursor) {
                        case 1:
                            this.db = PushInfoDatabase.getDb(mContext);
                            if (this.db != null) {
                                cursor = this.db.query(TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                                if (cursor != 0) {
                                    Log.d(TAG, "return contentprovider Cursor : " + ((Object) cursor));
                                    cursor = cursor;
                                    break;
                                }
                            }
                            cursor = 0;
                            break;
                        case 2:
                            this.db = PushInfoDatabase.getDb(mContext);
                            if (this.db != null) {
                                cursor = this.db.query("PushVerifInfo", strArr, str, strArr2, null, null, str2);
                                if (cursor != null) {
                                    Log.d(TAG, "return PushVerifInfoEnum provider Cursor : " + cursor);
                                    cursor = cursor;
                                    break;
                                }
                            }
                            cursor = 0;
                            break;
                        default:
                            Log.d(TAG, "unknow provider uri request!");
                            cursor = 0;
                            break;
                    }
                } catch (Exception e) {
                    cursor2 = cursor;
                    e = e;
                    Log.e(TAG, e + "");
                    cursor = cursor2;
                    return cursor;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return cursor;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0092 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x0036 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0015 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001c A[Catch: all -> 0x0098, TryCatch #3 {, blocks: (B:9:0x0017, B:11:0x001c, B:12:0x001f, B:29:0x008f, B:31:0x0094, B:41:0x00d0, B:43:0x00d5, B:44:0x00d8), top: B:63:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d0 A[Catch: all -> 0x0098, TRY_ENTER, TryCatch #3 {, blocks: (B:9:0x0017, B:11:0x001c, B:12:0x001f, B:29:0x008f, B:31:0x0094, B:41:0x00d0, B:43:0x00d5, B:44:0x00d8), top: B:63:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d5 A[Catch: all -> 0x0098, TryCatch #3 {, blocks: (B:9:0x0017, B:11:0x001c, B:12:0x001f, B:29:0x008f, B:31:0x0094, B:41:0x00d0, B:43:0x00d5, B:44:0x00d8), top: B:63:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0017 A[Catch: all -> 0x0098, TRY_ENTER, TryCatch #3 {, blocks: (B:9:0x0017, B:11:0x001c, B:12:0x001f, B:29:0x008f, B:31:0x0094, B:41:0x00d0, B:43:0x00d5, B:44:0x00d8), top: B:63:0x0007 }] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2, types: [long] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        ?? r5;
        Cursor cursor2;
        SQLiteDatabase db;
        SQLiteDatabase sQLiteDatabase2 = null;
        synchronized (myLock) {
            try {
                switch (uriMatcher.match(uri)) {
                    case 1:
                        db = PushInfoDatabase.getDb(mContext);
                        if (db != null) {
                            try {
                                r5 = 0;
                                cursor = db.query(TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                                try {
                                    if (cursor != null) {
                                        try {
                                            try {
                                                if (cursor.getCount() != 0) {
                                                    long update = db.update(TABLENAME_PUSHSHARE, contentValues, str, null);
                                                    Log.d(TAG, "update  selection = " + str + "  ret = " + update);
                                                    r5 = update;
                                                }
                                            } catch (Throwable th) {
                                                sQLiteDatabase2 = db;
                                                th = th;
                                                if (cursor != null) {
                                                }
                                                if (sQLiteDatabase2 != null) {
                                                }
                                                throw th;
                                            }
                                        } catch (Exception e) {
                                            r5 = -1;
                                            sQLiteDatabase = db;
                                            e = e;
                                            cursor2 = cursor;
                                            try {
                                                Log.e(TAG, e + "");
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.close();
                                                }
                                                return (int) r5;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                Cursor cursor3 = cursor2;
                                                sQLiteDatabase2 = sQLiteDatabase;
                                                cursor = cursor3;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                if (sQLiteDatabase2 != null) {
                                                    sQLiteDatabase2.close();
                                                }
                                                throw th;
                                            }
                                        }
                                    }
                                    long insert = db.insert(TABLENAME_PUSHSHARE, null, contentValues);
                                    Log.d(TAG, "insert  selection = " + str + "  ret = " + insert);
                                    r5 = insert;
                                } catch (Exception e2) {
                                    cursor2 = cursor;
                                    sQLiteDatabase = db;
                                    e = e2;
                                    r5 = r5;
                                }
                            } catch (Exception e3) {
                                sQLiteDatabase = db;
                                r5 = -1;
                                e = e3;
                                cursor2 = null;
                            } catch (Throwable th3) {
                                cursor = null;
                                sQLiteDatabase2 = db;
                                th = th3;
                            }
                        } else {
                            cursor = null;
                            r5 = -1;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (db != null) {
                            db.close();
                        }
                    default:
                        cursor = null;
                        db = null;
                        r5 = -1;
                        if (cursor != null) {
                        }
                        if (db != null) {
                        }
                        break;
                }
            } catch (Exception e4) {
                e = e4;
                sQLiteDatabase = null;
                r5 = -1;
                cursor2 = null;
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
            }
        }
        return (int) r5;
    }
}
