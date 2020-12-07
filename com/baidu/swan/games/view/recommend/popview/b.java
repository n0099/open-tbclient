package com.baidu.swan.games.view.recommend.popview;

import com.baidu.android.imsdk.internal.Constants;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes25.dex */
public class b {
    public static void a(Callback callback) {
        a(callback, "6");
    }

    public static void a(Callback callback, String str) {
        if (com.baidu.swan.apps.runtime.e.aJU() != null) {
            com.baidu.swan.games.network.b aKj = com.baidu.swan.apps.runtime.e.aJU().aKj();
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/exchange/list").newBuilder();
            newBuilder.addQueryParameter(Constants.EXTRA_CONFIG_LIMIT, str);
            newBuilder.addQueryParameter("app_key", com.baidu.swan.apps.runtime.e.aJU().getAppKey());
            newBuilder.addQueryParameter("source", "4");
            aKj.a(new Request.Builder().url(newBuilder.build()).build(), callback);
        }
    }
}
