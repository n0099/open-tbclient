package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.ubc.s;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0285a c0285a) {
        if (c0285a != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(c0285a.from)) {
                    jSONObject.put("from", c0285a.from);
                }
                if (!TextUtils.isEmpty(c0285a.type)) {
                    jSONObject.put("type", c0285a.type);
                }
                if (!TextUtils.isEmpty(c0285a.value)) {
                    jSONObject.put("value", c0285a.value);
                }
                if (!TextUtils.isEmpty(c0285a.source)) {
                    jSONObject.put("source", c0285a.source);
                }
                if (!TextUtils.isEmpty(c0285a.page)) {
                    jSONObject.put("page", c0285a.page);
                }
                boolean isEmpty = TextUtils.isEmpty(c0285a.appId);
                boolean isEmpty2 = TextUtils.isEmpty(c0285a.bPT);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", c0285a.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put("info", c0285a.bPT);
                    }
                    jSONObject.put("ext", jSONObject2);
                }
                m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        s.k("777", jSONObject);
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
    /* loaded from: classes9.dex */
    public static class C0285a {
        private String appId;
        private String bPT;
        private String page;
        private String source;
        private String type;
        private String value;
        private a bPS = new a();
        private String from = "swan";

        public C0285a(int i) {
            this.type = String.valueOf(i);
        }

        public C0285a ll(String str) {
            this.page = str;
            return this;
        }

        public C0285a lm(String str) {
            this.appId = str;
            return this;
        }

        public C0285a ln(String str) {
            this.bPT = str;
            return this;
        }

        public void Tz() {
            this.bPS.a(this);
        }
    }
}
