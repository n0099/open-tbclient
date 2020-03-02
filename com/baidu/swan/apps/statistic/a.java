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
    public void a(C0297a c0297a) {
        if (c0297a != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(c0297a.from)) {
                    jSONObject.put("from", c0297a.from);
                }
                if (!TextUtils.isEmpty(c0297a.type)) {
                    jSONObject.put("type", c0297a.type);
                }
                if (!TextUtils.isEmpty(c0297a.value)) {
                    jSONObject.put("value", c0297a.value);
                }
                if (!TextUtils.isEmpty(c0297a.source)) {
                    jSONObject.put("source", c0297a.source);
                }
                if (!TextUtils.isEmpty(c0297a.page)) {
                    jSONObject.put("page", c0297a.page);
                }
                boolean isEmpty = TextUtils.isEmpty(c0297a.appId);
                boolean isEmpty2 = TextUtils.isEmpty(c0297a.bUJ);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", c0297a.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put("info", c0297a.bUJ);
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
    /* loaded from: classes11.dex */
    public static class C0297a {
        private String appId;
        private String bUJ;
        private String page;
        private String source;
        private String type;
        private String value;
        private a bUI = new a();
        private String from = "swan";

        public C0297a(int i) {
            this.type = String.valueOf(i);
        }

        public C0297a lD(String str) {
            this.page = str;
            return this;
        }

        public C0297a lE(String str) {
            this.appId = str;
            return this;
        }

        public C0297a lF(String str) {
            this.bUJ = str;
            return this;
        }

        public void Wm() {
            this.bUI.a(this);
        }
    }
}
