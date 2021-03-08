package com.baidu.live.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLivePhoneMarkData implements Serializable {
    public String icon;
    public String text;
    public int type;

    public void parseJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type", 0);
        this.text = jSONObject.optString("text", "");
        this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
    }
}
