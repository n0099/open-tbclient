package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n {
    private g aWe = new g();
    private int aWf = 0;
    private String mIcon;

    public g GQ() {
        return this.aWe;
    }

    public int GR() {
        return this.aWf;
    }

    public String GS() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aWf = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aWe = new g();
            this.aWe.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aWe.FT(), com.baidu.live.d.AZ().getString("quick_gift_id", ""))) {
                com.baidu.live.d.AZ().putString("quick_gift_id", this.aWe.FT());
                com.baidu.live.d.AZ().putBoolean("quick_gift_guide_show", true);
            }
            this.aWe.setSceneFrom(com.baidu.live.utils.p.UK());
        }
    }
}
