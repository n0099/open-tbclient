package com.baidu.live.data;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ba {
    public String aOD;
    public String aOE;
    public long aOF;
    public String mNickName;
    public String mPortrait;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mNickName = jSONObject.optString("nickname");
            this.mPortrait = jSONObject.optString("mvp_user_portrait");
            this.aOD = jSONObject.optString("anchor_nickname");
            this.aOE = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_PORTRAIT);
            this.aOF = jSONObject.optLong("win_score");
        }
    }
}
