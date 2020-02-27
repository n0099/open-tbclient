package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class am {
    private String acG;
    private String acH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(String str) {
        parserJson(str);
    }

    public boolean qG() {
        return "1".equals(this.acG) && !TextUtils.isEmpty(this.acH);
    }

    public String qH() {
        return this.acH;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.acG = jSONObject.optString("is_open");
                this.acH = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
