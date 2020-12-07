package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class c {
    public static final String egL = null;
    private List<String> egM = new ArrayList();

    public void i(int i, String str, String str2) {
        String mM = mM(i);
        String ag = ag(mM, str, str2);
        if (!this.egM.contains(ag)) {
            String appKey = com.baidu.swan.apps.runtime.e.aJU() == null ? null : com.baidu.swan.apps.runtime.e.aJU().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = mM;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.t("target_appkey", str2);
            }
            eVar.t("current_appkey", appKey);
            h.e(eVar);
            this.egM.add(ag);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String mM = mM(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = mM;
        if (b != null) {
            eVar.t("game_list", b);
        }
        h.e(eVar);
        this.egM.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String mM = mM(i);
        String appKey = com.baidu.swan.apps.runtime.e.aJU() == null ? null : com.baidu.swan.apps.runtime.e.aJU().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = mM;
        eVar.mValue = str;
        if (str2 != null) {
            eVar.t("target_appkey", str2);
        }
        eVar.t("current_appkey", appKey);
        if (!TextUtils.isEmpty(str3)) {
            eVar.t("location", str3);
        }
        h.e(eVar);
    }

    public void b(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String mM = mM(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = mM;
        if (b != null) {
            eVar.t("game_list", b);
        }
        h.e(eVar);
    }

    private String mM(int i) {
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
        if (aVar == null || aVar.ehi == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.ehi) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String ag(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
