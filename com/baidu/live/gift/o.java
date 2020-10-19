package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    private g aTQ = new g();
    private int aTR = 0;
    private String mIcon;

    public g Ga() {
        return this.aTQ;
    }

    public int Gb() {
        return this.aTR;
    }

    public String Gc() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aTR = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aTQ = new g();
            this.aTQ.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aTQ.Fd(), com.baidu.live.c.AZ().getString("quick_gift_id", ""))) {
                com.baidu.live.c.AZ().putString("quick_gift_id", this.aTQ.Fd());
                com.baidu.live.c.AZ().putBoolean("quick_gift_guide_show", true);
            }
            this.aTQ.setSceneFrom(com.baidu.live.utils.p.QW());
        }
    }
}
