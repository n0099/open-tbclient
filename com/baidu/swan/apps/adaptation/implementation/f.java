package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes8.dex */
public class f extends com.baidu.swan.apps.t.b.a {
    private String Zn() {
        return "https://mbd.baidu.com";
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public boolean Zo() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String Zp() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/reset", Zn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String Zq() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/update", Zn()));
    }

    private HttpRequest e(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(Zn());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.i.b.adu().ccj.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a();
        aVar.method = "POST";
        aVar.url = com.baidu.swan.apps.i.c.processCommonParams(build.toString());
        aVar.requestBody = com.baidu.swan.apps.setting.oauth.c.q(map);
        aVar.dEO = true;
        aVar.dEP = true;
        aVar.dEQ = false;
        HttpRequestBuilder d = com.baidu.swan.a.c.b.d(aVar);
        com.baidu.swan.a.c.a.aSW().a(d, aVar);
        return d.build();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest e(Context context, Map<String, String> map) {
        return e("ma/login", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest f(Context context, Map<String, String> map) {
        return e("ma/accredit_data", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest g(Context context, Map<String, String> map) {
        return e("ma/accredit_v1", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest h(Context context, Map<String, String> map) {
        return e("ma/user/checksessionkey", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest i(Context context, Map<String, String> map) {
        return e("ma/user/swanid", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest j(Context context, Map<String, String> map) {
        return e("ma/user/openid", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest k(Context context, Map<String, String> map) {
        return e("ma/open/data", map);
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String Zr() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String Zs() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", Zn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String Zt() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_user_info", Zn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String Zu() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/remove_user_cloud_storage", Zn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String Zv() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_user_cloud_storage", Zn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String Zw() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/set_user_cloud_storage", Zn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String Zx() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_friend_cloud_storage", Zn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String Zy() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/exchange/list", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String Zz() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/exchange/transfer_report", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ZA() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/user/addiction/polling", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ZB() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/user/rechargecheck", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ZC() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/get", Zn()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ZD() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/receive", Zn()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ZE() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/msgame/adblock", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ZF() {
        return com.baidu.swan.apps.t.a.apw().getHostName();
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ZG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public long ZH() {
        return 0L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ZI() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/user/gamehistory/upload", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ZJ() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ZK() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/minigame/get_game_tencent_ads", com.baidu.swan.apps.i.a.getGameServerHost()));
    }
}
