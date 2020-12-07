package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes25.dex */
public class f extends com.baidu.swan.apps.t.b.a {
    private String ajC() {
        return BaseUrlManager.ONLINE_URL;
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public boolean ajD() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajE() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/reset", ajC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajF() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/update", ajC()));
    }

    private HttpRequest d(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(ajC());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.i.b.anJ().cKl.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a();
        aVar.method = "POST";
        aVar.url = com.baidu.swan.apps.i.c.processCommonParams(build.toString());
        aVar.requestBody = com.baidu.swan.apps.setting.oauth.c.A(map);
        aVar.emE = true;
        aVar.emF = true;
        aVar.emG = false;
        HttpRequestBuilder d = com.baidu.swan.a.c.b.d(aVar);
        com.baidu.swan.a.c.a.bdi().a(d, aVar);
        return d.build();
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest e(Context context, Map<String, String> map) {
        return d("ma/login", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest f(Context context, Map<String, String> map) {
        return d("ma/accredit_data", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest g(Context context, Map<String, String> map) {
        return d("ma/accredit_v1", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest h(Context context, Map<String, String> map) {
        return d("ma/user/checksessionkey", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest i(Context context, Map<String, String> map) {
        return d("ma/user/swanid", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest j(Context context, Map<String, String> map) {
        return d("ma/user/openid", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public HttpRequest k(Context context, Map<String, String> map) {
        return d("ma/open/data", map);
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ajG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajH() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", ajC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajI() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_user_info", ajC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajJ() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/remove_user_cloud_storage", ajC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajK() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_user_cloud_storage", ajC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajL() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/set_user_cloud_storage", ajC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajM() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_friend_cloud_storage", ajC()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajN() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/exchange/list", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajO() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/exchange/transfer_report", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajP() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/user/addiction/polling", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajQ() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/user/rechargecheck", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ajR() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/get", ajC()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ajS() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/receive", ajC()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ajT() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/msgame/adblock", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ajU() {
        return com.baidu.swan.apps.t.a.azM().getHostName();
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ajV() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public long ajW() {
        return 0L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajX() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/user/gamehistory/upload", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajY() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ajZ() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/minigame/get_game_tencent_ads", com.baidu.swan.apps.i.a.getGameServerHost()));
    }
}
