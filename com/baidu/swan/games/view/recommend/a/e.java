package com.baidu.swan.games.view.recommend.a;

import android.support.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class e {
    public static void a(int i, @NonNull ResponseCallback responseCallback) {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md == null) {
            responseCallback.onFail(new Exception("framework error: swan app is null."));
            return;
        }
        Md.Mk().getRequest().cookieManager(com.baidu.swan.apps.u.a.EH().Ff()).url(com.baidu.swan.apps.u.a.Ew().xd()).addUrlParam("app_key", Md.getAppKey()).addUrlParam("limit", String.valueOf(5)).addUrlParam("source", String.valueOf(i)).build().executeAsync(responseCallback);
    }

    public static void x(int i, String str) {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            String xe = com.baidu.swan.apps.u.a.Ew().xe();
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) Md.Mk().postFormRequest().cookieManager(com.baidu.swan.apps.u.a.EH().Ff())).url(xe)).addParams(a(Md, i, str)).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.view.recommend.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: x */
                public void onSuccess(String str2, int i2) {
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                }
            });
        }
    }

    private static Map<String, String> a(@NonNull com.baidu.swan.apps.ae.b bVar, int i, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("app_key", bVar.getAppKey());
        treeMap.put("to_app_key", str);
        treeMap.put("source", String.valueOf(i));
        treeMap.put("timestamp", Uh());
        StringBuilder sb = new StringBuilder();
        for (String str2 : treeMap.keySet()) {
            sb.append(str2);
            sb.append("=");
            sb.append((String) treeMap.get(str2));
            sb.append("&");
        }
        sb.append("dsb9Ao44");
        treeMap.put("sign", com.baidu.swan.c.b.toMd5(sb.toString().getBytes(), false));
        return treeMap;
    }

    private static String Uh() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }
}
