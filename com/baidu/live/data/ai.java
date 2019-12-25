package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ai {
    private String aaA;
    private String aaB;
    private String aay;
    private String aaz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(String str) {
        parserJson(str);
    }

    public boolean pS() {
        return "1".equals(this.aaA);
    }

    public boolean pT() {
        return "1".equals(this.aaB);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aay = jSONObject.optString("is_prettify");
                this.aaz = jSONObject.optString("is_stickers");
                this.aaA = jSONObject.optString("is_privilegewin");
                this.aaB = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
