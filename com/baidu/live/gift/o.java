package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class o {
    private g aUs = new g();
    private int aUt = 0;
    private String mIcon;

    public g DC() {
        return this.aUs;
    }

    public int DD() {
        return this.aUt;
    }

    public String DE() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aUt = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aUs = new g();
            this.aUs.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aUs.CC(), com.baidu.live.d.xf().getString("quick_gift_id", ""))) {
                com.baidu.live.d.xf().putString("quick_gift_id", this.aUs.CC());
                com.baidu.live.d.xf().putBoolean("quick_gift_guide_show", true);
            }
            this.aUs.setSceneFrom(com.baidu.live.utils.q.TN());
        }
    }
}
