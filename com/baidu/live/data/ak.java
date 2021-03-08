package com.baidu.live.data;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ak {
    public String aIY;
    public String aLm;
    public String aLn;
    public int aLo;
    public String anchorPortrait;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLm = jSONObject.optString("anchor_id", "");
            this.aIY = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_NAME, "");
            this.anchorPortrait = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_PORTRAIT, "");
            this.aLn = jSONObject.optString("follow_status", "");
            this.aLo = jSONObject.optInt("align", 0);
        }
    }
}
