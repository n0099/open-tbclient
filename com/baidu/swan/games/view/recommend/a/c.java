package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class c {
    public static final String dNe = null;
    private List<String> dNf = new ArrayList();

    public void f(int i, String str, String str2) {
        String lX = lX(i);
        String W = W(lX, str, str2);
        if (!this.dNf.contains(W)) {
            String appKey = com.baidu.swan.apps.runtime.e.aDa() == null ? null : com.baidu.swan.apps.runtime.e.aDa().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = lX;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.u("target_appkey", str2);
            }
            eVar.u("current_appkey", appKey);
            h.e(eVar);
            this.dNf.add(W);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String lX = lX(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = lX;
        if (b != null) {
            eVar.u("game_list", b);
        }
        h.e(eVar);
        this.dNf.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String lX = lX(i);
        String appKey = com.baidu.swan.apps.runtime.e.aDa() == null ? null : com.baidu.swan.apps.runtime.e.aDa().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = lX;
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
        String lX = lX(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = lX;
        if (b != null) {
            eVar.u("game_list", b);
        }
        h.e(eVar);
    }

    private String lX(int i) {
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
        if (aVar == null || aVar.dNB == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.dNB) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String W(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
