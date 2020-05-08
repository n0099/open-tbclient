package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ap {
    private String avo;
    private String avp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(String str) {
        parserJson(str);
    }

    public boolean vb() {
        return "1".equals(this.avo) && !TextUtils.isEmpty(this.avp);
    }

    public String vc() {
        return this.avp;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.avo = jSONObject.optString("is_open");
                this.avp = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
