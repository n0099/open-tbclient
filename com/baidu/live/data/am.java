package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class am {
    private String acQ;
    private String acR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(String str) {
        parserJson(str);
    }

    public boolean qL() {
        return "1".equals(this.acQ) && !TextUtils.isEmpty(this.acR);
    }

    public String qM() {
        return this.acR;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.acQ = jSONObject.optString("is_open");
                this.acR = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
