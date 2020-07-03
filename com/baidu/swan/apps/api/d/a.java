package com.baidu.swan.apps.api.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.adaptation.b.e;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] bRK = {"swan", "swanAPI", "utils"};

    @NonNull
    public static Pair<Boolean, com.baidu.swan.apps.api.c.a> a(com.baidu.swan.apps.api.a.a aVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b();
        boolean a = a(str, aVar.UY().UW());
        if (a) {
            bVar.status = 402;
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
            String Uo = ((e) callbackHandler).Uo();
            if ("ai_apps_widget".equals(Uo)) {
                z = iA(str);
            } else if ("ai_apps_ad_landing".equals(Uo)) {
                if (!com.baidu.swan.apps.ah.a.b.ob(str)) {
                    z = true;
                }
            } else if (!"swan_app_alliance_login_widget".equals(Uo) && !"swan_app_alliance_choose_address_widget".equals(Uo) && DEBUG) {
                Log.d("SwanApiSafe", "intercept: false, source frame is not aiapps widget frame");
            }
            if (DEBUG) {
                Log.d("SwanApiSafe", "intercept: result=" + z + ", path=" + str);
            }
        }
        return z;
    }

    private static boolean iA(@NonNull String str) {
        String[] strArr;
        int indexOf = str.indexOf("/");
        if (indexOf < 0) {
            return true;
        }
        if (!str.startsWith("swan")) {
            return !com.baidu.swan.apps.ah.a.b.nZ(str);
        }
        String substring = str.substring(indexOf + 1);
        int length = bRK.length;
        for (int i = 0; i < length; i++) {
            if (com.baidu.swan.apps.ah.a.b.nZ(strArr[i] + "/" + substring)) {
                return false;
            }
        }
        return true;
    }
}
