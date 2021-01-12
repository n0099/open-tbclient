package com.baidu.swan.games.view.recommend.popview;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.e;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes8.dex */
public class a {
    public static void a(Callback callback) {
        a(callback, "6");
    }

    public static void a(Callback callback, String str) {
        if (e.aIr() != null) {
            com.baidu.swan.games.network.b aIG = e.aIr().aIG();
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/exchange/list").newBuilder();
            newBuilder.addQueryParameter(Constants.EXTRA_CONFIG_LIMIT, str);
            newBuilder.addQueryParameter("app_key", e.aIr().getAppKey());
            newBuilder.addQueryParameter("source", "4");
            aIG.a(new Request.Builder().url(newBuilder.build()).build(), callback);
        }
    }
}
