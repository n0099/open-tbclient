package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n {
    private g aUt = new g();
    private int aUu = 0;
    private String mIcon;

    public g Gh() {
        return this.aUt;
    }

    public int Gi() {
        return this.aUu;
    }

    public String Gj() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aUu = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aUt = new g();
            this.aUt.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aUt.Fk(), com.baidu.live.d.Aq().getString("quick_gift_id", ""))) {
                com.baidu.live.d.Aq().putString("quick_gift_id", this.aUt.Fk());
                com.baidu.live.d.Aq().putBoolean("quick_gift_guide_show", true);
            }
            this.aUt.setSceneFrom(com.baidu.live.utils.p.Ub());
        }
    }
}
