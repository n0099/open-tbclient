package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    private g aAk = new g();
    private int aAl = 0;
    private String mIcon;

    public g wR() {
        return this.aAk;
    }

    public int wS() {
        return this.aAl;
    }

    public String wT() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aAl = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aAk = new g();
            this.aAk.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aAk.vU(), com.baidu.live.c.tG().getString("quick_gift_id", ""))) {
                com.baidu.live.c.tG().putString("quick_gift_id", this.aAk.vU());
                com.baidu.live.c.tG().putBoolean("quick_gift_guide_show", true);
            }
            this.aAk.setSceneFrom(com.baidu.live.utils.q.Gk());
        }
    }
}
