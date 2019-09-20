package com.baidu.swan.games.view.recommend.a;

import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c {
    public static final String bnh = null;
    private List<String> bni = new ArrayList();

    public void g(int i, String str, String str2) {
        String fo = fo(i);
        String A = A(fo, str, str2);
        if (!this.bni.contains(A)) {
            String appKey = com.baidu.swan.apps.ae.b.Mh() == null ? null : com.baidu.swan.apps.ae.b.Mh().getAppKey();
            f fVar = new f();
            fVar.mType = "click";
            fVar.azQ = fo;
            fVar.mValue = str;
            if (str2 != null) {
                fVar.k("target_appkey", str2);
            }
            fVar.k("current_appkey", appKey);
            com.baidu.swan.apps.statistic.e.d(fVar);
            this.bni.add(A);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.d.b bVar) {
        String fo = fo(i);
        JSONArray b = b(bVar);
        f fVar = new f();
        fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
        fVar.azQ = fo;
        if (b != null) {
            fVar.k("game_list", b);
        }
        com.baidu.swan.apps.statistic.e.d(fVar);
        this.bni.clear();
    }

    private String fo(int i) {
        switch (i) {
            case 1:
                return "carousel";
            case 2:
                return IntentConfig.LIST;
            default:
                return null;
        }
    }

    private JSONArray b(com.baidu.swan.games.view.recommend.d.b bVar) {
        if (bVar == null || bVar.bnE == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.games.view.recommend.d.a aVar : bVar.bnE) {
            jSONArray.put(aVar.appKey);
        }
        return jSONArray;
    }

    private String A(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
