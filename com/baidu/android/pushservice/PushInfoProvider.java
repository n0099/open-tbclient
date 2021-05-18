package com.baidu.android.pushservice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
/* loaded from: classes.dex */
public class PushInfoProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public Context f2664a;

    /* renamed from: b  reason: collision with root package name */
    public UriMatcher f2665b = new UriMatcher(-1);

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
        Context context = getContext();
        this.f2664a = context;
        String str = m.o(context) ? "pushinfo_v3" : "pushinfo";
        if (this.f2665b == null) {
            this.f2665b = new UriMatcher(-1);
        }
        try {
            UriMatcher uriMatcher = this.f2665b;
            uriMatcher.addURI(this.f2664a.getPackageName() + ".bdpush", str, 1);
            UriMatcher uriMatcher2 = this.f2665b;
            uriMatcher2.addURI(this.f2664a.getPackageName() + ".bdpush", "verif", 2);
            UriMatcher uriMatcher3 = this.f2665b;
            uriMatcher3.addURI(this.f2664a.getPackageName() + ".bdpush", "msgInfo", 3);
            UriMatcher uriMatcher4 = this.f2665b;
            uriMatcher4.addURI(this.f2664a.getPackageName() + ".bdpush", "appstatus", 4);
        } catch (Throwable th) {
            new b.c(this.f2664a).a(Log.getStackTraceString(th)).a();
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor;
        int match;
        Cursor query;
        SQLiteDatabase a2;
        synchronized (com.baidu.android.pushservice.c.c.a()) {
            cursor = null;
            try {
                match = this.f2665b.match(uri);
            } catch (Exception e2) {
                new b.c(this.f2664a).a(Log.getStackTraceString(e2)).a();
            }
            if (match == 1) {
                SQLiteDatabase a3 = com.baidu.android.pushservice.c.c.a(this.f2664a);
                if (a3 != null) {
                    query = a3.query("PushShareInfo", null, null, null, null, null, null);
                }
            } else if (match == 2) {
                SQLiteDatabase a4 = com.baidu.android.pushservice.c.c.a(this.f2664a);
                if (a4 != null) {
                    query = a4.query("PushVerifInfo", strArr, str, strArr2, null, null, str2);
                }
            } else if (match == 3) {
                SQLiteDatabase a5 = com.baidu.android.pushservice.c.c.a(this.f2664a);
                if (a5 != null) {
                    query = a5.query("PushMsgInfos", strArr, str, strArr2, null, null, str2);
                }
            } else if (match == 4 && (a2 = com.baidu.android.pushservice.c.c.a(this.f2664a)) != null) {
                query = a2.query("PushAppStatus", strArr, str, strArr2, null, null, str2);
            }
            cursor = query;
        }
        return cursor;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0047 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x004e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0076 */
    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: android.net.Uri */
    /* JADX DEBUG: Multi-variable search result rejected for r12v11, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX DEBUG: Multi-variable search result rejected for r12v12, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX DEBUG: Multi-variable search result rejected for r12v13, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX DEBUG: Multi-variable search result rejected for r12v14, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX DEBUG: Multi-variable search result rejected for r12v3, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX DEBUG: Multi-variable search result rejected for r12v4, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX DEBUG: Multi-variable search result rejected for r12v5, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX DEBUG: Multi-variable search result rejected for r12v7, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (r12 != 0) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r12v2 */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        long j;
        long update;
        synchronized (com.baidu.android.pushservice.c.c.a()) {
            Cursor cursor = null;
            j = -1;
            try {
                try {
                    try {
                        if (this.f2665b.match(uri) != 1) {
                            uri = 0;
                        } else {
                            uri = com.baidu.android.pushservice.c.c.a(this.f2664a);
                            uri = uri;
                            if (uri != 0) {
                                try {
                                    Cursor query = uri.query("PushShareInfo", null, null, null, null, null, null);
                                    if (query != null) {
                                        try {
                                            if (query.getCount() != 0) {
                                                update = uri.update("PushShareInfo", contentValues, str, null);
                                                j = update;
                                                cursor = query;
                                                uri = uri;
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            cursor = query;
                                            new b.c(this.f2664a).a(Log.getStackTraceString(e)).a();
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (uri != 0) {
                                                uri.close();
                                            }
                                            return (int) j;
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor = query;
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (uri != 0) {
                                                uri.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    update = uri.insert("PushShareInfo", null, contentValues);
                                    j = update;
                                    cursor = query;
                                    uri = uri;
                                } catch (Exception e3) {
                                    e = e3;
                                }
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e4) {
                    e = e4;
                    uri = 0;
                } catch (Throwable th3) {
                    th = th3;
                    uri = 0;
                }
            } finally {
            }
        }
        return (int) j;
    }
}
