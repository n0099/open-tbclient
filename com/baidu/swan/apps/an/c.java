package com.baidu.swan.apps.an;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class c {
    public static boolean T(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                InputStream open = context.getAssets().open(str, 0);
                z = true;
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return z;
    }

    public static String U(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        String str2 = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                if (inputStream != null) {
                    try {
                        str2 = com.baidu.swan.c.e.i(inputStream);
                        com.baidu.swan.c.a.b(inputStream);
                    } catch (IOException e) {
                        e = e;
                        if (com.baidu.swan.apps.b.DEBUG) {
                            Log.w("AssetUtils", "loadPresetDatas", e);
                        }
                        com.baidu.swan.c.a.b(inputStream);
                        return str2;
                    }
                } else {
                    com.baidu.swan.c.a.b(inputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.c.a.b(null);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.swan.c.a.b(null);
            throw th;
        }
        return str2;
    }
}
