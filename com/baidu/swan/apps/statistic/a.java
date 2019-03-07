package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.ubc.r;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0145a c0145a) {
        if (c0145a != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(c0145a.from)) {
                    jSONObject.put("from", c0145a.from);
                }
                if (!TextUtils.isEmpty(c0145a.type)) {
                    jSONObject.put("type", c0145a.type);
                }
                if (!TextUtils.isEmpty(c0145a.value)) {
                    jSONObject.put(UBC.CONTENT_KEY_VALUE, c0145a.value);
                }
                if (!TextUtils.isEmpty(c0145a.source)) {
                    jSONObject.put("source", c0145a.source);
                }
                if (!TextUtils.isEmpty(c0145a.page)) {
                    jSONObject.put("page", c0145a.page);
                }
                boolean isEmpty = TextUtils.isEmpty(c0145a.appId);
                boolean isEmpty2 = TextUtils.isEmpty(c0145a.aSc);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", c0145a.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put("info", c0145a.aSc);
                    }
                    jSONObject.put("ext", jSONObject2);
                }
                j.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        r.onEvent("777", jSONObject);
                    }
                }, "SwanAppBusinessUbcRunnable");
            } catch (JSONException e) {
                if (com.baidu.swan.apps.c.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.statistic.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0145a {
        private String aSc;
        private String appId;
        private String page;
        private String source;
        private String type;
        private String value;
        private a aSb = new a();
        private String from = "swan";

        public C0145a(int i) {
            this.type = String.valueOf(i);
        }

        public C0145a gN(String str) {
            this.appId = str;
            return this;
        }

        public C0145a gO(String str) {
            this.aSc = str;
            return this;
        }

        public void Kq() {
            this.aSb.a(this);
        }
    }
}
