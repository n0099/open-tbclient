package com.baidu.live.guardclub;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public long anchorId;
    public String bgm;
    public String bgn;
    public long bgo;
    public long bgp;
    public long bgq;
    public int bgr;
    public long bgt;
    public String bgu;
    public String bgv;
    public JSONObject bgw;
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
                        this.anchorId = Long.parseLong(EncryptionHelper.getDecryptUserId(optString));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.bgm = jSONObject.optString("regiment_name");
                this.bgn = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.bgo = jSONObject.optLong(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.bgp = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.bgq = jSONObject.optLong("member_counts");
                this.bgr = jSONObject.optInt("guard_level");
                this.bgt = jSONObject.optLong("next_level_need_score");
                this.bgu = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.bgv = jSONObject.optString("week_rank");
                this.bgw = jSONObject.optJSONObject(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
