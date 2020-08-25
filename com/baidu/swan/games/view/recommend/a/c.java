package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class c {
    public static final String dyY = null;
    private List<String> dyZ = new ArrayList();

    public void f(int i, String str, String str2) {
        String lp = lp(i);
        String V = V(lp, str, str2);
        if (!this.dyZ.contains(V)) {
            String appKey = com.baidu.swan.apps.runtime.e.azI() == null ? null : com.baidu.swan.apps.runtime.e.azI().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = lp;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.u("target_appkey", str2);
            }
            eVar.u("current_appkey", appKey);
            h.e(eVar);
            this.dyZ.add(V);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String lp = lp(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = lp;
        if (b != null) {
            eVar.u("game_list", b);
        }
        h.e(eVar);
        this.dyZ.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String lp = lp(i);
        String appKey = com.baidu.swan.apps.runtime.e.azI() == null ? null : com.baidu.swan.apps.runtime.e.azI().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = lp;
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
        String lp = lp(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = lp;
        if (b != null) {
            eVar.u("game_list", b);
        }
        h.e(eVar);
    }

    private String lp(int i) {
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
        if (aVar == null || aVar.dzv == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.dzv) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String V(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
