package com.baidu.live.guardclub;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public long aDf;
    public String bag;
    public String bah;
    public long bai;
    public long baj;
    public long bak;
    public int bal;
    public long bam;
    public String ban;
    public String bao;
    public JSONObject bap;
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
                        this.aDf = Long.parseLong(EncryptionHelper.getDecryptUserId(optString));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.bag = jSONObject.optString("regiment_name");
                this.bah = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.bai = jSONObject.optLong(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.baj = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.bak = jSONObject.optLong("member_counts");
                this.bal = jSONObject.optInt("guard_level");
                this.bam = jSONObject.optLong("next_level_need_score");
                this.ban = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.bao = jSONObject.optString("week_rank");
                this.bap = jSONObject.optJSONObject(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
