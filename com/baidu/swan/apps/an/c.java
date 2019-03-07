package com.baidu.swan.apps.an;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class c {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [158=4] */
    public static String aj(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        String str2 = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                if (inputStream == null) {
                    com.baidu.swan.c.b.c(inputStream);
                } else {
                    try {
                        str2 = com.baidu.swan.c.e.m(inputStream);
                        com.baidu.swan.c.b.c(inputStream);
                    } catch (IOException e) {
                        e = e;
                        if (com.baidu.swan.apps.c.DEBUG) {
                            Log.w("AssetUtils", "loadPresetDatas", e);
                        }
                        com.baidu.swan.c.b.c(inputStream);
                        return str2;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.c.b.c(null);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.swan.c.b.c(null);
            throw th;
        }
        return str2;
    }
}
