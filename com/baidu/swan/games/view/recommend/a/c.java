package com.baidu.swan.games.view.recommend.a;

import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c {
    public static final String bmJ = null;
    private List<String> bmK = new ArrayList();

    public void f(int i, String str, String str2) {
        String fn = fn(i);
        String A = A(fn, str, str2);
        if (!this.bmK.contains(A)) {
            String appKey = com.baidu.swan.apps.ae.b.Md() == null ? null : com.baidu.swan.apps.ae.b.Md().getAppKey();
            f fVar = new f();
            fVar.mType = "click";
            fVar.azs = fn;
            fVar.mValue = str;
            if (str2 != null) {
                fVar.k("target_appkey", str2);
            }
            fVar.k("current_appkey", appKey);
            com.baidu.swan.apps.statistic.e.d(fVar);
            this.bmK.add(A);
        }
    }

    public void a(int i, com.baidu.swan.games.view.recommend.d.b bVar) {
        String fn = fn(i);
        JSONArray b = b(bVar);
        f fVar = new f();
        fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
        fVar.azs = fn;
        if (b != null) {
            fVar.k("game_list", b);
        }
        com.baidu.swan.apps.statistic.e.d(fVar);
        this.bmK.clear();
    }

    private String fn(int i) {
        switch (i) {
            case 1:
                return "carousel";
            case 2:
                return IntentConfig.LIST;
            default:
                return null;
        }
    }

    private JSONArray b(com.baidu.swan.games.view.recommend.d.b bVar) {
        if (bVar == null || bVar.bng == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.swan.games.view.recommend.d.a aVar : bVar.bng) {
            jSONArray.put(aVar.appKey);
        }
        return jSONArray;
    }

    private String A(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }
}
