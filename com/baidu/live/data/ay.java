package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ay {
    private String aCH;
    private String aCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(String str) {
        parserJson(str);
    }

    public boolean wO() {
        return "1".equals(this.aCH) && !TextUtils.isEmpty(this.aCI);
    }

    public String wP() {
        return this.aCI;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aCH = jSONObject.optString("is_open");
                this.aCI = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
