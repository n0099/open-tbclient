package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class o {
    private g aZf = new g();
    private int aZg = 0;
    private String mIcon;

    public g Hx() {
        return this.aZf;
    }

    public int Hy() {
        return this.aZg;
    }

    public String Hz() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aZg = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aZf = new g();
            this.aZf.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aZf.Gx(), com.baidu.live.d.Ba().getString("quick_gift_id", ""))) {
                com.baidu.live.d.Ba().putString("quick_gift_id", this.aZf.Gx());
                com.baidu.live.d.Ba().putBoolean("quick_gift_guide_show", true);
            }
            this.aZf.setSceneFrom(com.baidu.live.utils.q.XF());
        }
    }
}
