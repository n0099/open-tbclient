package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ae {
    private String Ua;
    private String Ub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(String str) {
        parserJson(str);
    }

    public boolean oy() {
        return "1".equals(this.Ua) && !TextUtils.isEmpty(this.Ub);
    }

    public String oz() {
        return this.Ub;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.Ua = jSONObject.optString("is_open");
                this.Ub = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
