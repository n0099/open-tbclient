package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    private g aAe = new g();
    private int aAf = 0;
    private String mIcon;

    public g wS() {
        return this.aAe;
    }

    public int wT() {
        return this.aAf;
    }

    public String wU() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aAf = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aAe = new g();
            this.aAe.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aAe.vV(), com.baidu.live.c.tH().getString("quick_gift_id", ""))) {
                com.baidu.live.c.tH().putString("quick_gift_id", this.aAe.vV());
                com.baidu.live.c.tH().putBoolean("quick_gift_guide_show", true);
            }
            this.aAe.setSceneFrom(com.baidu.live.utils.q.Gl());
        }
    }
}
