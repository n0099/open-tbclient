package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    private g aQF = new g();
    private int aQG = 0;
    private String mIcon;

    public g Fe() {
        return this.aQF;
    }

    public int Ff() {
        return this.aQG;
    }

    public String Fg() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aQG = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aQF = new g();
            this.aQF.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aQF.Eh(), com.baidu.live.c.AR().getString("quick_gift_id", ""))) {
                com.baidu.live.c.AR().putString("quick_gift_id", this.aQF.Eh());
                com.baidu.live.c.AR().putBoolean("quick_gift_guide_show", true);
            }
            this.aQF.setSceneFrom(com.baidu.live.utils.p.PR());
        }
    }
}
