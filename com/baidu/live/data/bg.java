package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bg {
    private String aNJ;
    private String aNK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(String str) {
        parserJson(str);
    }

    public boolean Eh() {
        return "1".equals(this.aNJ) && !TextUtils.isEmpty(this.aNK);
    }

    public String Ei() {
        return this.aNK;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aNJ = jSONObject.optString("is_open");
                this.aNK = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
