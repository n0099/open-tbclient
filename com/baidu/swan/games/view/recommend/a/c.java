package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class c {
    public static final String dBd = null;
    private List<String> dBe = new ArrayList();

    public void f(int i, String str, String str2) {
        String lA = lA(i);
        String V = V(lA, str, str2);
        if (!this.dBe.contains(V)) {
            String appKey = com.baidu.swan.apps.runtime.e.aAr() == null ? null : com.baidu.swan.apps.runtime.e.aAr().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = lA;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.u("target_appkey", str2);
            }
            eVar.u("current_appkey", appKey);
            h.e(eVar);
            this.dBe.add(V);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String lA = lA(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = lA;
        if (b != null) {
            eVar.u("game_list", b);
        }
        h.e(eVar);
        this.dBe.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String lA = lA(i);
        String appKey = com.baidu.swan.apps.runtime.e.aAr() == null ? null : com.baidu.swan.apps.runtime.e.aAr().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = lA;
        eVar.mValue = str;
        if (str2 != null) {
            eVar.u("target_appkey", str2);
        }
        eVar.u("current_appkey", appKey);
        if (!TextUtils.isEmpty(str3)) {
            eVar.u("location", str3);
        }
        h.e(eVar);
    }

    public void b(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String lA = lA(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = lA;
        if (b != null) {
            eVar.u("game_list", b);
        }
        h.e(eVar);
    }

    private String lA(int i) {
        switch (i) {
            case 1:
                return "carousel";
            case 2:
                return "list";
            case 3:
                return "popview";
            default:
                return null;
        }
    }

    private JSONArray b(com.baidu.swan.games.view.recommend.model.a aVar) {
        if (aVar == null || aVar.dBA == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.dBA) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String V(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
