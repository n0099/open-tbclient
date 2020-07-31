package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    private g aJt = new g();
    private int aJu = 0;
    private String mIcon;

    public g zk() {
        return this.aJt;
    }

    public int zl() {
        return this.aJu;
    }

    public String zm() {
        return this.mIcon;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aJu = optJSONObject.optInt("switch");
            this.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aJt = new g();
            this.aJt.parseJson(optJSONObject.optJSONObject("gift_info"));
            if (!TextUtils.equals(this.aJt.yo(), com.baidu.live.c.vf().getString("quick_gift_id", ""))) {
                com.baidu.live.c.vf().putString("quick_gift_id", this.aJt.yo());
                com.baidu.live.c.vf().putBoolean("quick_gift_guide_show", true);
            }
            this.aJt.setSceneFrom(com.baidu.live.utils.p.Jx());
        }
    }
}
