package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    private g ahK = new g();
    private int ahL = 0;
    private String mIcon;

    public g sz() {
        return this.ahK;
    }

    public int sA() {
        return this.ahL;
    }

    public String sB() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ahL = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.ahK = new g();
            this.ahK.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.ahK.rC(), com.baidu.live.c.pw().getString("quick_gift_id", ""))) {
                com.baidu.live.c.pw().putString("quick_gift_id", this.ahK.rC());
                com.baidu.live.c.pw().putBoolean("quick_gift_guide_show", true);
            }
            this.ahK.setSceneFrom(com.baidu.live.utils.q.Bn());
        }
    }
}
