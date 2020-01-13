package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.ubc.s;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0287a c0287a) {
        if (c0287a != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(c0287a.from)) {
                    jSONObject.put("from", c0287a.from);
                }
                if (!TextUtils.isEmpty(c0287a.type)) {
                    jSONObject.put("type", c0287a.type);
                }
                if (!TextUtils.isEmpty(c0287a.value)) {
                    jSONObject.put("value", c0287a.value);
                }
                if (!TextUtils.isEmpty(c0287a.source)) {
                    jSONObject.put("source", c0287a.source);
                }
                if (!TextUtils.isEmpty(c0287a.page)) {
                    jSONObject.put("page", c0287a.page);
                }
                boolean isEmpty = TextUtils.isEmpty(c0287a.appId);
                boolean isEmpty2 = TextUtils.isEmpty(c0287a.bQD);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", c0287a.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put("info", c0287a.bQD);
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
    /* loaded from: classes10.dex */
    public static class C0287a {
        private String appId;
        private String bQD;
        private String page;
        private String source;
        private String type;
        private String value;
        private a bQC = new a();
        private String from = "swan";

        public C0287a(int i) {
            this.type = String.valueOf(i);
        }

        public C0287a lo(String str) {
            this.page = str;
            return this;
        }

        public C0287a lp(String str) {
            this.appId = str;
            return this;
        }

        public C0287a lq(String str) {
            this.bQD = str;
            return this;
        }

        public void TW() {
            this.bQC.a(this);
        }
    }
}
