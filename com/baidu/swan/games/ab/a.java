package com.baidu.swan.games.ab;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.binding.model.c;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.sdk.CookieManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void getUUAPInfo(JsObject jsObject) {
        final c e = c.e(jsObject);
        if (e != null) {
            e aoG = e.aoG();
            if (aoG == null) {
                c(e, "internal error");
                return;
            }
            final String optString = e.optString("domain", "baidu.com");
            if (DEBUG) {
                Log.i("SwanGameUuapApi", "getUUAPInfo-domain: " + optString);
            }
            aoG.aoR().d("mapp_uuap_info", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.games.ab.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: c */
                public void H(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (eVar == null || eVar.forbidden || eVar.cEu != 1) {
                        a.c(c.this, "system deny");
                    } else {
                        a.d(c.this, optString);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(c cVar, String str) {
        b bVar = new b();
        String cookie = CookieManager.getInstance().getCookie(str);
        if (!TextUtils.isEmpty(cookie)) {
            Map<String, String> sH = sH(cookie);
            bVar.uuap_p_token = sH.get("UUAP_P_TOKEN");
            bVar.uuap_p_token_offline = sH.get("UUAP_P_TOKEN_OFFLINE");
            bVar.uuap_s_token = sH.get("UUAP_S_TOKEN");
        }
        com.baidu.swan.games.utils.b.a(cVar, true, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(c cVar, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.b.a(cVar, false, bVar);
    }

    @NonNull
    private static Map<String, String> sH(@NonNull String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
            if (str2 != null && str2.contains(ETAG.EQUAL)) {
                int indexOf = str2.indexOf(ETAG.EQUAL);
                hashMap.put(str2.substring(0, indexOf).trim().toUpperCase(), str2.substring(indexOf + 1));
            }
        }
        return hashMap;
    }
}
