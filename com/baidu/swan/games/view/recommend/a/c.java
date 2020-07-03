package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class c {
    public static final String djb = null;
    private List<String> djc = new ArrayList();

    public void f(int i, String str, String str2) {
        String iP = iP(i);
        String S = S(iP, str, str2);
        if (!this.djc.contains(S)) {
            String appKey = com.baidu.swan.apps.runtime.e.apM() == null ? null : com.baidu.swan.apps.runtime.e.apM().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = iP;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.v("target_appkey", str2);
            }
            eVar.v("current_appkey", appKey);
            h.e(eVar);
            this.djc.add(S);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String iP = iP(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = iP;
        if (b != null) {
            eVar.v("game_list", b);
        }
        h.e(eVar);
        this.djc.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String iP = iP(i);
        String appKey = com.baidu.swan.apps.runtime.e.apM() == null ? null : com.baidu.swan.apps.runtime.e.apM().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = iP;
        eVar.mValue = str;
        if (str2 != null) {
            eVar.v("target_appkey", str2);
        }
        eVar.v("current_appkey", appKey);
        if (!TextUtils.isEmpty(str3)) {
            eVar.v("location", str3);
        }
        h.e(eVar);
    }

    public void b(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String iP = iP(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = iP;
        if (b != null) {
            eVar.v("game_list", b);
        }
        h.e(eVar);
    }

    private String iP(int i) {
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
        if (aVar == null || aVar.djy == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.djy) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String S(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
