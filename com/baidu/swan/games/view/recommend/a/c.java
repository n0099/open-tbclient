package com.baidu.swan.games.view.recommend.a;

import com.baidu.swan.apps.statistic.a.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c {
    public static final String bFc = null;
    private List<String> bFd = new ArrayList();

    public void g(int i, String str, String str2) {
        String gi = gi(i);
        String E = E(gi, str, str2);
        if (!this.bFd.contains(E)) {
            String appKey = com.baidu.swan.apps.ae.b.Ra() == null ? null : com.baidu.swan.apps.ae.b.Ra().getAppKey();
            f fVar = new f();
            fVar.mType = "click";
            fVar.aSM = gi;
            fVar.mValue = str;
            if (str2 != null) {
                fVar.h("target_appkey", str2);
            }
            fVar.h("current_appkey", appKey);
            com.baidu.swan.apps.statistic.e.d(fVar);
            this.bFd.add(E);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.d.b bVar) {
        String gi = gi(i);
        JSONArray b = b(bVar);
        f fVar = new f();
        fVar.mType = "show";
        fVar.aSM = gi;
        if (b != null) {
            fVar.h("game_list", b);
        }
        com.baidu.swan.apps.statistic.e.d(fVar);
        this.bFd.clear();
    }

    private String gi(int i) {
        switch (i) {
            case 1:
                return "carousel";
            case 2:
                return "list";
            default:
                return null;
        }
    }

    private JSONArray b(com.baidu.swan.games.view.recommend.d.b bVar) {
        if (bVar == null || bVar.bFz == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.games.view.recommend.d.a aVar : bVar.bFz) {
            jSONArray.put(aVar.appKey);
        }
        return jSONArray;
    }

    private String E(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
