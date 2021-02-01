package com.baidu.live.data;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ak {
    public String aHy;
    public String aJM;
    public String aJN;
    public int aJO;
    public String anchorPortrait;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJM = jSONObject.optString("anchor_id", "");
            this.aHy = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_NAME, "");
            this.anchorPortrait = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_PORTRAIT, "");
            this.aJN = jSONObject.optString("follow_status", "");
            this.aJO = jSONObject.optInt("align", 0);
        }
    }
}
