package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private g aeK = new g();
    private int aeL = 0;
    private String mIcon;

    public g rh() {
        return this.aeK;
    }

    public int ri() {
        return this.aeL;
    }

    public String rj() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aeL = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aeK = new g();
            this.aeK.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aeK.qx(), com.baidu.live.c.oI().getString("quick_gift_id", ""))) {
                com.baidu.live.c.oI().putString("quick_gift_id", this.aeK.qx());
                com.baidu.live.c.oI().putBoolean("quick_gift_guide_show", true);
            }
            this.aeK.setSceneFrom(com.baidu.live.utils.p.yv());
        }
    }
}
