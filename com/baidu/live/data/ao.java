package com.baidu.live.data;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ao {
    public String aDo;
    public String aDp;
    public long aDq;
    public String mNickName;
    public String mPortrait;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mNickName = jSONObject.optString("nickname");
            this.mPortrait = jSONObject.optString("mvp_user_portrait");
            this.aDo = jSONObject.optString("anchor_nickname");
            this.aDp = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_PORTRAIT);
            this.aDq = jSONObject.optLong("win_score");
        }
    }
}
