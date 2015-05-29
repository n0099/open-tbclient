package com.baidu.tbadk.core.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class bt {
    public static boolean af(Context context) {
        if (context == null) {
            return false;
        }
        boolean D = D(context, "webview.db");
        if (D(context, "webviewCache.db")) {
            return true;
        }
        return D;
    }

    private static boolean D(Context context, String str) {
        SQLiteDatabase openOrCreateDatabase;
        if (context == null || StringUtils.isNull(str)) {
            return false;
        }
        try {
            SQLiteDatabase openOrCreateDatabase2 = context.openOrCreateDatabase(str, 0, null);
            if (openOrCreateDatabase2 != null) {
                openOrCreateDatabase2.close();
                return false;
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!context.deleteDatabase(str) || (openOrCreateDatabase = context.openOrCreateDatabase(str, 0, null)) == null) {
                    return false;
                }
                openOrCreateDatabase.close();
                return false;
            } catch (Throwable th2) {
                return true;
            }
        }
    }
}
