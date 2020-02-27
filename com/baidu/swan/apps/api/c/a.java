package com.baidu.swan.apps.api.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.adaptation.b.e;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] bfA = {"swan", "swanAPI"};

    @NonNull
    public static Pair<Boolean, com.baidu.swan.apps.api.b.a> a(com.baidu.swan.apps.api.a.a aVar, String str) {
        com.baidu.swan.apps.api.b.b bVar = new com.baidu.swan.apps.api.b.b();
        boolean a = a(str, aVar.JC().JA());
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
            String IO = ((e) callbackHandler).IO();
            if ("ai_apps_widget".equals(IO)) {
                z = gg(str);
            } else if ("ai_apps_ad_landing".equals(IO)) {
                if (!com.baidu.swan.apps.aj.a.b.lk(str)) {
                    z = true;
                }
            } else if (!"swan_app_alliance_login_widget".equals(IO) && !"swan_app_alliance_choose_address_widget".equals(IO) && DEBUG) {
                Log.d("SwanApiSafe", "intercept: false, source frame is not aiapps widget frame");
            }
            if (DEBUG) {
                Log.d("SwanApiSafe", "intercept: result=" + z + ", path=" + str);
            }
        }
        return z;
    }

    private static boolean gg(@NonNull String str) {
        String[] strArr;
        int indexOf = str.indexOf("/");
        if (indexOf < 0) {
            return true;
        }
        if (!str.startsWith("swan")) {
            return !com.baidu.swan.apps.aj.a.b.li(str);
        }
        String substring = str.substring(indexOf + 1);
        int length = bfA.length;
        for (int i = 0; i < length; i++) {
            if (com.baidu.swan.apps.aj.a.b.li(strArr[i] + "/" + substring)) {
                return false;
            }
        }
        return true;
    }
}
