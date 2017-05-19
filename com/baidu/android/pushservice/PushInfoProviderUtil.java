package com.baidu.android.pushservice;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.baidu.android.pushservice.f.p;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.h.u;
/* loaded from: classes2.dex */
public class PushInfoProviderUtil {
    private static final int PUSH_INFO = 1;
    private static final int PUSH_VERIF_INFO = 2;
    private static final String TAG = "PushInfoProvider";
    private static final UriMatcher uriMatcher = new UriMatcher(-1);

    public static boolean onCreate(Context context) {
        uriMatcher.addURI(context.getPackageName() + PushInfoProvider.PUSH_PROVIDER_AUTHORITIES_SUFFIX, u.E(context) ? PushInfoProvider.DATABASE_PUSHINFO_V3 : PushInfoProvider.DATABASE_PUSHINFO, 1);
        uriMatcher.addURI(context.getPackageName() + PushInfoProvider.PUSH_PROVIDER_AUTHORITIES_SUFFIX, PushInfoProvider.DATABASE_PUSHINFO_VERIF, 2);
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0065 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x000c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (q.a()) {
            try {
                cursor = uriMatcher.match(uri);
                try {
                    switch (cursor) {
                        case 1:
                            SQLiteDatabase a = q.a(context);
                            cursor = a != null ? a.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null) : 0;
                            if (cursor != 0) {
                                com.baidu.android.pushservice.e.a.c(TAG, "return contentprovider Cursor : " + ((Object) cursor));
                                cursor = cursor;
                                break;
                            }
                            break;
                        case 2:
                            SQLiteDatabase a2 = q.a(context);
                            cursor = a2 != null ? a2.query("PushVerifInfo", strArr, str, strArr2, null, null, str2) : null;
                            if (cursor != null) {
                                com.baidu.android.pushservice.e.a.c(TAG, "return PushVerifInfoEnum provider Cursor : " + cursor);
                                cursor = cursor;
                                break;
                            }
                            break;
                        default:
                            com.baidu.android.pushservice.e.a.c(TAG, "unknow provider uri request!");
                            cursor = 0;
                            break;
                    }
                } catch (Exception e) {
                    cursor2 = cursor;
                    e = e;
                    com.baidu.android.pushservice.e.a.a(TAG, e);
                    p.a(context, e);
                    cursor = cursor2;
                    return cursor;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return cursor;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0081 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x0036 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0017 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x0087, TryCatch #3 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:29:0x007e, B:31:0x0083, B:41:0x00bf, B:43:0x00c4, B:44:0x00c7), top: B:63:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bf A[Catch: all -> 0x0087, TRY_ENTER, TryCatch #3 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:29:0x007e, B:31:0x0083, B:41:0x00bf, B:43:0x00c4, B:44:0x00c7), top: B:63:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c4 A[Catch: all -> 0x0087, TryCatch #3 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:29:0x007e, B:31:0x0083, B:41:0x00bf, B:43:0x00c4, B:44:0x00c7), top: B:63:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019 A[Catch: all -> 0x0087, TRY_ENTER, TryCatch #3 {, blocks: (B:9:0x0019, B:11:0x001e, B:12:0x0021, B:29:0x007e, B:31:0x0083, B:41:0x00bf, B:43:0x00c4, B:44:0x00c7), top: B:63:0x0009 }] */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int update(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        ?? r5;
        Cursor cursor2;
        SQLiteDatabase a;
        SQLiteDatabase sQLiteDatabase2 = null;
        synchronized (q.a()) {
            try {
                switch (uriMatcher.match(uri)) {
                    case 1:
                        a = q.a(context);
                        if (a != null) {
                            try {
                                r5 = 0;
                                cursor = a.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                                try {
                                    if (cursor != null) {
                                        try {
                                            try {
                                                if (cursor.getCount() != 0) {
                                                    long update = a.update(PushInfoProvider.TABLENAME_PUSHSHARE, contentValues, str, null);
                                                    com.baidu.android.pushservice.e.a.c(TAG, "update  selection = " + str + "  ret = " + update);
                                                    r5 = update;
                                                }
                                            } catch (Throwable th) {
                                                sQLiteDatabase2 = a;
                                                th = th;
                                                if (cursor != null) {
                                                }
                                                if (sQLiteDatabase2 != null) {
                                                }
                                                throw th;
                                            }
                                        } catch (Exception e) {
                                            r5 = -1;
                                            sQLiteDatabase = a;
                                            e = e;
                                            cursor2 = cursor;
                                            try {
                                                com.baidu.android.pushservice.e.a.a(TAG, e);
                                                p.a(context, e);
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
                                    long insert = a.insert(PushInfoProvider.TABLENAME_PUSHSHARE, null, contentValues);
                                    com.baidu.android.pushservice.e.a.c(TAG, "insert  selection = " + str + "  ret = " + insert);
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
