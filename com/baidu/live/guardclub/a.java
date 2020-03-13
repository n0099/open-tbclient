package com.baidu.live.guardclub;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public long WZ;
    public String apM;
    public String apN;
    public long apO;
    public long apP;
    public long apQ;
    public int apR;
    public long apS;
    public String apT;
    public String apU;
    public JSONObject apV;
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
                        this.WZ = Long.parseLong(EncryptionHelper.getDecryptUserId(optString));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.apM = jSONObject.optString("regiment_name");
                this.apN = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.apO = jSONObject.optLong("score");
                this.apP = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.apQ = jSONObject.optLong("member_counts");
                this.apR = jSONObject.optInt("guard_level");
                this.apS = jSONObject.optLong("next_level_need_score");
                this.apT = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.apU = jSONObject.optString("week_rank");
                this.apV = jSONObject.optJSONObject(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
