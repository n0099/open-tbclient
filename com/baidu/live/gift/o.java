package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    private g aUM = new g();
    private int aUN = 0;
    private String mIcon;

    public g Gp() {
        return this.aUM;
    }

    public int Gq() {
        return this.aUN;
    }

    public String Gr() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aUN = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aUM = new g();
            this.aUM.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aUM.Fs(), com.baidu.live.d.AZ().getString("quick_gift_id", ""))) {
                com.baidu.live.d.AZ().putString("quick_gift_id", this.aUM.Fs());
                com.baidu.live.d.AZ().putBoolean("quick_gift_guide_show", true);
            }
            this.aUM.setSceneFrom(com.baidu.live.utils.p.Sc());
        }
    }
}
