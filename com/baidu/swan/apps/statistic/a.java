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
    public void a(C0327a c0327a) {
        if (c0327a != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(c0327a.from)) {
                    jSONObject.put("from", c0327a.from);
                }
                if (!TextUtils.isEmpty(c0327a.type)) {
                    jSONObject.put("type", c0327a.type);
                }
                if (!TextUtils.isEmpty(c0327a.value)) {
                    jSONObject.put("value", c0327a.value);
                }
                if (!TextUtils.isEmpty(c0327a.source)) {
                    jSONObject.put("source", c0327a.source);
                }
                if (!TextUtils.isEmpty(c0327a.page)) {
                    jSONObject.put("page", c0327a.page);
                }
                boolean isEmpty = TextUtils.isEmpty(c0327a.appId);
                boolean isEmpty2 = TextUtils.isEmpty(c0327a.ctL);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", c0327a.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put("info", c0327a.ctL);
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
    public static class C0327a {
        private String appId;
        private String ctL;
        private String page;
        private String source;
        private String type;
        private String value;
        private a ctK = new a();
        private String from = "swan";

        public C0327a(int i) {
            this.type = String.valueOf(i);
        }

        public C0327a mP(String str) {
            this.page = str;
            return this;
        }

        public C0327a mQ(String str) {
            this.appId = str;
            return this;
        }

        public C0327a mR(String str) {
            this.ctL = str;
            return this;
        }

        public void aee() {
            this.ctK.a(this);
        }
    }
}
