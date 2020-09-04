package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o {
    private g aOG = new g();
    private int aOH = 0;
    private String mIcon;

    public g EN() {
        return this.aOG;
    }

    public int EO() {
        return this.aOH;
    }

    public String EP() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aOH = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aOG = new g();
            this.aOG.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aOG.DR(), com.baidu.live.c.AD().getString("quick_gift_id", ""))) {
                com.baidu.live.c.AD().putString("quick_gift_id", this.aOG.DR());
                com.baidu.live.c.AD().putBoolean("quick_gift_guide_show", true);
            }
            this.aOG.setSceneFrom(com.baidu.live.utils.p.Pp());
        }
    }
}
