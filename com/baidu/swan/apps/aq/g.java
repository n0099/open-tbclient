package com.baidu.swan.apps.aq;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class g {
    public static boolean exists(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.baidu.swan.d.d.closeSafely(context.getAssets().open(str, 0));
            return true;
        } catch (IOException e) {
            com.baidu.swan.d.d.closeSafely(null);
            return false;
        } catch (Throwable th) {
            com.baidu.swan.d.d.closeSafely(null);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [152=4] */
    public static String loadAssetsFile(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        String str2 = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                if (inputStream == null) {
                    com.baidu.swan.d.d.closeSafely(inputStream);
                } else {
                    try {
                        str2 = com.baidu.swan.d.f.streamToString(inputStream);
                        com.baidu.swan.d.d.closeSafely(inputStream);
                    } catch (IOException e) {
                        e = e;
                        if (com.baidu.swan.apps.b.DEBUG) {
                            Log.w("AssetUtils", "loadPresetDatas", e);
                        }
                        com.baidu.swan.d.d.closeSafely(inputStream);
                        return str2;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.d.d.closeSafely(null);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.swan.d.d.closeSafely(null);
            throw th;
        }
        return str2;
    }
}
