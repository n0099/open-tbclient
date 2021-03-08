package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k {
    String aIh;

    public k(String str) {
        this.aIh = str;
    }

    public a cA(int i) {
        a aVar;
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(this.aIh)) {
            return null;
        }
        try {
            optJSONObject = new JSONObject(this.aIh).optJSONObject(String.valueOf(i));
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

    /* loaded from: classes10.dex */
    public static class a {
        String aIi;
        String aIj;
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
                this.aIi = jSONObject.optString("text_color");
                this.aIj = jSONObject.optString("offset");
            }
        }

        public String Bs() {
            return this.aIj;
        }

        public String Bt() {
            return this.startColor;
        }

        public String Bu() {
            return this.endColor;
        }

        public String Bv() {
            return this.aIi;
        }
    }
}
