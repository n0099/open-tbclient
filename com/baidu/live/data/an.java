package com.baidu.live.data;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class an {
    public String aBT;
    public String aBU;
    public long aBV;
    public String mNickName;
    public String mPortrait;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mNickName = jSONObject.optString("nickname");
            this.mPortrait = jSONObject.optString("mvp_user_portrait");
            this.aBT = jSONObject.optString("anchor_nickname");
            this.aBU = jSONObject.optString(GuardClubInfoActivityConfig.ANCHOR_PORTRAIT);
            this.aBV = jSONObject.optLong("win_score");
        }
    }
}
