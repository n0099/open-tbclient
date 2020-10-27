package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bj {
    private String aOo;
    private String aOp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(String str) {
        parserJson(str);
    }

    public boolean Eq() {
        return "1".equals(this.aOo) && !TextUtils.isEmpty(this.aOp);
    }

    public String Er() {
        return this.aOp;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aOo = jSONObject.optString("is_open");
                this.aOp = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
