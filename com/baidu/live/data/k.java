package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class k {
    String aGH;

    public k(String str) {
        this.aGH = str;
    }

    public a cz(int i) {
        a aVar;
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(this.aGH)) {
            return null;
        }
        try {
            optJSONObject = new JSONObject(this.aGH).optJSONObject(String.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (optJSONObject != null) {
            aVar = new a(optJSONObject);
            return aVar;
        }
        aVar = null;
        return aVar;
    }

    /* loaded from: classes11.dex */
    public static class a {
        String aGI;
        String aGJ;
        String endColor;
        String iconUrl;
        String startColor;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.iconUrl = jSONObject.optString("icon_url");
                this.startColor = jSONObject.optString("start_color");
                this.endColor = jSONObject.optString("end_color");
                this.aGI = jSONObject.optString("text_color");
                this.aGJ = jSONObject.optString("offset");
            }
        }

        public String Bp() {
            return this.aGJ;
        }

        public String Bq() {
            return this.startColor;
        }

        public String Br() {
            return this.endColor;
        }

        public String Bs() {
            return this.aGI;
        }
    }
}
