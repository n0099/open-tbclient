package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
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
    public void a(C0181a c0181a) {
        if (c0181a != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(c0181a.from)) {
                    jSONObject.put("from", c0181a.from);
                }
                if (!TextUtils.isEmpty(c0181a.type)) {
                    jSONObject.put("type", c0181a.type);
                }
                if (!TextUtils.isEmpty(c0181a.value)) {
                    jSONObject.put(UBC.CONTENT_KEY_VALUE, c0181a.value);
                }
                if (!TextUtils.isEmpty(c0181a.source)) {
                    jSONObject.put("source", c0181a.source);
                }
                if (!TextUtils.isEmpty(c0181a.page)) {
                    jSONObject.put("page", c0181a.page);
                }
                boolean isEmpty = TextUtils.isEmpty(c0181a.appId);
                boolean isEmpty2 = TextUtils.isEmpty(c0181a.aUV);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", c0181a.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put("info", c0181a.aUV);
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
    public static class C0181a {
        private String aUV;
        private String appId;
        private String page;
        private String source;
        private String type;
        private String value;
        private a aUU = new a();
        private String from = "swan";

        public C0181a(int i) {
            this.type = String.valueOf(i);
        }

        public C0181a hi(String str) {
            this.appId = str;
            return this;
        }

        public C0181a hj(String str) {
            this.aUV = str;
            return this;
        }

        public void Fr() {
            this.aUU.a(this);
        }
    }
}
