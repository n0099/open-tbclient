package com.baidu.swan.game.ad.f;

import android.content.Context;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
/* loaded from: classes2.dex */
public class d implements com.baidu.swan.game.ad.b.b {
    private boolean a;
    private Context b;

    public d(Context context) {
        this.b = context;
    }

    @Override // com.baidu.swan.game.ad.b.b
    public void a(String str, ResponseCallback<com.baidu.swan.game.ad.a.b> responseCallback) {
        this.a = str.startsWith("https://");
        if (this.a) {
            HttpManager.getDefault(this.b).getRequest().url(str).cookieManager(com.baidu.swan.apps.u.a.DY().Ew()).build().executeAsync(responseCallback);
            return;
        }
        HttpManager.getDefault(this.b).getRequest().url(str).build().executeAsync(responseCallback);
    }

    @Override // com.baidu.swan.game.ad.b.b
    public void a(String str) {
        this.a = str.startsWith("https://");
        if (this.a) {
            HttpManager.getDefault(this.b).getRequest().url(str).cookieManager(com.baidu.swan.apps.u.a.DY().Ew()).build().executeAsync(null);
            return;
        }
        HttpManager.getDefault(this.b).getRequest().url(str).build().executeAsync(null);
    }
}
