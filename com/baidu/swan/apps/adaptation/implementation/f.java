package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes10.dex */
public class f extends com.baidu.swan.apps.t.b.a {
    private String ahc() {
        return "https://mbd.baidu.com";
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public boolean ahd() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahe() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/reset", ahc()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahf() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/update", ahc()));
    }

    private HttpRequest e(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(ahc());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.i.b.alj().cFa.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a();
        aVar.method = "POST";
        aVar.url = com.baidu.swan.apps.i.c.processCommonParams(build.toString());
        aVar.requestBody = com.baidu.swan.apps.setting.oauth.c.A(map);
        aVar.ehl = true;
        aVar.ehm = true;
        aVar.ehn = false;
        HttpRequestBuilder d = com.baidu.swan.a.c.b.d(aVar);
        com.baidu.swan.a.c.a.baK().a(d, aVar);
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
    public String ahg() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahh() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", ahc()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahi() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_user_info", ahc()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahj() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/remove_user_cloud_storage", ahc()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahk() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_user_cloud_storage", ahc()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahl() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/set_user_cloud_storage", ahc()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahm() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_friend_cloud_storage", ahc()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahn() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/exchange/list", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aho() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/exchange/transfer_report", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahp() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/user/addiction/polling", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahq() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/user/rechargecheck", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ahr() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/get", ahc()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ahs() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/receive", ahc()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String aht() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/msgame/adblock", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ahu() {
        return com.baidu.swan.apps.t.a.axm().getHostName();
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ahv() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public long ahw() {
        return 0L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahx() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/user/gamehistory/upload", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahy() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahz() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/minigame/get_game_tencent_ads", com.baidu.swan.apps.i.a.getGameServerHost()));
    }
}
