package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private boolean amQ;
    private int amR;
    private int amS;
    private int amT = 25;
    private int amU = 25;
    private int amV = 10;
    private int time;

    public int getSuccRank() {
        return this.amT;
    }

    public int getErrRank() {
        return this.amU;
    }

    public int getSlowRank() {
        return this.amV;
    }

    public boolean ismSwitch() {
        return this.amQ;
    }

    public void setmSwitch(boolean z) {
        if (this.amQ != z) {
            com.baidu.adp.lib.stats.a jB = com.baidu.tbadk.core.util.s.jB();
            jB.append(SocialConstants.PARAM_ACT, "fallback");
            jB.append("result", z ? "1" : "0");
            jB.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
        }
        this.amQ = z;
    }

    public int getSlowNumber() {
        return this.amR;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.amS;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.amQ = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.amQ = true;
                } else {
                    this.amQ = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.amS = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.amR = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.amT = optJSONObject3.optInt("succ");
                    this.amU = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.amV = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.amR <= 0 || this.amS <= 0) {
                    this.amQ = false;
                }
            } catch (Exception e) {
                this.amQ = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
