package com.baidu.swan.apps.api.d;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cLa = {GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME, "swanAPI", "utils"};

    @NonNull
    public static Pair<Boolean, com.baidu.swan.apps.api.c.a> a(com.baidu.swan.apps.api.a.a aVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b();
        boolean a2 = a(str, aVar.anj().anh());
        if (a2) {
            bVar.status = 402;
        }
        return new Pair<>(Boolean.valueOf(a2), bVar);
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
            String amt = ((e) callbackHandler).amt();
            if ("ai_apps_widget".equals(amt)) {
                z = ms(str);
            } else if ("ai_apps_ad_landing".equals(amt)) {
                if (!com.baidu.swan.apps.af.a.b.sT(str)) {
                    z = true;
                }
            } else if (!"swan_app_alliance_login_widget".equals(amt) && !"swan_app_alliance_choose_address_widget".equals(amt) && DEBUG) {
                Log.d("SwanApiSafe", "intercept: false, source frame is not aiapps widget frame");
            }
            if (DEBUG) {
                Log.d("SwanApiSafe", "intercept: result=" + z + ", path=" + str);
            }
        }
        return z;
    }

    private static boolean ms(@NonNull String str) {
        String[] strArr;
        int indexOf = str.indexOf("/");
        if (indexOf < 0) {
            return true;
        }
        if (!str.startsWith(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME)) {
            return !com.baidu.swan.apps.af.a.b.sR(str);
        }
        String substring = str.substring(indexOf + 1);
        int length = cLa.length;
        for (int i = 0; i < length; i++) {
            if (com.baidu.swan.apps.af.a.b.sR(strArr[i] + "/" + substring)) {
                return false;
            }
        }
        return true;
    }
}
