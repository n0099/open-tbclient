package android.support.v4.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
@RequiresApi(19)
/* loaded from: classes7.dex */
class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    DocumentsContractApi19() {
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static boolean isVirtual(Context context, Uri uri) {
        return isDocumentUri(context, uri) && (getFlags(context, uri) & 512) != 0;
    }

    public static String getName(Context context, Uri uri) {
        return queryForString(context, uri, "_display_name", null);
    }

    private static String getRawType(Context context, Uri uri) {
        return queryForString(context, uri, "mime_type", null);
    }

    public static String getType(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        if ("vnd.android.document/directory".equals(rawType)) {
            return null;
        }
        return rawType;
    }

    public static long getFlags(Context context, Uri uri) {
        return queryForLong(context, uri, "flags", 0L);
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(getRawType(context, uri));
    }

    public static boolean isFile(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        return ("vnd.android.document/directory".equals(rawType) || TextUtils.isEmpty(rawType)) ? false : true;
    }

    public static long lastModified(Context context, Uri uri) {
        return queryForLong(context, uri, "last_modified", 0L);
    }

    public static long length(Context context, Uri uri) {
        return queryForLong(context, uri, "_size", 0L);
    }

    public static boolean canRead(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(getRawType(context, uri));
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String rawType = getRawType(context, uri);
        int queryForInt = queryForInt(context, uri, "flags", 0);
        if (TextUtils.isEmpty(rawType)) {
            return false;
        }
        if ((queryForInt & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(rawType) || (queryForInt & 8) == 0) {
            return (TextUtils.isEmpty(rawType) || (queryForInt & 2) == 0) ? false : true;
        }
        return true;
    }

    public static boolean exists(Context context, Uri uri) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"document_id"}, null, null, null);
            try {
                try {
                    boolean z = cursor.getCount() > 0;
                    closeQuietly(cursor);
                    return z;
                } catch (Exception e) {
                    e = e;
                    Log.w(TAG, "Failed query: " + e);
                    closeQuietly(cursor);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                closeQuietly(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            closeQuietly(cursor);
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
    private static String queryForString(Context context, Uri uri, String str, String str2) {
        Cursor cursor;
        ?? r1 = 1;
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
                try {
                    if (!cursor.moveToFirst() || cursor.isNull(0)) {
                        closeQuietly(cursor);
                        r1 = cursor;
                    } else {
                        str2 = cursor.getString(0);
                        closeQuietly(cursor);
                        r1 = cursor;
                    }
                } catch (Exception e) {
                    e = e;
                    Log.w(TAG, "Failed query: " + e);
                    closeQuietly(cursor);
                    r1 = cursor;
                    return str2;
                }
            } catch (Throwable th) {
                th = th;
                closeQuietly(r1);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            closeQuietly(r1);
            throw th;
        }
        return str2;
    }

    private static int queryForInt(Context context, Uri uri, String str, int i) {
        return (int) queryForLong(context, uri, str, i);
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
    private static long queryForLong(Context context, Uri uri, String str, long j) {
        Cursor cursor;
        ?? r1 = 1;
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
                try {
                    if (!cursor.moveToFirst() || cursor.isNull(0)) {
                        closeQuietly(cursor);
                        r1 = cursor;
                    } else {
                        j = cursor.getLong(0);
                        closeQuietly(cursor);
                        r1 = cursor;
                    }
                } catch (Exception e) {
                    e = e;
                    Log.w(TAG, "Failed query: " + e);
                    closeQuietly(cursor);
                    r1 = cursor;
                    return j;
                }
            } catch (Throwable th) {
                th = th;
                closeQuietly(r1);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            closeQuietly(r1);
            throw th;
        }
        return j;
    }

    private static void closeQuietly(AutoCloseable autoCloseable) {
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
