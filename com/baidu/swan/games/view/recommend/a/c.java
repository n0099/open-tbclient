package com.baidu.swan.games.view.recommend.a;

import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class c {
    public static final String eoJ = null;
    private List<String> eoK = new ArrayList();

    public void i(int i, String str, String str2) {
        String ls = ls(i);
        String aj = aj(ls, str, str2);
        if (!this.eoK.contains(aj)) {
            String appKey = com.baidu.swan.apps.runtime.e.aIN() == null ? null : com.baidu.swan.apps.runtime.e.aIN().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = ls;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.s("target_appkey", str2);
            }
            eVar.s("current_appkey", appKey);
            h.e(eVar);
            this.eoK.add(aj);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String ls = ls(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = ls;
        if (b != null) {
            eVar.s("game_list", b);
        }
        h.e(eVar);
        this.eoK.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String ls = ls(i);
        String appKey = com.baidu.swan.apps.runtime.e.aIN() == null ? null : com.baidu.swan.apps.runtime.e.aIN().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = ls;
        eVar.mValue = str;
        if (str2 != null) {
            eVar.s("target_appkey", str2);
        }
        eVar.s("current_appkey", appKey);
        if (!TextUtils.isEmpty(str3)) {
            eVar.s(Headers.LOCATION, str3);
        }
        h.e(eVar);
    }

    public void b(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String ls = ls(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = ls;
        if (b != null) {
            eVar.s("game_list", b);
        }
        h.e(eVar);
    }

    private String ls(int i) {
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
        if (aVar == null || aVar.epg == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.epg) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String aj(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
