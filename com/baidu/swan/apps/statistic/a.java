package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.ubc.q;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0174a c0174a) {
        if (c0174a != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(c0174a.from)) {
                    jSONObject.put("from", c0174a.from);
                }
                if (!TextUtils.isEmpty(c0174a.type)) {
                    jSONObject.put("type", c0174a.type);
                }
                if (!TextUtils.isEmpty(c0174a.value)) {
                    jSONObject.put(UBC.CONTENT_KEY_VALUE, c0174a.value);
                }
                if (!TextUtils.isEmpty(c0174a.source)) {
                    jSONObject.put("source", c0174a.source);
                }
                if (!TextUtils.isEmpty(c0174a.page)) {
                    jSONObject.put("page", c0174a.page);
                }
                boolean isEmpty = TextUtils.isEmpty(c0174a.appId);
                boolean isEmpty2 = TextUtils.isEmpty(c0174a.aSd);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", c0174a.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put("info", c0174a.aSd);
                    }
                    jSONObject.put("ext", jSONObject2);
                }
                j.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        q.onEvent("777", jSONObject);
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
    public static class C0174a {
        private String aSd;
        private String appId;
        private String page;
        private String source;
        private String type;
        private String value;
        private a aSc = new a();
        private String from = "swan";

        public C0174a(int i) {
            this.type = String.valueOf(i);
        }

        public C0174a gN(String str) {
            this.appId = str;
            return this;
        }

        public C0174a gO(String str) {
            this.aSd = str;
            return this;
        }

        public void Kq() {
            this.aSc.a(this);
        }
    }
}
