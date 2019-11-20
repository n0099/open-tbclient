package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ae {
    private String TG;
    private String TH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(String str) {
        parserJson(str);
    }

    public boolean oy() {
        return "1".equals(this.TG) && !TextUtils.isEmpty(this.TH);
    }

    public String oz() {
        return this.TH;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.TG = jSONObject.optString("is_open");
                this.TH = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
