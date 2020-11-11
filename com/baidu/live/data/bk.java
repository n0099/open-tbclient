package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bk {
    private String aPl;
    private String aPm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(String str) {
        parserJson(str);
    }

    public boolean EN() {
        return "1".equals(this.aPl) && !TextUtils.isEmpty(this.aPm);
    }

    public String EO() {
        return this.aPm;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aPl = jSONObject.optString("is_open");
                this.aPm = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
