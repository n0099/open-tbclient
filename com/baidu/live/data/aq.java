package com.baidu.live.data;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class aq {
    public long aIA;
    public String aIy;
    public String aIz;
    public String mNickName;
    public String mPortrait;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mNickName = jSONObject.optString("nickname");
            this.mPortrait = jSONObject.optString("mvp_user_portrait");
            this.aIy = jSONObject.optString("anchor_nickname");
            this.aIz = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_PORTRAIT);
            this.aIA = jSONObject.optLong("win_score");
        }
    }
}
