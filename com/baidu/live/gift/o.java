package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class o {
    private g aYX = new g();
    private int aYY = 0;
    private String mIcon;

    public g EV() {
        return this.aYX;
    }

    public int EW() {
        return this.aYY;
    }

    public String EX() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aYY = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aYX = new g();
            this.aYX.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aYX.DU(), com.baidu.live.d.xf().getString("quick_gift_id", ""))) {
                com.baidu.live.d.xf().putString("quick_gift_id", this.aYX.DU());
                com.baidu.live.d.xf().putBoolean("quick_gift_guide_show", true);
            }
            this.aYX.setSceneFrom(com.baidu.live.utils.q.Vx());
        }
    }
}
