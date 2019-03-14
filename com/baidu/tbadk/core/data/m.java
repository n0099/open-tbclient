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
    private boolean bxK;
    private int bxL;
    private int bxM;
    private int bxN = 25;
    private int bxO = 25;
    private int bxP = 10;
    private int time;

    public int getSuccRank() {
        return this.bxN;
    }

    public int getErrRank() {
        return this.bxO;
    }

    public int getSlowRank() {
        return this.bxP;
    }

    public boolean ismSwitch() {
        return this.bxK;
    }

    public void setmSwitch(boolean z) {
        if (this.bxK != z) {
            com.baidu.adp.lib.stats.a jC = com.baidu.tbadk.core.util.s.jC();
            jC.append(SocialConstants.PARAM_ACT, "fallback");
            jC.append("result", z ? "1" : "0");
            jC.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
        }
        this.bxK = z;
    }

    public int getSlowNumber() {
        return this.bxL;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.bxM;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.bxK = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.bxK = true;
                } else {
                    this.bxK = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.bxM = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.bxL = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.bxN = optJSONObject3.optInt("succ");
                    this.bxO = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.bxP = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.bxL <= 0 || this.bxM <= 0) {
                    this.bxK = false;
                }
            } catch (Exception e) {
                this.bxK = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
