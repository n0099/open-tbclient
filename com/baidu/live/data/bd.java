package com.baidu.live.data;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bd {
    public String aLT;
    public String aLU;
    public long aLV;
    public String mNickName;
    public String mPortrait;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mNickName = jSONObject.optString("nickname");
            this.mPortrait = jSONObject.optString("mvp_user_portrait");
            this.aLT = jSONObject.optString("anchor_nickname");
            this.aLU = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_PORTRAIT);
            this.aLV = jSONObject.optLong("win_score");
        }
    }
}
