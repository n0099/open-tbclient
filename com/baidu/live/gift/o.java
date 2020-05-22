package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    private g aFC = new g();
    private int aFD = 0;
    private String mIcon;

    public g yi() {
        return this.aFC;
    }

    public int yj() {
        return this.aFD;
    }

    public String yk() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aFD = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aFC = new g();
            this.aFC.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aFC.xl(), com.baidu.live.c.uN().getString("quick_gift_id", ""))) {
                com.baidu.live.c.uN().putString("quick_gift_id", this.aFC.xl());
                com.baidu.live.c.uN().putBoolean("quick_gift_guide_show", true);
            }
            this.aFC.setSceneFrom(com.baidu.live.utils.q.Id());
        }
    }
}
