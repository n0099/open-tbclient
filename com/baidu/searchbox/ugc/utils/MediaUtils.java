package com.baidu.searchbox.ugc.utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* loaded from: classes13.dex */
public class MediaUtils {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = MediaUtils.class.getSimpleName();

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0064 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public static Bitmap loadBitmap(String str, BitmapFactory.Options options) {
        InputStream inputStream;
        Context appContext = AppRuntime.getAppContext();
        ?? uri = UgcUriUtils.getUri(str);
        if (appContext == null || TextUtils.isEmpty(str) || uri == 0) {
            return null;
        }
        try {
            if (UgcUriUtils.isLocalContentUri(uri)) {
                try {
                    inputStream = appContext.getContentResolver().openInputStream(uri);
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                        Closeables.closeSafely(inputStream);
                        return decodeStream;
                    } catch (FileNotFoundException e) {
                        e = e;
                        if (DEBUG) {
                            Log.e(TAG, "loadBitmap FileNotFoundException = " + e);
                        }
                        Closeables.closeSafely(inputStream);
                        return null;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    inputStream = null;
                } catch (Throwable th) {
                    uri = 0;
                    th = th;
                    Closeables.closeSafely((Closeable) uri);
                    throw th;
                }
            } else if (UgcUriUtils.isLocalFileUri(uri)) {
                return BitmapFactory.decodeFile(uri.getPath(), options);
            } else {
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static String getLocalFilePath(String str) {
        Uri uri = UgcUriUtils.getUri(str);
        Context appContext = AppRuntime.getAppContext();
        if (uri == null || appContext == null) {
            return "";
        }
        if (UgcUriUtils.isLocalFileUri(uri)) {
            return uri.getPath();
        }
        if (UgcUriUtils.isLocalContentUri(uri)) {
            Cursor query = appContext.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return "";
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static long getMediaSize(String str) {
        Uri uri = UgcUriUtils.getUri(str);
        Context appContext = AppRuntime.getAppContext();
        if (uri == null || appContext == null) {
            return 0L;
        }
        if (UgcUriUtils.isLocalFileUri(uri)) {
            return new File(uri.getPath()).length();
        }
        if (UgcUriUtils.isLocalContentUri(uri)) {
            Cursor query = appContext.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        long j = query.getLong(query.getColumnIndexOrThrow("_size"));
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return 0L;
    }
}
