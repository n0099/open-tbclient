package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    private g ahA = new g();
    private int ahB = 0;
    private String mIcon;

    public g su() {
        return this.ahA;
    }

    public int sv() {
        return this.ahB;
    }

    public String sw() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ahB = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.ahA = new g();
            this.ahA.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.ahA.rx(), com.baidu.live.c.pr().getString("quick_gift_id", ""))) {
                com.baidu.live.c.pr().putString("quick_gift_id", this.ahA.rx());
                com.baidu.live.c.pr().putBoolean("quick_gift_guide_show", true);
            }
            this.ahA.setSceneFrom(com.baidu.live.utils.q.Bg());
        }
    }
}
