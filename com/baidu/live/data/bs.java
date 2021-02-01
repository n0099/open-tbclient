package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bs {
    private String aPA;
    private String aPB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(String str) {
        parserJson(str);
    }

    public boolean Cx() {
        return "1".equals(this.aPA) && !TextUtils.isEmpty(this.aPB);
    }

    public String Cy() {
        return this.aPB;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aPA = jSONObject.optString("is_open");
                this.aPB = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
