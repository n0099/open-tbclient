package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class c {
    public static final String dVB = null;
    private List<String> dVC = new ArrayList();

    public void g(int i, String str, String str2) {
        String mi = mi(i);
        String ad = ad(mi, str, str2);
        if (!this.dVC.contains(ad)) {
            String appKey = com.baidu.swan.apps.runtime.e.aEU() == null ? null : com.baidu.swan.apps.runtime.e.aEU().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = mi;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.u("target_appkey", str2);
            }
            eVar.u("current_appkey", appKey);
            h.e(eVar);
            this.dVC.add(ad);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String mi = mi(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = mi;
        if (b != null) {
            eVar.u("game_list", b);
        }
        h.e(eVar);
        this.dVC.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String mi = mi(i);
        String appKey = com.baidu.swan.apps.runtime.e.aEU() == null ? null : com.baidu.swan.apps.runtime.e.aEU().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = mi;
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
        String mi = mi(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = mi;
        if (b != null) {
            eVar.u("game_list", b);
        }
        h.e(eVar);
    }

    private String mi(int i) {
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
        if (aVar == null || aVar.dVY == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.dVY) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String ad(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
