package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class o {
    private g aXx = new g();
    private int aXy = 0;
    private String mIcon;

    public g ES() {
        return this.aXx;
    }

    public int ET() {
        return this.aXy;
    }

    public String EU() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aXy = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aXx = new g();
            this.aXx.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aXx.DR(), com.baidu.live.d.xc().getString("quick_gift_id", ""))) {
                com.baidu.live.d.xc().putString("quick_gift_id", this.aXx.DR());
                com.baidu.live.d.xc().putBoolean("quick_gift_guide_show", true);
            }
            this.aXx.setSceneFrom(com.baidu.live.utils.q.Vu());
        }
    }
}
