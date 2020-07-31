package com.baidu.live.guardclub;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aSA;
    public String aSB;
    public JSONObject aSC;
    public String aSt;
    public String aSu;
    public long aSv;
    public long aSw;
    public long aSx;
    public int aSy;
    public long aSz;
    public long axs;
    public long createTime;
    public String description;
    public int id;
    public long liveId;
    public int liveStatus;
    public String rank;
    public int status;
    public long updateTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optInt("id");
                try {
                    String optString = jSONObject.optString("anchor_id");
                    if (!TextUtils.isEmpty(optString)) {
                        this.axs = Long.parseLong(EncryptionHelper.getDecryptUserId(optString));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.aSt = jSONObject.optString("regiment_name");
                this.aSu = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.aSv = jSONObject.optLong(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.aSw = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.aSx = jSONObject.optLong("member_counts");
                this.aSy = jSONObject.optInt("guard_level");
                this.aSz = jSONObject.optLong("next_level_need_score");
                this.aSA = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.aSB = jSONObject.optString("week_rank");
                this.aSC = jSONObject.optJSONObject(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
