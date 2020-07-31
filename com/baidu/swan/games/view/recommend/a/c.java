package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class c {
    public static final String doW = null;
    private List<String> doX = new ArrayList();

    public void f(int i, String str, String str2) {
        String jg = jg(i);
        String S = S(jg, str, str2);
        if (!this.doX.contains(S)) {
            String appKey = com.baidu.swan.apps.runtime.e.arv() == null ? null : com.baidu.swan.apps.runtime.e.arv().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = jg;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.v("target_appkey", str2);
            }
            eVar.v("current_appkey", appKey);
            h.e(eVar);
            this.doX.add(S);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String jg = jg(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = jg;
        if (b != null) {
            eVar.v("game_list", b);
        }
        h.e(eVar);
        this.doX.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String jg = jg(i);
        String appKey = com.baidu.swan.apps.runtime.e.arv() == null ? null : com.baidu.swan.apps.runtime.e.arv().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = jg;
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
        String jg = jg(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = jg;
        if (b != null) {
            eVar.v("game_list", b);
        }
        h.e(eVar);
    }

    private String jg(int i) {
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
        if (aVar == null || aVar.dpt == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.dpt) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String S(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
