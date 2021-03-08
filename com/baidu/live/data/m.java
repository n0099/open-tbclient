package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class m {
    String aIh;

    public m(String str) {
        this.aIh = str;
    }

    public a cC(int i) {
        if (TextUtils.isEmpty(this.aIh)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(this.aIh).optJSONObject(String.valueOf(i));
            if (optJSONObject != null) {
                return new a(optJSONObject);
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        String aIi;
        String aIj;
        String aIk;
        String borderColor;
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
                this.borderColor = jSONObject.optString("border_color");
                this.aIk = jSONObject.optString("middile_color");
                this.aIj = jSONObject.optString("offset");
            }
        }

        public String Bs() {
            return this.aIj;
        }

        public String Bw() {
            return this.aIk;
        }

        public String Bx() {
            return this.borderColor;
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
