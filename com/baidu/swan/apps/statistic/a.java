package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.ubc.s;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0219a c0219a) {
        if (c0219a != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(c0219a.from)) {
                    jSONObject.put("from", c0219a.from);
                }
                if (!TextUtils.isEmpty(c0219a.type)) {
                    jSONObject.put("type", c0219a.type);
                }
                if (!TextUtils.isEmpty(c0219a.value)) {
                    jSONObject.put("value", c0219a.value);
                }
                if (!TextUtils.isEmpty(c0219a.source)) {
                    jSONObject.put("source", c0219a.source);
                }
                if (!TextUtils.isEmpty(c0219a.page)) {
                    jSONObject.put("page", c0219a.page);
                }
                boolean isEmpty = TextUtils.isEmpty(c0219a.appId);
                boolean isEmpty2 = TextUtils.isEmpty(c0219a.boP);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", c0219a.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put(Config.LAUNCH_INFO, c0219a.boP);
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
    public static class C0219a {
        private String appId;
        private String boP;
        private String page;
        private String source;
        private String type;
        private String value;
        private a boO = new a();
        private String from = "swan";

        public C0219a(int i) {
            this.type = String.valueOf(i);
        }

        public C0219a hU(String str) {
            this.appId = str;
            return this;
        }

        public C0219a hV(String str) {
            this.boP = str;
            return this;
        }

        public void La() {
            this.boO.a(this);
        }
    }
}
