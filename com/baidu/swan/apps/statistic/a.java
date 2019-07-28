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
    public void a(C0183a c0183a) {
        if (c0183a != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(c0183a.from)) {
                    jSONObject.put("from", c0183a.from);
                }
                if (!TextUtils.isEmpty(c0183a.type)) {
                    jSONObject.put("type", c0183a.type);
                }
                if (!TextUtils.isEmpty(c0183a.value)) {
                    jSONObject.put(UBC.CONTENT_KEY_VALUE, c0183a.value);
                }
                if (!TextUtils.isEmpty(c0183a.source)) {
                    jSONObject.put("source", c0183a.source);
                }
                if (!TextUtils.isEmpty(c0183a.page)) {
                    jSONObject.put("page", c0183a.page);
                }
                boolean isEmpty = TextUtils.isEmpty(c0183a.appId);
                boolean isEmpty2 = TextUtils.isEmpty(c0183a.aVF);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", c0183a.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put(Config.LAUNCH_INFO, c0183a.aVF);
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
    public static class C0183a {
        private String aVF;
        private String appId;
        private String page;
        private String source;
        private String type;
        private String value;
        private a aVE = new a();
        private String from = "swan";

        public C0183a(int i) {
            this.type = String.valueOf(i);
        }

        public C0183a hp(String str) {
            this.appId = str;
            return this;
        }

        public C0183a hq(String str) {
            this.aVF = str;
            return this;
        }

        public void Gb() {
            this.aVE.a(this);
        }
    }
}
