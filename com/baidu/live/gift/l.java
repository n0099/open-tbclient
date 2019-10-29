package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l {
    private g Xs = new g();
    private int Xt = 0;
    private String mIcon;

    public g pF() {
        return this.Xs;
    }

    public int pG() {
        return this.Xt;
    }

    public String pH() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.Xt = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.Xs = new g();
            this.Xs.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.Xs.pc(), com.baidu.live.c.np().getString("quick_gift_id", ""))) {
                com.baidu.live.c.np().putString("quick_gift_id", this.Xs.pc());
                com.baidu.live.c.np().putBoolean("quick_gift_guide_show", true);
            }
            this.Xs.setSceneFrom(com.baidu.live.utils.o.wu());
        }
    }
}
