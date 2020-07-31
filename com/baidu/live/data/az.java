package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class az {
    private String aEc;
    private String aEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(String str) {
        parserJson(str);
    }

    public boolean xr() {
        return "1".equals(this.aEc) && !TextUtils.isEmpty(this.aEd);
    }

    public String xs() {
        return this.aEd;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aEc = jSONObject.optString("is_open");
                this.aEd = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
