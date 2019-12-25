package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class c {
    public static final String cpJ = null;
    private List<String> cpK = new ArrayList();

    public void e(int i, String str, String str2) {
        String hN = hN(i);
        String N = N(hN, str, str2);
        if (!this.cpK.contains(N)) {
            String appKey = com.baidu.swan.apps.runtime.e.ZS() == null ? null : com.baidu.swan.apps.runtime.e.ZS().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = hN;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.n("target_appkey", str2);
            }
            eVar.n("current_appkey", appKey);
            f.b(eVar);
            this.cpK.add(N);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String hN = hN(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = hN;
        if (b != null) {
            eVar.n("game_list", b);
        }
        f.b(eVar);
        this.cpK.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String hN = hN(i);
        String appKey = com.baidu.swan.apps.runtime.e.ZS() == null ? null : com.baidu.swan.apps.runtime.e.ZS().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = hN;
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
        String hN = hN(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = hN;
        if (b != null) {
            eVar.n("game_list", b);
        }
        f.b(eVar);
    }

    private String hN(int i) {
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
        if (aVar == null || aVar.cqg == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.cqg) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String N(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
