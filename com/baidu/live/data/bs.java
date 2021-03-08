package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bs {
    private String aRa;
    private String aRb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(String str) {
        parserJson(str);
    }

    public boolean CA() {
        return "1".equals(this.aRa) && !TextUtils.isEmpty(this.aRb);
    }

    public String CB() {
        return this.aRb;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aRa = jSONObject.optString("is_open");
                this.aRb = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
