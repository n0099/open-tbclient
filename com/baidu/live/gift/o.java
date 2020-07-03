package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    private g aHY = new g();
    private int aHZ = 0;
    private String mIcon;

    public g yI() {
        return this.aHY;
    }

    public int yJ() {
        return this.aHZ;
    }

    public String yK() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aHZ = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aHY = new g();
            this.aHY.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aHY.xM(), com.baidu.live.c.vf().getString("quick_gift_id", ""))) {
                com.baidu.live.c.vf().putString("quick_gift_id", this.aHY.xM());
                com.baidu.live.c.vf().putBoolean("quick_gift_guide_show", true);
            }
            this.aHY.setSceneFrom(com.baidu.live.utils.p.Jq());
        }
    }
}
