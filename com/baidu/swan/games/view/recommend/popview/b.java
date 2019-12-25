package com.baidu.swan.games.view.recommend.popview;

import com.baidu.android.imsdk.internal.Constants;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes9.dex */
public class b {
    public static void a(Callback callback) {
        if (com.baidu.swan.apps.runtime.e.ZS() != null) {
            com.baidu.swan.games.network.b aaf = com.baidu.swan.apps.runtime.e.ZS().aaf();
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/exchange/list").newBuilder();
            newBuilder.addQueryParameter(Constants.EXTRA_CONFIG_LIMIT, "6");
            newBuilder.addQueryParameter("app_key", com.baidu.swan.apps.runtime.e.ZS().getAppKey());
            newBuilder.addQueryParameter("source", "4");
            aaf.a(new Request.Builder().url(newBuilder.build()).build(), callback);
        }
    }
}
