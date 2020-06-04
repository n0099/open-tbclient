package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class c {
    public static final String deo = null;
    private List<String> dep = new ArrayList();

    public void f(int i, String str, String str2) {
        String iE = iE(i);
        String R = R(iE, str, str2);
        if (!this.dep.contains(R)) {
            String appKey = com.baidu.swan.apps.runtime.e.aoF() == null ? null : com.baidu.swan.apps.runtime.e.aoF().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = iE;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.v("target_appkey", str2);
            }
            eVar.v("current_appkey", appKey);
            h.e(eVar);
            this.dep.add(R);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String iE = iE(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = iE;
        if (b != null) {
            eVar.v("game_list", b);
        }
        h.e(eVar);
        this.dep.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String iE = iE(i);
        String appKey = com.baidu.swan.apps.runtime.e.aoF() == null ? null : com.baidu.swan.apps.runtime.e.aoF().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = iE;
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
        String iE = iE(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = iE;
        if (b != null) {
            eVar.v("game_list", b);
        }
        h.e(eVar);
    }

    private String iE(int i) {
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
        if (aVar == null || aVar.deM == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.deM) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String R(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
