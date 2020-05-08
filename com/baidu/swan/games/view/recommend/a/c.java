package com.baidu.swan.games.view.recommend.a;

import android.text.TextUtils;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class c {
    public static final String cTm = null;
    private List<String> cTn = new ArrayList();

    public void f(int i, String str, String str2) {
        String il = il(i);
        String O = O(il, str, str2);
        if (!this.cTn.contains(O)) {
            String appKey = com.baidu.swan.apps.runtime.e.akM() == null ? null : com.baidu.swan.apps.runtime.e.akM().getAppKey();
            com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
            eVar.mType = "click";
            eVar.mPage = il;
            eVar.mValue = str;
            if (str2 != null) {
                eVar.s("target_appkey", str2);
            }
            eVar.s("current_appkey", appKey);
            f.b(eVar);
            this.cTn.add(O);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String il = il(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = il;
        if (b != null) {
            eVar.s("game_list", b);
        }
        f.b(eVar);
        this.cTn.clear();
    }

    public void c(int i, String str, String str2, String str3) {
        String il = il(i);
        String appKey = com.baidu.swan.apps.runtime.e.akM() == null ? null : com.baidu.swan.apps.runtime.e.akM().getAppKey();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "click";
        eVar.mPage = il;
        eVar.mValue = str;
        if (str2 != null) {
            eVar.s("target_appkey", str2);
        }
        eVar.s("current_appkey", appKey);
        if (!TextUtils.isEmpty(str3)) {
            eVar.s("location", str3);
        }
        f.b(eVar);
    }

    public void b(int i, com.baidu.swan.games.view.recommend.model.a aVar) {
        String il = il(i);
        JSONArray b = b(aVar);
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = "show";
        eVar.mPage = il;
        if (b != null) {
            eVar.s("game_list", b);
        }
        f.b(eVar);
    }

    private String il(int i) {
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
        if (aVar == null || aVar.cTJ == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.cTJ) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    private String O(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
