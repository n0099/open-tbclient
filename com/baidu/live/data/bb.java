package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bb {
    private String aJo;
    private String aJp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(String str) {
        parserJson(str);
    }

    public boolean CU() {
        return "1".equals(this.aJo) && !TextUtils.isEmpty(this.aJp);
    }

    public String CV() {
        return this.aJp;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aJo = jSONObject.optString("is_open");
                this.aJp = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
