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
    public String biN;
    public String biO;
    public long biP;
    public long biQ;
    public long biR;
    public long biS;
    public String biT;
    public String biU;
    public JSONObject biV;
    public int biW;
    public int biX;
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
                this.biN = jSONObject.optString("regiment_name");
                this.biO = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.biP = jSONObject.optLong(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.biQ = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.biR = jSONObject.optLong("member_counts");
                this.guardLevel = jSONObject.optInt("guard_level");
                this.biS = jSONObject.optLong("next_level_need_score");
                this.biT = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.biU = jSONObject.optString("week_rank");
                this.biV = jSONObject.optJSONObject(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE);
                this.biW = jSONObject.optInt("can_rename_regiment");
                this.biX = jSONObject.optInt("had_show_update_name_help");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
