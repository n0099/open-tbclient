package com.baidu.live.data;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ag {
    public String aJP;
    public String aLV;
    public String aLW;
    public String anchorPortrait;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLV = jSONObject.optString("anchor_id", "");
            this.aJP = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_NAME, "");
            this.anchorPortrait = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_PORTRAIT, "");
            this.aLW = jSONObject.optString("follow_status", "");
        }
    }
}
