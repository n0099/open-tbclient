package com.baidu.android.pushservice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.baidu.android.pushservice.h.p;
import com.baidu.android.pushservice.j.q;
/* loaded from: classes2.dex */
public class PushInfoProvider extends ContentProvider {
    private static final UriMatcher c = new UriMatcher(-1);
    SQLiteDatabase a;
    private Context b;

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
        this.b = getContext();
        c.addURI(this.b.getPackageName() + ".bdpush", q.E(this.b) ? "pushinfo_v3" : "pushinfo", 1);
        c.addURI(this.b.getPackageName() + ".bdpush", "verif", 2);
        c.addURI(this.b.getPackageName() + ".bdpush", "msgInfo", 3);
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00af */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x000c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (com.baidu.android.pushservice.d.c.a()) {
            try {
                cursor = c.match(uri);
                try {
                    switch (cursor) {
                        case 1:
                            this.a = com.baidu.android.pushservice.d.c.a(this.b);
                            cursor = this.a != null ? this.a.query("PushShareInfo", null, null, null, null, null, null) : 0;
                            if (cursor != 0) {
                                com.baidu.android.pushservice.g.a.c("PushInfoProvider", "return contentprovider Cursor : " + ((Object) cursor));
                                cursor = cursor;
                                break;
                            }
                            break;
                        case 2:
                            this.a = com.baidu.android.pushservice.d.c.a(this.b);
                            cursor = this.a != null ? this.a.query("PushVerifInfo", strArr, str, strArr2, null, null, str2) : null;
                            if (cursor != null) {
                                com.baidu.android.pushservice.g.a.c("PushInfoProvider", "return PushVerifInfoEnum provider Cursor : " + cursor);
                                cursor = cursor;
                                break;
                            }
                            break;
                        case 3:
                            this.a = com.baidu.android.pushservice.d.c.a(this.b);
                            cursor = this.a != null ? this.a.query("PushMsgInfos", strArr, str, strArr2, null, null, str2) : null;
                            if (cursor != null) {
                                com.baidu.android.pushservice.g.a.c("PushInfoProvider", "return PushMsgInfoEnum provider Cursor : " + cursor);
                                cursor = cursor;
                                break;
                            }
                            break;
                        default:
                            com.baidu.android.pushservice.g.a.c("PushInfoProvider", "unknow provider uri request!");
                            cursor = 0;
                            break;
                    }
                } catch (Exception e) {
                    cursor2 = cursor;
                    e = e;
                    com.baidu.android.pushservice.g.a.a("PushInfoProvider", e);
                    p.a(this.b, e);
                    cursor = cursor2;
                    return cursor;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return cursor;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0085 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x0017 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x008b, TryCatch #4 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:29:0x0082, B:31:0x0087, B:41:0x00c3, B:43:0x00c8, B:44:0x00cb), top: B:63:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3 A[Catch: all -> 0x008b, TRY_ENTER, TryCatch #4 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:29:0x0082, B:31:0x0087, B:41:0x00c3, B:43:0x00c8, B:44:0x00cb), top: B:63:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8 A[Catch: all -> 0x008b, TryCatch #4 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:29:0x0082, B:31:0x0087, B:41:0x00c3, B:43:0x00c8, B:44:0x00cb), top: B:63:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019 A[Catch: all -> 0x008b, TRY_ENTER, TryCatch #4 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:29:0x0082, B:31:0x0087, B:41:0x00c3, B:43:0x00c8, B:44:0x00cb), top: B:63:0x0009 }] */
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
        SQLiteDatabase a;
        SQLiteDatabase sQLiteDatabase2 = null;
        synchronized (com.baidu.android.pushservice.d.c.a()) {
            try {
                switch (c.match(uri)) {
                    case 1:
                        a = com.baidu.android.pushservice.d.c.a(this.b);
                        if (a != null) {
                            try {
                                r5 = 0;
                                cursor = a.query("PushShareInfo", null, null, null, null, null, null);
                                try {
                                    if (cursor != null) {
                                        try {
                                            try {
                                                if (cursor.getCount() != 0) {
                                                    long update = a.update("PushShareInfo", contentValues, str, null);
                                                    com.baidu.android.pushservice.g.a.c("PushInfoProvider", "update  selection = " + str + "  ret = " + update);
                                                    r5 = update;
                                                }
                                            } catch (Exception e) {
                                                r5 = -1;
                                                sQLiteDatabase = a;
                                                e = e;
                                                cursor2 = cursor;
                                                try {
                                                    com.baidu.android.pushservice.g.a.a("PushInfoProvider", e);
                                                    p.a(this.b, e);
                                                    if (cursor2 != null) {
                                                        cursor2.close();
                                                    }
                                                    if (sQLiteDatabase != null) {
                                                        sQLiteDatabase.close();
                                                    }
                                                    return (int) r5;
                                                } catch (Throwable th) {
                                                    th = th;
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
                                        } catch (Throwable th2) {
                                            sQLiteDatabase2 = a;
                                            th = th2;
                                            if (cursor != null) {
                                            }
                                            if (sQLiteDatabase2 != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                    long insert = a.insert("PushShareInfo", null, contentValues);
                                    com.baidu.android.pushservice.g.a.c("PushInfoProvider", "insert  selection = " + str + "  ret = " + insert);
                                    r5 = insert;
                                } catch (Exception e2) {
                                    cursor2 = cursor;
                                    sQLiteDatabase = a;
                                    e = e2;
                                    r5 = r5;
                                }
                            } catch (Exception e3) {
                                sQLiteDatabase = a;
                                r5 = -1;
                                e = e3;
                                cursor2 = null;
                            } catch (Throwable th3) {
                                cursor = null;
                                sQLiteDatabase2 = a;
                                th = th3;
                            }
                        } else {
                            cursor = null;
                            r5 = -1;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a != null) {
                            a.close();
                        }
                    default:
                        cursor = null;
                        a = null;
                        r5 = -1;
                        if (cursor != null) {
                        }
                        if (a != null) {
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
