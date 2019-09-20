package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.ubc.s;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0192a c0192a) {
        if (c0192a != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(c0192a.from)) {
                    jSONObject.put("from", c0192a.from);
                }
                if (!TextUtils.isEmpty(c0192a.type)) {
                    jSONObject.put("type", c0192a.type);
                }
                if (!TextUtils.isEmpty(c0192a.value)) {
                    jSONObject.put(UBC.CONTENT_KEY_VALUE, c0192a.value);
                }
                if (!TextUtils.isEmpty(c0192a.source)) {
                    jSONObject.put("source", c0192a.source);
                }
                if (!TextUtils.isEmpty(c0192a.page)) {
                    jSONObject.put("page", c0192a.page);
                }
                boolean isEmpty = TextUtils.isEmpty(c0192a.appId);
                boolean isEmpty2 = TextUtils.isEmpty(c0192a.aWd);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", c0192a.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put(Config.LAUNCH_INFO, c0192a.aWd);
                    }
                    jSONObject.put("ext", jSONObject2);
                }
                j.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        s.onEvent("777", jSONObject);
                    }
                }, "SwanAppBusinessUbcRunnable");
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.statistic.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0192a {
        private String aWd;
        private String appId;
        private String page;
        private String source;
        private String type;
        private String value;
        private a aWc = new a();
        private String from = "swan";

        public C0192a(int i) {
            this.type = String.valueOf(i);
        }

        public C0192a hr(String str) {
            this.appId = str;
            return this;
        }

        public C0192a hs(String str) {
            this.aWd = str;
            return this;
        }

        public void Gf() {
            this.aWc.a(this);
        }
    }
}
