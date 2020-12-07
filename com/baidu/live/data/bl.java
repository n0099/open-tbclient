package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bl {
    private String aQA;
    private String aQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(String str) {
        parserJson(str);
    }

    public boolean FP() {
        return "1".equals(this.aQA) && !TextUtils.isEmpty(this.aQB);
    }

    public String FQ() {
        return this.aQB;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aQA = jSONObject.optString("is_open");
                this.aQB = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
