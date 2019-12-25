package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ah {
    private String aaw;
    private String aax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(String str) {
        parserJson(str);
    }

    public boolean pQ() {
        return "1".equals(this.aaw) && !TextUtils.isEmpty(this.aax);
    }

    public String pR() {
        return this.aax;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aaw = jSONObject.optString("is_open");
                this.aax = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
