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
    public String biL;
    public String biM;
    public long biN;
    public long biO;
    public long biP;
    public long biQ;
    public String biR;
    public String biS;
    public JSONObject biT;
    public int biU;
    public int biV;
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
                this.biL = jSONObject.optString("regiment_name");
                this.biM = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.biN = jSONObject.optLong(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.biO = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.biP = jSONObject.optLong("member_counts");
                this.guardLevel = jSONObject.optInt("guard_level");
                this.biQ = jSONObject.optLong("next_level_need_score");
                this.biR = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.biS = jSONObject.optString("week_rank");
                this.biT = jSONObject.optJSONObject(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE);
                this.biU = jSONObject.optInt("can_rename_regiment");
                this.biV = jSONObject.optInt("had_show_update_name_help");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
