package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes7.dex */
public class f extends com.baidu.swan.apps.t.b.a {
    private String Tn() {
        return "https://mbd.baidu.com";
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.q
    public boolean To() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tp() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/reset", Tn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tq() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/update", Tn()));
    }

    private HttpRequest e(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(Tn());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.h.b.Xo().bWB.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        com.baidu.swan.b.b.a aVar = new com.baidu.swan.b.b.a();
        aVar.method = "POST";
        aVar.url = com.baidu.swan.apps.h.c.processCommonParams(build.toString());
        aVar.requestBody = com.baidu.swan.apps.setting.oauth.c.q(map);
        aVar.dvF = true;
        aVar.dvG = true;
        aVar.dvH = false;
        HttpRequestBuilder d = com.baidu.swan.b.c.b.d(aVar);
        com.baidu.swan.b.c.a.aKu().a(d, aVar);
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

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.q
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.q
    public String Tr() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Ts() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", Tn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tt() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/get_user_info", Tn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tu() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/remove_user_cloud_storage", Tn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tv() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/get_user_cloud_storage", Tn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tw() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/set_user_cloud_storage", Tn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tx() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/get_friend_cloud_storage", Tn()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Ty() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/exchange/list", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tz() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/exchange/transfer_report", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TA() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/user/addiction/polling", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TB() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/user/rechargecheck", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.q
    public String TC() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/get", Tn()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.q
    public String TD() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/receive", Tn()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.q
    public String TE() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/msgame/adblock", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.q
    public String TF() {
        return com.baidu.swan.apps.t.a.ahU().getHostName();
    }

    @Override // com.baidu.swan.apps.t.b.a, com.baidu.swan.apps.adaptation.a.q
    @Nullable
    public String TG() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public long TH() {
        return 0L;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TI() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String TJ() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/minigame/get_game_tencent_ads", com.baidu.swan.apps.h.a.getGameServerHost()));
    }
}
