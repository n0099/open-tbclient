package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class m {
    String aGH;

    public m(String str) {
        this.aGH = str;
    }

    public a cB(int i) {
        if (TextUtils.isEmpty(this.aGH)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(this.aGH).optJSONObject(String.valueOf(i));
            if (optJSONObject != null) {
                return new a(optJSONObject);
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        String aGI;
        String aGJ;
        String aGK;
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
                this.aGI = jSONObject.optString("text_color");
                this.borderColor = jSONObject.optString("border_color");
                this.aGK = jSONObject.optString("middile_color");
                this.aGJ = jSONObject.optString("offset");
            }
        }

        public String Bp() {
            return this.aGJ;
        }

        public String Bt() {
            return this.aGK;
        }

        public String Bu() {
            return this.borderColor;
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
