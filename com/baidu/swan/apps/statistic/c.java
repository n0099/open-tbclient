package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(aVar.from)) {
                    jSONObject.put("from", aVar.from);
                }
                if (!TextUtils.isEmpty(aVar.type)) {
                    jSONObject.put("type", aVar.type);
                }
                if (!TextUtils.isEmpty(aVar.value)) {
                    jSONObject.put("value", aVar.value);
                }
                if (!TextUtils.isEmpty(aVar.source)) {
                    jSONObject.put("source", aVar.source);
                }
                if (!TextUtils.isEmpty(aVar.page)) {
                    jSONObject.put("page", aVar.page);
                }
                boolean isEmpty = TextUtils.isEmpty(aVar.appId);
                boolean isEmpty2 = TextUtils.isEmpty(aVar.dtI);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", aVar.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put("info", aVar.dtI);
                    }
                    jSONObject.put("ext", jSONObject2);
                }
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.onEvent("777", jSONObject);
                        com.baidu.swan.apps.console.c.bn("SwanAppBusinessUbc", jSONObject.toString());
                    }
                }, "SwanAppBusinessUbcRunnable");
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private String appId;
        private String dtI;
        private String page;
        private String source;
        private String type;
        private String value;
        private c dtH = new c();
        private String from = "swan";

        public a(int i) {
            this.type = String.valueOf(i);
        }

        public a sG(String str) {
            this.source = str;
            return this;
        }

        public a sH(String str) {
            this.page = str;
            return this;
        }

        public a sI(String str) {
            this.appId = str;
            return this;
        }

        public a sJ(String str) {
            this.dtI = str;
            return this;
        }

        public void arq() {
            this.dtH.a(this);
        }
    }
}
