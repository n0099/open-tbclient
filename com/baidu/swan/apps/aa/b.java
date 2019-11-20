package com.baidu.swan.apps.aa;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private static volatile b aZi;
    private static final String TAG = b.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static synchronized b Nj() {
        b bVar;
        synchronized (b.class) {
            if (aZi == null) {
                synchronized (b.class) {
                    if (aZi == null) {
                        aZi = new b();
                    }
                }
            }
            bVar = aZi;
        }
        return bVar;
    }

    private b() {
    }

    public boolean a(Context context, String str, com.baidu.swan.apps.aa.a.b bVar) {
        com.baidu.swan.apps.ae.b Ra;
        if (DEBUG) {
            Log.d(TAG, "doBaiFuBaoPay orderInfo: " + str);
        }
        if (TextUtils.isEmpty(str) || (Ra = com.baidu.swan.apps.ae.b.Ra()) == null) {
            return false;
        }
        com.baidu.swan.apps.u.a.Jz().a(Ra, str, bVar);
        return true;
    }

    public boolean a(Context context, String str, com.baidu.swan.apps.aa.a.a aVar) {
        com.baidu.swan.apps.ae.b Ra;
        if (DEBUG) {
            Log.d(TAG, "doAliPay orderInfo: " + str);
        }
        if (TextUtils.isEmpty(str) || (Ra = com.baidu.swan.apps.ae.b.Ra()) == null) {
            return false;
        }
        com.baidu.swan.apps.u.a.Jz().a(Ra, str, aVar);
        return true;
    }

    public boolean b(Context context, Map<String, String> map, com.baidu.swan.apps.aa.a.d dVar) {
        if (DEBUG) {
            Log.d(TAG, "doWeChatPay payInfo: " + map);
        }
        if (map == null) {
            return false;
        }
        com.baidu.swan.apps.u.a.Jz().a(context, map, dVar);
        return true;
    }
}
