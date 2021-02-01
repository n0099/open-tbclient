package com.baidu.swan.games.view.recommend.a;

import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class c {
    public static final String eng = null;
    private List<String> enh = new ArrayList();

    public void i(int i, String str, String str2) {
        String lr = lr(i);
        String aj = aj(lr, str, str2);
        if (!this.enh.contains(aj)) {
            String appKey = com.baidu.swan.apps.runtime.e.aIK() == null ? null : com.baidu.swan.apps.runtime.e.aIK().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = lr;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.r("target_appkey", str2);
            }
            eVar.r("current_appkey", appKey);
            h.e(eVar);
            this.enh.add(aj);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String lr = lr(i);
        JSONArray b2 = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = lr;
        if (b2 != null) {
            eVar.r("game_list", b2);
        }
        h.e(eVar);
        this.enh.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String lr = lr(i);
        String appKey = com.baidu.swan.apps.runtime.e.aIK() == null ? null : com.baidu.swan.apps.runtime.e.aIK().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = lr;
        eVar.mValue = str;
        if (str2 != null) {
            eVar.r("target_appkey", str2);
        }
        eVar.r("current_appkey", appKey);
        if (!TextUtils.isEmpty(str3)) {
            eVar.r(Headers.LOCATION, str3);
        }
        h.e(eVar);
    }

    public void b(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String lr = lr(i);
        JSONArray b2 = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = lr;
        if (b2 != null) {
            eVar.r("game_list", b2);
        }
        h.e(eVar);
    }

    private String lr(int i) {
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
        if (aVar == null || aVar.enE == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.enE) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String aj(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
