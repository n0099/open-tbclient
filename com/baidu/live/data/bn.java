package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bn {
    private String aMC;
    private String aMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(String str) {
        parserJson(str);
    }

    public boolean Bk() {
        return "1".equals(this.aMC) && !TextUtils.isEmpty(this.aMD);
    }

    public String Bl() {
        return this.aMD;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aMC = jSONObject.optString("is_open");
                this.aMD = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
