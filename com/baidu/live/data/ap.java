package com.baidu.live.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ap {
    private String avi;
    private String avj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(String str) {
        parserJson(str);
    }

    public boolean vc() {
        return "1".equals(this.avi) && !TextUtils.isEmpty(this.avj);
    }

    public String vd() {
        return this.avj;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.avi = jSONObject.optString("is_open");
                this.avj = jSONObject.optString("homepage_url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
