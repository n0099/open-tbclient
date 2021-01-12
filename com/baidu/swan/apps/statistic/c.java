package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
                boolean isEmpty2 = TextUtils.isEmpty(aVar.dIK);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", aVar.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put("info", aVar.dIK);
                    }
                    jSONObject.put("ext", jSONObject2);
                }
                p.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.onEvent("777", jSONObject);
                        com.baidu.swan.apps.console.c.br("SwanAppBusinessUbc", jSONObject.toString());
                    }
                }, "SwanAppBusinessUbcRunnable");
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        private String appId;
        private String dIK;
        private String page;
        private String source;
        private String type;
        private String value;
        private c dIJ = new c();
        private String from = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;

        public a(int i) {
            this.type = String.valueOf(i);
        }

        public a sh(String str) {
            this.source = str;
            return this;
        }

        public a si(String str) {
            this.page = str;
            return this;
        }

        public a sj(String str) {
            this.appId = str;
            return this;
        }

        public a sk(String str) {
            this.dIK = str;
            return this;
        }

        public void atQ() {
            this.dIJ.a(this);
        }
    }
}
