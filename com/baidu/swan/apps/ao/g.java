package com.baidu.swan.apps.ao;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public final class g {
    public static boolean exists(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.baidu.swan.c.d.closeSafely(context.getAssets().open(str, 0));
            return true;
        } catch (IOException e) {
            com.baidu.swan.c.d.closeSafely(null);
            return false;
        } catch (Throwable th) {
            com.baidu.swan.c.d.closeSafely(null);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [152=4] */
    public static String loadAssetsFile(Context context, String str) {
        InputStream inputStream;
        String str2 = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                if (inputStream == null) {
                    com.baidu.swan.c.d.closeSafely(inputStream);
                } else {
                    try {
                        str2 = com.baidu.swan.c.f.streamToString(inputStream);
                        com.baidu.swan.c.d.closeSafely(inputStream);
                    } catch (IOException e) {
                        e = e;
                        if (com.baidu.swan.apps.b.DEBUG) {
                            Log.w("AssetUtils", "loadPresetDatas", e);
                        }
                        com.baidu.swan.c.d.closeSafely(inputStream);
                        return str2;
                    }
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.d.closeSafely(null);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.c.d.closeSafely(null);
            throw th;
        }
        return str2;
    }
}
