package com.baidu.live.guardclub;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public long anchorId;
    public JSONObject bkA;
    public int bkB;
    public int bkC;
    public String bks;
    public String bkt;
    public long bku;
    public long bkv;
    public long bkw;
    public long bkx;
    public String bky;
    public String bkz;
    public long createTime;
    public String description;
    public int guardLevel;
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
                this.bks = jSONObject.optString("regiment_name");
                this.bkt = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.bku = jSONObject.optLong(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.bkv = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.bkw = jSONObject.optLong("member_counts");
                this.guardLevel = jSONObject.optInt("guard_level");
                this.bkx = jSONObject.optLong("next_level_need_score");
                this.bky = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.bkz = jSONObject.optString("week_rank");
                this.bkA = jSONObject.optJSONObject(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE);
                this.bkB = jSONObject.optInt("can_rename_regiment");
                this.bkC = jSONObject.optInt("had_show_update_name_help");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
