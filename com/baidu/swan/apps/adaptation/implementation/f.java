package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes10.dex */
public class f extends com.baidu.swan.apps.t.b.a {
    private String aeC() {
        return "https://mbd.baidu.com";
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public boolean aeD() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeE() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/reset", aeC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeF() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/update", aeC()));
    }

    private HttpRequest e(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(aeC());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.i.b.aiJ().czh.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a();
        aVar.method = "POST";
        aVar.url = com.baidu.swan.apps.i.c.processCommonParams(build.toString());
        aVar.requestBody = com.baidu.swan.apps.setting.oauth.c.A(map);
        aVar.ebt = true;
        aVar.ebu = true;
        aVar.ebv = false;
        HttpRequestBuilder d = com.baidu.swan.a.c.b.d(aVar);
        com.baidu.swan.a.c.a.aYk().a(d, aVar);
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
    public String aeG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeH() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", aeC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeI() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_user_info", aeC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeJ() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/remove_user_cloud_storage", aeC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeK() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_user_cloud_storage", aeC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeL() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/set_user_cloud_storage", aeC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeM() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_friend_cloud_storage", aeC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeN() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/exchange/list", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeO() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/exchange/transfer_report", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeP() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/user/addiction/polling", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeQ() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/user/rechargecheck", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String aeR() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/get", aeC()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String aeS() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/receive", aeC()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String aeT() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/msgame/adblock", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String aeU() {
        return com.baidu.swan.apps.t.a.auM().getHostName();
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String aeV() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public long aeW() {
        return 0L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeX() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/user/gamehistory/upload", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeY() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aeZ() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/minigame/get_game_tencent_ads", com.baidu.swan.apps.i.a.getGameServerHost()));
    }
}
