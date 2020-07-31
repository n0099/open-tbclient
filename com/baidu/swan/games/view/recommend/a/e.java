package com.baidu.swan.games.view.recommend.a;

import android.support.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.webkit.internal.ETAG;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class e {
    public static void a(int i, @NonNull ResponseCallback responseCallback) {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv == null) {
            responseCallback.onFail(new Exception("framework error: swan app is null."));
            return;
        }
        arv.arK().getRequest().cookieManager(com.baidu.swan.apps.t.a.ahH().Us()).url(com.baidu.swan.apps.t.a.ahv().Ty()).addUrlParam("app_key", arv.getAppKey()).addUrlParam(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(5)).addUrlParam("source", String.valueOf(i)).build().executeAsync(responseCallback);
    }

    public static void aj(int i, String str) {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv != null) {
            String Tz = com.baidu.swan.apps.t.a.ahv().Tz();
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) arv.arK().postFormRequest().cookieManager(com.baidu.swan.apps.t.a.ahH().Us())).url(Tz)).addParams(a(arv, i, str)).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.view.recommend.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str2, int i2) {
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                }
            });
        }
    }

    private static Map<String, String> a(@NonNull com.baidu.swan.apps.runtime.e eVar, int i, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("app_key", eVar.getAppKey());
        treeMap.put("to_app_key", str);
        treeMap.put("source", String.valueOf(i));
        treeMap.put("timestamp", aIi());
        StringBuilder sb = new StringBuilder();
        for (String str2 : treeMap.keySet()) {
            sb.append(str2);
            sb.append(ETAG.EQUAL);
            sb.append((String) treeMap.get(str2));
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append("dsb9Ao44");
        treeMap.put("sign", com.baidu.swan.d.e.toMd5(sb.toString().getBytes(), false));
        return treeMap;
    }

    private static String aIi() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }
}
