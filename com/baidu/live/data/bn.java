package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bn {
    private String aRp;
    private String aRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(String str) {
        parserJson(str);
    }

    public boolean Ff() {
        return "1".equals(this.aRp) && !TextUtils.isEmpty(this.aRq);
    }

    public String Fg() {
        return this.aRq;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aRp = jSONObject.optString("is_open");
                this.aRq = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
