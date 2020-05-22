package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes11.dex */
public class f extends com.baidu.swan.apps.u.b.a {
    private String RM() {
        return "https://mbd.baidu.com";
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public boolean RN() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RO() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/reset", RM()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RP() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/update", RM()));
    }

    private HttpRequest e(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(RM());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.h.b.VC().bQW.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        com.baidu.swan.c.b.a aVar = new com.baidu.swan.c.b.a();
        aVar.method = "POST";
        aVar.url = com.baidu.swan.apps.h.c.processCommonParams(build.toString());
        aVar.requestBody = com.baidu.swan.apps.setting.oauth.c.q(map);
        aVar.dld = true;
        aVar.dle = true;
        aVar.dlf = false;
        HttpRequestBuilder d = com.baidu.swan.c.c.b.d(aVar);
        com.baidu.swan.c.c.a.aFx().a(d, aVar);
        return d.build();
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public HttpRequest d(Context context, Map<String, String> map) {
        return e("ma/login", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public HttpRequest e(Context context, Map<String, String> map) {
        return e("ma/accredit_data", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public HttpRequest f(Context context, Map<String, String> map) {
        return e("ma/accredit_v1", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public HttpRequest g(Context context, Map<String, String> map) {
        return e("ma/user/checksessionkey", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public HttpRequest h(Context context, Map<String, String> map) {
        return e("ma/user/swanid", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public HttpRequest i(Context context, Map<String, String> map) {
        return e("ma/open/data", map);
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public String RQ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RR() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", RM()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RS() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/get_user_info", RM()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RT() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/remove_user_cloud_storage", RM()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RU() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/get_user_cloud_storage", RM()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RV() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/set_user_cloud_storage", RM()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RW() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/get_friend_cloud_storage", RM()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RX() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/exchange/list", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RY() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/exchange/transfer_report", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String RZ() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/user/addiction/polling", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Sa() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/user/rechargecheck", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public String Sb() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/get", RM()));
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public String Sc() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/receive", RM()));
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public String Sd() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/msgame/adblock", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public String Se() {
        return com.baidu.swan.apps.u.a.afB().getHostName();
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    @Nullable
    public String Sf() {
        return null;
    }
}
