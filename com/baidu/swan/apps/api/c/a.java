package com.baidu.swan.apps.api.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.adaptation.b.e;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] bbm = {"swan", "swanAPI"};

    @NonNull
    public static Pair<Boolean, com.baidu.swan.apps.api.b.a> a(com.baidu.swan.apps.api.a.a aVar, String str) {
        com.baidu.swan.apps.api.b.b bVar = new com.baidu.swan.apps.api.b.b();
        boolean a = a(str, aVar.Hn().Hl());
        if (a) {
            bVar.statusCode = 402;
        }
        return new Pair<>(Boolean.valueOf(a), bVar);
    }

    public static boolean a(String str, CallbackHandler callbackHandler) {
        boolean z = false;
        if (!(callbackHandler instanceof e)) {
            if (DEBUG) {
                Log.d("SwanApiSafe", "intercept: false, handler is null or not WebSafeHolder");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("whitelistName is empty");
            }
        } else {
            String Gz = ((e) callbackHandler).Gz();
            if ("ai_apps_widget".equals(Gz)) {
                z = fR(str);
            } else if ("ai_apps_ad_landing".equals(Gz)) {
                if (!com.baidu.swan.apps.aj.a.b.kV(str)) {
                    z = true;
                }
            } else if (!"swan_app_alliance_login_widget".equals(Gz) && !"swan_app_alliance_choose_address_widget".equals(Gz) && DEBUG) {
                Log.d("SwanApiSafe", "intercept: false, source frame is not aiapps widget frame");
            }
            if (DEBUG) {
                Log.d("SwanApiSafe", "intercept: result=" + z + ", path=" + str);
            }
        }
        return z;
    }

    private static boolean fR(@NonNull String str) {
        String[] strArr;
        int indexOf = str.indexOf("/");
        if (indexOf < 0) {
            return true;
        }
        if (!str.startsWith("swan")) {
            return !com.baidu.swan.apps.aj.a.b.kT(str);
        }
        String substring = str.substring(indexOf + 1);
        int length = bbm.length;
        for (int i = 0; i < length; i++) {
            if (com.baidu.swan.apps.aj.a.b.kT(strArr[i] + "/" + substring)) {
                return false;
            }
        }
        return true;
    }
}
