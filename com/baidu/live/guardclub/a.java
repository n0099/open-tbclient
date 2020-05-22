package com.baidu.live.guardclub;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public long aOA;
    public String aOB;
    public String aOC;
    public JSONObject aOD;
    public String aOu;
    public String aOv;
    public long aOw;
    public long aOx;
    public long aOy;
    public int aOz;
    public long aul;
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
                        this.aul = Long.parseLong(EncryptionHelper.getDecryptUserId(optString));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.aOu = jSONObject.optString("regiment_name");
                this.aOv = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.aOw = jSONObject.optLong(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.aOx = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.aOy = jSONObject.optLong("member_counts");
                this.aOz = jSONObject.optInt("guard_level");
                this.aOA = jSONObject.optLong("next_level_need_score");
                this.aOB = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.aOC = jSONObject.optString("week_rank");
                this.aOD = jSONObject.optJSONObject(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
