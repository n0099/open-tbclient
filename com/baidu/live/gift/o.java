package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    private g aXA = new g();
    private int aXB = 0;
    private String mIcon;

    public g HW() {
        return this.aXA;
    }

    public int HX() {
        return this.aXB;
    }

    public String HY() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aXB = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aXA = new g();
            this.aXA.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aXA.GX(), com.baidu.live.d.BM().getString("quick_gift_id", ""))) {
                com.baidu.live.d.BM().putString("quick_gift_id", this.aXA.GX());
                com.baidu.live.d.BM().putBoolean("quick_gift_guide_show", true);
            }
            this.aXA.setSceneFrom(com.baidu.live.utils.p.WB());
        }
    }
}
