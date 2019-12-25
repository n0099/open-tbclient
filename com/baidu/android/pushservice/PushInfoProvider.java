package com.baidu.android.pushservice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import com.baidu.android.pushservice.g.m;
import com.baidu.webkit.internal.GlobalConstants;
/* loaded from: classes5.dex */
public class PushInfoProvider extends ContentProvider {
    private Context a;
    private UriMatcher b = new UriMatcher(-1);

    private static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            if (context.getPackageName().startsWith(GlobalConstants.SEARCHBOX_PACKAGE_NAME)) {
                return true;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo(context.getPackageName(), 0) : null;
                if (packageInfo != null) {
                    if (packageInfo.applicationInfo.targetSdkVersion >= 24) {
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return false;
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
        this.a = getContext();
        String str = a(this.a) ? "pushinfo_v3" : "pushinfo";
        if (this.b == null) {
            this.b = new UriMatcher(-1);
        }
        try {
            this.b.addURI(this.a.getPackageName() + ".bdpush", str, 1);
            this.b.addURI(this.a.getPackageName() + ".bdpush", "verif", 2);
            this.b.addURI(this.a.getPackageName() + ".bdpush", "msgInfo", 3);
            this.b.addURI(this.a.getPackageName() + ".bdpush", "appstatus", 4);
        } catch (Throwable th) {
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor;
        synchronized (com.baidu.android.pushservice.c.c.a()) {
            try {
            } catch (Exception e) {
                m.a(this.a, e);
            }
            switch (this.b.match(uri)) {
                case 1:
                    SQLiteDatabase a = com.baidu.android.pushservice.c.c.a(this.a);
                    cursor = a != null ? a.query("PushShareInfo", null, null, null, null, null, null) : null;
                    if (cursor != null) {
                        break;
                    }
                    break;
                case 2:
                    SQLiteDatabase a2 = com.baidu.android.pushservice.c.c.a(this.a);
                    cursor = a2 != null ? a2.query("PushVerifInfo", strArr, str, strArr2, null, null, str2) : null;
                    if (cursor != null) {
                        break;
                    }
                    break;
                case 3:
                    SQLiteDatabase a3 = com.baidu.android.pushservice.c.c.a(this.a);
                    cursor = a3 != null ? a3.query("PushMsgInfos", strArr, str, strArr2, null, null, str2) : null;
                    if (cursor != null) {
                        break;
                    }
                    break;
                case 4:
                    SQLiteDatabase a4 = com.baidu.android.pushservice.c.c.a(this.a);
                    cursor = a4 != null ? a4.query("PushAppStatus", strArr, str, strArr2, null, null, str2) : null;
                    if (cursor != null) {
                    }
                    break;
                default:
                    cursor = null;
                    break;
            }
        }
        return cursor;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x001c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0017 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v24, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x007e, TryCatch #7 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:33:0x0075, B:35:0x007a, B:36:0x007d, B:28:0x0068, B:30:0x006d), top: B:54:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075 A[Catch: all -> 0x007e, TryCatch #7 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:33:0x0075, B:35:0x007a, B:36:0x007d, B:28:0x0068, B:30:0x006d), top: B:54:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a A[Catch: all -> 0x007e, TryCatch #7 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:33:0x0075, B:35:0x007a, B:36:0x007d, B:28:0x0068, B:30:0x006d), top: B:54:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019 A[Catch: all -> 0x007e, TRY_ENTER, TryCatch #7 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:33:0x0075, B:35:0x007a, B:36:0x007d, B:28:0x0068, B:30:0x006d), top: B:54:0x0009 }] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        long j;
        Cursor query;
        SQLiteDatabase sQLiteDatabase2;
        long j2 = -1;
        synchronized (com.baidu.android.pushservice.c.c.a()) {
            SQLiteDatabase sQLiteDatabase3 = null;
            Cursor cursor2 = null;
            try {
                switch (this.b.match(uri)) {
                    case 1:
                        SQLiteDatabase a = com.baidu.android.pushservice.c.c.a(this.a);
                        if (a != null) {
                            try {
                                query = a.query("PushShareInfo", null, null, null, null, null, null);
                                if (query != null) {
                                    try {
                                        if (query.getCount() != 0) {
                                            j2 = a.update("PushShareInfo", contentValues, str, null);
                                            sQLiteDatabase2 = a;
                                            j = j2;
                                        }
                                    } catch (Exception e) {
                                        cursor = query;
                                        sQLiteDatabase = j;
                                        e = e;
                                        try {
                                            m.a(this.a, e);
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.close();
                                                j = j2;
                                            } else {
                                                j = j2;
                                            }
                                            return (int) j;
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor2 = cursor;
                                            sQLiteDatabase3 = sQLiteDatabase;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            if (sQLiteDatabase3 != null) {
                                                sQLiteDatabase3.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        cursor2 = query;
                                        sQLiteDatabase3 = j;
                                        th = th2;
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase3 != null) {
                                        }
                                        throw th;
                                    }
                                }
                                j2 = a.insert("PushShareInfo", null, contentValues);
                                sQLiteDatabase2 = a;
                                j = j2;
                            } catch (Exception e2) {
                                sQLiteDatabase = a;
                                e = e2;
                                cursor = null;
                            } catch (Throwable th3) {
                                sQLiteDatabase3 = a;
                                th = th3;
                            }
                        } else {
                            query = null;
                            sQLiteDatabase2 = a;
                            j = -1;
                        }
                        if (query != null) {
                            query.close();
                        }
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                        }
                    default:
                        query = null;
                        sQLiteDatabase2 = null;
                        j = -1;
                        if (query != null) {
                        }
                        if (sQLiteDatabase2 != null) {
                        }
                        break;
                }
            } catch (Exception e3) {
                e = e3;
                sQLiteDatabase = null;
                cursor = null;
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return (int) j;
    }
}
