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
    private boolean aLK;
    private int aLL;
    private int aLM;
    private int aLN = 25;
    private int aLO = 25;
    private int aLP = 10;
    private int time;

    public int getSuccRank() {
        return this.aLN;
    }

    public int getErrRank() {
        return this.aLO;
    }

    public int getSlowRank() {
        return this.aLP;
    }

    public boolean ismSwitch() {
        return this.aLK;
    }

    public void setmSwitch(boolean z) {
        if (this.aLK != z) {
            com.baidu.adp.lib.stats.a nn = com.baidu.tbadk.core.util.s.nn();
            nn.append(SocialConstants.PARAM_ACT, "fallback");
            nn.append("result", z ? "1" : "0");
            nn.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", nn);
        }
        this.aLK = z;
    }

    public int getSlowNumber() {
        return this.aLL;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.aLM;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aLK = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aLK = true;
                } else {
                    this.aLK = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aLM = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.aLL = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.aLN = optJSONObject3.optInt("succ");
                    this.aLO = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.aLP = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aLL <= 0 || this.aLM <= 0) {
                    this.aLK = false;
                }
            } catch (Exception e) {
                this.aLK = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
