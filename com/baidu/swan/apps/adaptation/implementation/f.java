package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes11.dex */
public class f extends com.baidu.swan.apps.u.b.a {
    private String SS() {
        return "https://mbd.baidu.com";
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public boolean ST() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SU() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/reset", SS()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SV() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/update", SS()));
    }

    private HttpRequest e(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(SS());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.swan.apps.h.b.WI().bVK.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        com.baidu.swan.c.b.a aVar = new com.baidu.swan.c.b.a();
        aVar.method = "POST";
        aVar.url = com.baidu.swan.apps.h.c.processCommonParams(build.toString());
        aVar.requestBody = com.baidu.swan.apps.setting.oauth.c.q(map);
        aVar.dpO = true;
        aVar.dpP = true;
        aVar.dpQ = false;
        HttpRequestBuilder d = com.baidu.swan.c.c.b.d(aVar);
        com.baidu.swan.c.c.a.aGD().a(d, aVar);
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
    public String SW() {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SX() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", SS()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SY() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/get_user_info", SS()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String SZ() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/remove_user_cloud_storage", SS()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Ta() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/get_user_cloud_storage", SS()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tb() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/set_user_cloud_storage", SS()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tc() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/game/od/get_friend_cloud_storage", SS()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Td() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/exchange/list", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Te() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/exchange/transfer_report", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tf() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/user/addiction/polling", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.q
    public String Tg() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/user/rechargecheck", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public String Th() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/get", SS()));
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public String Ti() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/subscribe/v1/relation/receive", SS()));
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public String Tj() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/api/msgame/adblock", com.baidu.swan.apps.h.a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    public String Tk() {
        return com.baidu.swan.apps.u.a.agH().getHostName();
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.adaptation.a.q
    @Nullable
    public String Tl() {
        return null;
    }
}
