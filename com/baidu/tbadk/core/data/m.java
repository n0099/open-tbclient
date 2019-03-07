package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private boolean bxI;
    private int bxJ;
    private int bxK;
    private int bxL = 25;
    private int bxM = 25;
    private int bxN = 10;
    private int time;

    public int getSuccRank() {
        return this.bxL;
    }

    public int getErrRank() {
        return this.bxM;
    }

    public int getSlowRank() {
        return this.bxN;
    }

    public boolean ismSwitch() {
        return this.bxI;
    }

    public void setmSwitch(boolean z) {
        if (this.bxI != z) {
            com.baidu.adp.lib.stats.a jC = com.baidu.tbadk.core.util.s.jC();
            jC.append(SocialConstants.PARAM_ACT, "fallback");
            jC.append("result", z ? "1" : "0");
            jC.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
        }
        this.bxI = z;
    }

    public int getSlowNumber() {
        return this.bxJ;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.bxK;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.bxI = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.bxI = true;
                } else {
                    this.bxI = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.bxK = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.bxJ = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.bxL = optJSONObject3.optInt("succ");
                    this.bxM = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.bxN = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.bxJ <= 0 || this.bxK <= 0) {
                    this.bxI = false;
                }
            } catch (Exception e) {
                this.bxI = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
