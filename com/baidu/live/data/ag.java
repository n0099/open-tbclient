package com.baidu.live.data;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ag {
    public String aFc;
    public String aHi;
    public String aHj;
    public String anchorPortrait;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHi = jSONObject.optString("anchor_id", "");
            this.aFc = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_NAME, "");
            this.anchorPortrait = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_PORTRAIT, "");
            this.aHj = jSONObject.optString("follow_status", "");
        }
    }
}
