package android.support.v4.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes2.dex */
class a {
    public static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static String b(Context context, Uri uri) {
        return a(context, uri, "_display_name", (String) null);
    }

    private static String c(Context context, Uri uri) {
        return a(context, uri, "mime_type", (String) null);
    }

    public static String d(Context context, Uri uri) {
        String c = c(context, uri);
        if ("vnd.android.document/directory".equals(c)) {
            return null;
        }
        return c;
    }

    public static boolean e(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(c(context, uri));
    }

    public static boolean f(Context context, Uri uri) {
        String c = c(context, uri);
        return ("vnd.android.document/directory".equals(c) || TextUtils.isEmpty(c)) ? false : true;
    }

    public static long g(Context context, Uri uri) {
        return a(context, uri, "last_modified", 0L);
    }

    public static long h(Context context, Uri uri) {
        return a(context, uri, "_size", 0L);
    }

    public static boolean i(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(c(context, uri));
    }

    public static boolean j(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String c = c(context, uri);
        int a = a(context, uri, "flags", 0);
        if (TextUtils.isEmpty(c)) {
            return false;
        }
        if ((a & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(c) || (a & 8) == 0) {
            return (TextUtils.isEmpty(c) || (a & 2) == 0) ? false : true;
        }
        return true;
    }

    public static boolean k(Context context, Uri uri) {
        return DocumentsContract.deleteDocument(context.getContentResolver(), uri);
    }

    public static boolean l(Context context, Uri uri) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"document_id"}, null, null, null);
            try {
                try {
                    boolean z = cursor.getCount() > 0;
                    a(cursor);
                    return z;
                } catch (Exception e) {
                    e = e;
                    Log.w("DocumentFile", "Failed query: " + e);
                    a(cursor);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                a(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            a(cursor);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0055 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0006 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static String a(Context context, Uri uri, String str, String str2) {
        Cursor cursor;
        ?? r1 = 1;
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
                try {
                    if (!cursor.moveToFirst() || cursor.isNull(0)) {
                        a(cursor);
                        r1 = cursor;
                    } else {
                        str2 = cursor.getString(0);
                        a(cursor);
                        r1 = cursor;
                    }
                } catch (Exception e) {
                    e = e;
                    Log.w("DocumentFile", "Failed query: " + e);
                    a(cursor);
                    r1 = cursor;
                    return str2;
                }
            } catch (Throwable th) {
                th = th;
                a(r1);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            a(r1);
            throw th;
        }
        return str2;
    }

    private static int a(Context context, Uri uri, String str, int i) {
        return (int) a(context, uri, str, i);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0055 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0006 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static long a(Context context, Uri uri, String str, long j) {
        Cursor cursor;
        ?? r1 = 1;
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
                try {
                    if (!cursor.moveToFirst() || cursor.isNull(0)) {
                        a(cursor);
                        r1 = cursor;
                    } else {
                        j = cursor.getLong(0);
                        a(cursor);
                        r1 = cursor;
                    }
                } catch (Exception e) {
                    e = e;
                    Log.w("DocumentFile", "Failed query: " + e);
                    a(cursor);
                    r1 = cursor;
                    return j;
                }
            } catch (Throwable th) {
                th = th;
                a(r1);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            a(r1);
            throw th;
        }
        return j;
    }

    private static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }
}
