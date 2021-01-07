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
/* loaded from: classes3.dex */
public class PushInfoProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private Context f1146a;

    /* renamed from: b  reason: collision with root package name */
    private UriMatcher f1147b = new UriMatcher(-1);

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
        this.f1146a = getContext();
        String str = m.o(this.f1146a) ? "pushinfo_v3" : "pushinfo";
        if (this.f1147b == null) {
            this.f1147b = new UriMatcher(-1);
        }
        try {
            this.f1147b.addURI(this.f1146a.getPackageName() + ".bdpush", str, 1);
            this.f1147b.addURI(this.f1146a.getPackageName() + ".bdpush", "verif", 2);
            this.f1147b.addURI(this.f1146a.getPackageName() + ".bdpush", "msgInfo", 3);
            this.f1147b.addURI(this.f1146a.getPackageName() + ".bdpush", "appstatus", 4);
        } catch (Throwable th) {
            new b.c(this.f1146a).a(Log.getStackTraceString(th)).a();
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor;
        synchronized (com.baidu.android.pushservice.c.c.a()) {
            try {
            } catch (Exception e) {
                new b.c(this.f1146a).a(Log.getStackTraceString(e)).a();
            }
            switch (this.f1147b.match(uri)) {
                case 1:
                    SQLiteDatabase a2 = com.baidu.android.pushservice.c.c.a(this.f1146a);
                    cursor = a2 != null ? a2.query("PushShareInfo", null, null, null, null, null, null) : null;
                    if (cursor != null) {
                        break;
                    }
                    break;
                case 2:
                    SQLiteDatabase a3 = com.baidu.android.pushservice.c.c.a(this.f1146a);
                    cursor = a3 != null ? a3.query("PushVerifInfo", strArr, str, strArr2, null, null, str2) : null;
                    if (cursor != null) {
                        break;
                    }
                    break;
                case 3:
                    SQLiteDatabase a4 = com.baidu.android.pushservice.c.c.a(this.f1146a);
                    cursor = a4 != null ? a4.query("PushMsgInfos", strArr, str, strArr2, null, null, str2) : null;
                    if (cursor != null) {
                        break;
                    }
                    break;
                case 4:
                    SQLiteDatabase a5 = com.baidu.android.pushservice.c.c.a(this.f1146a);
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c A[Catch: all -> 0x0084, TryCatch #0 {, blocks: (B:9:0x0017, B:11:0x001c, B:12:0x0020, B:34:0x007b, B:36:0x0080, B:37:0x0083, B:28:0x006c, B:30:0x0071), top: B:54:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007b A[Catch: all -> 0x0084, TryCatch #0 {, blocks: (B:9:0x0017, B:11:0x001c, B:12:0x0020, B:34:0x007b, B:36:0x0080, B:37:0x0083, B:28:0x006c, B:30:0x0071), top: B:54:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0080 A[Catch: all -> 0x0084, TryCatch #0 {, blocks: (B:9:0x0017, B:11:0x001c, B:12:0x0020, B:34:0x007b, B:36:0x0080, B:37:0x0083, B:28:0x006c, B:30:0x0071), top: B:54:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0017 A[Catch: all -> 0x0084, TRY_ENTER, TryCatch #0 {, blocks: (B:9:0x0017, B:11:0x001c, B:12:0x0020, B:34:0x007b, B:36:0x0080, B:37:0x0083, B:28:0x006c, B:30:0x0071), top: B:54:0x0009 }] */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Throwable th;
        Cursor cursor;
        Exception e;
        long j;
        SQLiteDatabase a2;
        long j2;
        long j3 = -1;
        synchronized (com.baidu.android.pushservice.c.c.a()) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                switch (this.f1147b.match(uri)) {
                    case 1:
                        a2 = com.baidu.android.pushservice.c.c.a(this.f1146a);
                        if (a2 != null) {
                            try {
                                cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                                if (cursor != null) {
                                    try {
                                        if (cursor.getCount() != 0) {
                                            j3 = a2.update("PushShareInfo", contentValues, str, null);
                                            j2 = j3;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        sQLiteDatabase = a2;
                                        try {
                                            new b.c(this.f1146a).a(Log.getStackTraceString(e)).a();
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.close();
                                                j = j3;
                                            } else {
                                                j = j3;
                                            }
                                            return (int) j;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sQLiteDatabase = a2;
                                        if (cursor != null) {
                                        }
                                        if (sQLiteDatabase != null) {
                                        }
                                        throw th;
                                    }
                                }
                                j3 = a2.insert("PushShareInfo", null, contentValues);
                                j2 = j3;
                            } catch (Exception e3) {
                                e = e3;
                                cursor = null;
                                sQLiteDatabase = a2;
                            } catch (Throwable th4) {
                                th = th4;
                                cursor = null;
                                sQLiteDatabase = a2;
                            }
                        } else {
                            cursor = null;
                            j2 = -1;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a2 == null) {
                            a2.close();
                            j = j2;
                        } else {
                            j = j2;
                        }
                    default:
                        cursor = null;
                        a2 = null;
                        j2 = -1;
                        if (cursor != null) {
                        }
                        if (a2 == null) {
                        }
                        break;
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                cursor = null;
            }
        }
        return (int) j;
    }
}
