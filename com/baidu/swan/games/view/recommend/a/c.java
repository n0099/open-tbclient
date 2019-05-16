package com.baidu.swan.games.view.recommend.a;

import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c {
    public static final String blV = null;
    private List<String> blW = new ArrayList();

    public void f(int i, String str, String str2) {
        String fj = fj(i);
        String A = A(fj, str, str2);
        if (!this.blW.contains(A)) {
            String appKey = com.baidu.swan.apps.ae.b.Lq() == null ? null : com.baidu.swan.apps.ae.b.Lq().getAppKey();
            f fVar = new f();
            fVar.mType = "click";
            fVar.ayL = fj;
            fVar.mValue = str;
            if (str2 != null) {
                fVar.k("target_appkey", str2);
            }
            fVar.k("current_appkey", appKey);
            com.baidu.swan.apps.statistic.e.d(fVar);
            this.blW.add(A);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.d.b bVar) {
        String fj = fj(i);
        JSONArray b = b(bVar);
        f fVar = new f();
        fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
        fVar.ayL = fj;
        if (b != null) {
            fVar.k("game_list", b);
        }
        com.baidu.swan.apps.statistic.e.d(fVar);
        this.blW.clear();
    }

    private String fj(int i) {
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
        if (bVar == null || bVar.bmt == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.games.view.recommend.d.a aVar : bVar.bmt) {
            jSONArray.put(aVar.appKey);
        }
        return jSONArray;
    }

    private String A(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
