package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private boolean aqT;
    private int aqU;
    private int aqV;
    private int aqW = 25;
    private int aqX = 25;
    private int aqY = 10;
    private int time;

    public int getSuccRank() {
        return this.aqW;
    }

    public int getErrRank() {
        return this.aqX;
    }

    public int getSlowRank() {
        return this.aqY;
    }

    public boolean ismSwitch() {
        return this.aqT;
    }

    public void setmSwitch(boolean z) {
        if (this.aqT != z) {
            com.baidu.adp.lib.stats.a jB = com.baidu.tbadk.core.util.s.jB();
            jB.append(SocialConstants.PARAM_ACT, "fallback");
            jB.append("result", z ? "1" : "0");
            jB.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
        }
        this.aqT = z;
    }

    public int getSlowNumber() {
        return this.aqU;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.aqV;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aqT = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aqT = true;
                } else {
                    this.aqT = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aqV = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.aqU = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.aqW = optJSONObject3.optInt("succ");
                    this.aqX = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.aqY = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aqU <= 0 || this.aqV <= 0) {
                    this.aqT = false;
                }
            } catch (Exception e) {
                this.aqT = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
