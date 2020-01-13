package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class al {
    private String aaI;
    private String aaJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(String str) {
        parserJson(str);
    }

    public boolean pV() {
        return "1".equals(this.aaI) && !TextUtils.isEmpty(this.aaJ);
    }

    public String pW() {
        return this.aaJ;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aaI = jSONObject.optString("is_open");
                this.aaJ = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
