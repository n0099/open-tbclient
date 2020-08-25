package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bb {
    private String aJm;
    private String aJn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(String str) {
        parserJson(str);
    }

    public boolean CU() {
        return "1".equals(this.aJm) && !TextUtils.isEmpty(this.aJn);
    }

    public String CV() {
        return this.aJn;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aJm = jSONObject.optString("is_open");
                this.aJn = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
