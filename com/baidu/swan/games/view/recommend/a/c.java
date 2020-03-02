package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class c {
    public static final String ctX = null;
    private List<String> ctY = new ArrayList();

    public void e(int i, String str, String str2) {
        String ie = ie(i);
        String O = O(ie, str, str2);
        if (!this.ctY.contains(O)) {
            String appKey = com.baidu.swan.apps.runtime.e.acF() == null ? null : com.baidu.swan.apps.runtime.e.acF().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = ie;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.n("target_appkey", str2);
            }
            eVar.n("current_appkey", appKey);
            f.b(eVar);
            this.ctY.add(O);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String ie = ie(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = ie;
        if (b != null) {
            eVar.n("game_list", b);
        }
        f.b(eVar);
        this.ctY.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String ie = ie(i);
        String appKey = com.baidu.swan.apps.runtime.e.acF() == null ? null : com.baidu.swan.apps.runtime.e.acF().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = ie;
        eVar.mValue = str;
        if (str2 != null) {
            eVar.n("target_appkey", str2);
        }
        eVar.n("current_appkey", appKey);
        if (!TextUtils.isEmpty(str3)) {
            eVar.n("location", str3);
        }
        f.b(eVar);
    }

    public void b(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String ie = ie(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = ie;
        if (b != null) {
            eVar.n("game_list", b);
        }
        f.b(eVar);
    }

    private String ie(int i) {
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
        if (aVar == null || aVar.cuw == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.cuw) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String O(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
