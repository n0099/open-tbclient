package com.baidu.tbadk.core.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class WebViewUtil {
    public static final String WEBVIEW_CACHE_DATABASE_FILE = "webviewCache.db";
    public static final String WEBVIEW_DATABASE_FILE = "webview.db";

    public static boolean isDatabaseCorrupted(Context context, String str) {
        SQLiteDatabase openOrCreateDatabase;
        if (context == null || StringUtils.isNull(str)) {
            return false;
        }
        try {
            try {
                SQLiteDatabase openOrCreateDatabase2 = context.openOrCreateDatabase(str, 0, null);
                if (openOrCreateDatabase2 != null) {
                    openOrCreateDatabase2.close();
                    return false;
                }
                return false;
            } catch (Throwable unused) {
                return true;
            }
        } catch (Throwable unused2) {
            if (!context.deleteDatabase(str) || (openOrCreateDatabase = context.openOrCreateDatabase(str, 0, null)) == null) {
                return false;
            }
            openOrCreateDatabase.close();
            return false;
        }
    }

    public static boolean isWebViewCorrupted(Context context) {
        if (context == null) {
            return false;
        }
        boolean isDatabaseCorrupted = isDatabaseCorrupted(context, WEBVIEW_DATABASE_FILE);
        if (isDatabaseCorrupted(context, WEBVIEW_CACHE_DATABASE_FILE)) {
            return true;
        }
        return isDatabaseCorrupted;
    }
}
