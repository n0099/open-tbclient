package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private g aft = new g();
    private int afu = 0;
    private String mIcon;

    public g rt() {
        return this.aft;
    }

    public int ru() {
        return this.afu;
    }

    public String rv() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.afu = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aft = new g();
            this.aft.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aft.qE(), com.baidu.live.c.oJ().getString("quick_gift_id", ""))) {
                com.baidu.live.c.oJ().putString("quick_gift_id", this.aft.qE());
                com.baidu.live.c.oJ().putBoolean("quick_gift_guide_show", true);
            }
            this.aft.setSceneFrom(com.baidu.live.utils.q.yO());
        }
    }
}
