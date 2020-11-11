package com.baidu.android.pushservice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
/* loaded from: classes10.dex */
public class PushInfoProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private Context f997a;
    private UriMatcher b = new UriMatcher(-1);

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
        this.f997a = getContext();
        String str = m.o(this.f997a) ? "pushinfo_v3" : "pushinfo";
        if (this.b == null) {
            this.b = new UriMatcher(-1);
        }
        try {
            this.b.addURI(this.f997a.getPackageName() + ".bdpush", str, 1);
            this.b.addURI(this.f997a.getPackageName() + ".bdpush", "verif", 2);
            this.b.addURI(this.f997a.getPackageName() + ".bdpush", "msgInfo", 3);
            this.b.addURI(this.f997a.getPackageName() + ".bdpush", "appstatus", 4);
        } catch (Throwable th) {
            new b.c(this.f997a).a(Log.getStackTraceString(th)).a();
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor;
        synchronized (com.baidu.android.pushservice.c.c.a()) {
            try {
            } catch (Exception e) {
                new b.c(this.f997a).a(Log.getStackTraceString(e)).a();
            }
            switch (this.b.match(uri)) {
                case 1:
                    SQLiteDatabase a2 = com.baidu.android.pushservice.c.c.a(this.f997a);
                    cursor = a2 != null ? a2.query("PushShareInfo", null, null, null, null, null, null) : null;
                    if (cursor != null) {
                        break;
                    }
                    break;
                case 2:
                    SQLiteDatabase a3 = com.baidu.android.pushservice.c.c.a(this.f997a);
                    cursor = a3 != null ? a3.query("PushVerifInfo", strArr, str, strArr2, null, null, str2) : null;
                    if (cursor != null) {
                        break;
                    }
                    break;
                case 3:
                    SQLiteDatabase a4 = com.baidu.android.pushservice.c.c.a(this.f997a);
                    cursor = a4 != null ? a4.query("PushMsgInfos", strArr, str, strArr2, null, null, str2) : null;
                    if (cursor != null) {
                        break;
                    }
                    break;
                case 4:
                    SQLiteDatabase a5 = com.baidu.android.pushservice.c.c.a(this.f997a);
                    cursor = a5 != null ? a5.query("PushAppStatus", strArr, str, strArr2, null, null, str2) : null;
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
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0017 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v26, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x008c, TryCatch #5 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:34:0x0083, B:36:0x0088, B:37:0x008b, B:28:0x0075, B:30:0x007a), top: B:55:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083 A[Catch: all -> 0x008c, TryCatch #5 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:34:0x0083, B:36:0x0088, B:37:0x008b, B:28:0x0075, B:30:0x007a), top: B:55:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088 A[Catch: all -> 0x008c, TryCatch #5 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:34:0x0083, B:36:0x0088, B:37:0x008b, B:28:0x0075, B:30:0x007a), top: B:55:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019 A[Catch: all -> 0x008c, TRY_ENTER, TryCatch #5 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:34:0x0083, B:36:0x0088, B:37:0x008b, B:28:0x0075, B:30:0x007a), top: B:55:0x0009 }] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27 */
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
            Cursor cursor2 = null;
            try {
                switch (this.b.match(uri)) {
                    case 1:
                        SQLiteDatabase a2 = com.baidu.android.pushservice.c.c.a(this.f997a);
                        if (a2 != null) {
                            try {
                                query = a2.query("PushShareInfo", null, null, null, null, null, null);
                                if (query != null) {
                                    try {
                                        if (query.getCount() != 0) {
                                            j2 = a2.update("PushShareInfo", contentValues, str, null);
                                            sQLiteDatabase2 = a2;
                                            j = j2;
                                        }
                                    } catch (Exception e) {
                                        cursor = query;
                                        sQLiteDatabase = j;
                                        e = e;
                                        try {
                                            new b.c(this.f997a).a(Log.getStackTraceString(e)).a();
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
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        cursor2 = query;
                                        sQLiteDatabase = j;
                                        th = th2;
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase != null) {
                                        }
                                        throw th;
                                    }
                                }
                                j2 = a2.insert("PushShareInfo", null, contentValues);
                                sQLiteDatabase2 = a2;
                                j = j2;
                            } catch (Exception e2) {
                                sQLiteDatabase = a2;
                                e = e2;
                                cursor = null;
                            } catch (Throwable th3) {
                                sQLiteDatabase = a2;
                                th = th3;
                            }
                        } else {
                            query = null;
                            sQLiteDatabase2 = a2;
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
                sQLiteDatabase = null;
            }
        }
        return (int) j;
    }
}
