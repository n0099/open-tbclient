package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes8.dex */
public class f extends com.baidu.swan.apps.t.b.a {
    private String agR() {
        return BaseUrlManager.ONLINE_URL;
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public boolean agS() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agT() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/reset", agR()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agU() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/update", agR()));
    }

    private HttpRequest d(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(agR());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.i.b.alb().cKu.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a();
        aVar.method = "POST";
        aVar.url = com.baidu.swan.apps.i.c.processCommonParams(build.toString());
        aVar.requestBody = com.baidu.swan.apps.setting.oauth.c.B(map);
        aVar.erA = true;
        aVar.erB = true;
        aVar.erC = false;
        HttpRequestBuilder d = com.baidu.swan.a.c.b.d(aVar);
        com.baidu.swan.a.c.a.bbL().a(d, aVar);
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
    public String agV() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agW() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", agR()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agX() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_user_info", agR()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agY() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/remove_user_cloud_storage", agR()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String agZ() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_user_cloud_storage", agR()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aha() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/set_user_cloud_storage", agR()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahb() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/game/od/get_friend_cloud_storage", agR()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahc() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/exchange/list", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahd() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/exchange/transfer_report", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahe() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/user/addiction/polling", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahf() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/user/rechargecheck", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ahg() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/get", agR()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ahh() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/receive", agR()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ahi() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/msgame/adblock", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    public String ahj() {
        return com.baidu.swan.apps.t.a.axk().getHostName();
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.r
    @Nullable
    public String ahk() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public long ahl() {
        return 0L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahm() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/user/gamehistory/upload", com.baidu.swan.apps.i.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String ahn() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.r
    public String aho() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/api/minigame/get_game_tencent_ads", com.baidu.swan.apps.i.a.getGameServerHost()));
    }
}
