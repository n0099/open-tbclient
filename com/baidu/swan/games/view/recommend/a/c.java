package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class c {
    public static final String epN = null;
    private List<String> epO = new ArrayList();

    public void i(int i, String str, String str2) {
        String mU = mU(i);
        String aj = aj(mU, str, str2);
        if (!this.epO.contains(aj)) {
            String appKey = com.baidu.swan.apps.runtime.e.aMl() == null ? null : com.baidu.swan.apps.runtime.e.aMl().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = mU;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.t("target_appkey", str2);
            }
            eVar.t("current_appkey", appKey);
            h.e(eVar);
            this.epO.add(aj);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String mU = mU(i);
        JSONArray b2 = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = mU;
        if (b2 != null) {
            eVar.t("game_list", b2);
        }
        h.e(eVar);
        this.epO.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String mU = mU(i);
        String appKey = com.baidu.swan.apps.runtime.e.aMl() == null ? null : com.baidu.swan.apps.runtime.e.aMl().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = mU;
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
        String mU = mU(i);
        JSONArray b2 = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = mU;
        if (b2 != null) {
            eVar.t("game_list", b2);
        }
        h.e(eVar);
    }

    private String mU(int i) {
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
        if (aVar == null || aVar.eqk == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.eqk) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String aj(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
