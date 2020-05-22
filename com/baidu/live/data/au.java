package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class au {
    private String aAw;
    private String aAx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(String str) {
        parserJson(str);
    }

    public boolean wq() {
        return "1".equals(this.aAw) && !TextUtils.isEmpty(this.aAx);
    }

    public String wr() {
        return this.aAx;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aAw = jSONObject.optString("is_open");
                this.aAx = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
