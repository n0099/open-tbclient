package com.baidu.live.guardclub;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public long aCu;
    public String aXH;
    public String aXI;
    public long aXJ;
    public long aXK;
    public long aXL;
    public int aXM;
    public long aXN;
    public String aXO;
    public String aXP;
    public JSONObject aXQ;
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
                        this.aCu = Long.parseLong(EncryptionHelper.getDecryptUserId(optString));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.aXH = jSONObject.optString("regiment_name");
                this.aXI = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.aXJ = jSONObject.optLong(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.aXK = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.aXL = jSONObject.optLong("member_counts");
                this.aXM = jSONObject.optInt("guard_level");
                this.aXN = jSONObject.optLong("next_level_need_score");
                this.aXO = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.aXP = jSONObject.optString("week_rank");
                this.aXQ = jSONObject.optJSONObject(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
