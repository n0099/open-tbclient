package com.baidu.swan.game.ad.a;

import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public interface b {
    void a(String str, ResponseCallback<AdResponseInfo> responseCallback);

    void a(String str, JSONObject jSONObject, ResponseCallback<AdResponseInfo> responseCallback);

    void b(String str, ResponseCallback<com.baidu.swan.game.ad.c.a> responseCallback);

    void vy(String str);

    void vz(String str);
}
