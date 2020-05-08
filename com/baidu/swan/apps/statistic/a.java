package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.ubc.s;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0348a c0348a) {
        if (c0348a != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(c0348a.from)) {
                    jSONObject.put("from", c0348a.from);
                }
                if (!TextUtils.isEmpty(c0348a.type)) {
                    jSONObject.put("type", c0348a.type);
                }
                if (!TextUtils.isEmpty(c0348a.value)) {
                    jSONObject.put("value", c0348a.value);
                }
                if (!TextUtils.isEmpty(c0348a.source)) {
                    jSONObject.put("source", c0348a.source);
                }
                if (!TextUtils.isEmpty(c0348a.page)) {
                    jSONObject.put("page", c0348a.page);
                }
                boolean isEmpty = TextUtils.isEmpty(c0348a.appId);
                boolean isEmpty2 = TextUtils.isEmpty(c0348a.ctR);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", c0348a.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put("info", c0348a.ctR);
                    }
                    jSONObject.put("ext", jSONObject2);
                }
                m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.a.1
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
    /* loaded from: classes11.dex */
    public static class C0348a {
        private String appId;
        private String ctR;
        private String page;
        private String source;
        private String type;
        private String value;
        private a ctQ = new a();
        private String from = "swan";

        public C0348a(int i) {
            this.type = String.valueOf(i);
        }

        public C0348a mP(String str) {
            this.page = str;
            return this;
        }

        public C0348a mQ(String str) {
            this.appId = str;
            return this;
        }

        public C0348a mR(String str) {
            this.ctR = str;
            return this;
        }

        public void aed() {
            this.ctQ.a(this);
        }
    }
}
