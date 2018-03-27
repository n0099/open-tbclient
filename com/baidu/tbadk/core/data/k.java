package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private boolean aLA;
    private int aLB;
    private int aLC;
    private int aLD = 25;
    private int aLE = 25;
    private int aLF = 10;
    private int time;

    public int getSuccRank() {
        return this.aLD;
    }

    public int getErrRank() {
        return this.aLE;
    }

    public int getSlowRank() {
        return this.aLF;
    }

    public boolean ismSwitch() {
        return this.aLA;
    }

    public void setmSwitch(boolean z) {
        if (this.aLA != z) {
            com.baidu.adp.lib.stats.a nn = com.baidu.tbadk.core.util.s.nn();
            nn.append(SocialConstants.PARAM_ACT, "fallback");
            nn.append("result", z ? "1" : "0");
            nn.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", nn);
        }
        this.aLA = z;
    }

    public int getSlowNumber() {
        return this.aLB;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.aLC;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aLA = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aLA = true;
                } else {
                    this.aLA = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aLC = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.aLB = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.aLD = optJSONObject3.optInt("succ");
                    this.aLE = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.aLF = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aLB <= 0 || this.aLC <= 0) {
                    this.aLA = false;
                }
            } catch (Exception e) {
                this.aLA = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
