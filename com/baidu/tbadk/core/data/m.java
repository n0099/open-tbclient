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
    private boolean bxO;
    private int bxP;
    private int bxQ;
    private int bxR = 25;
    private int bxS = 25;
    private int bxT = 10;
    private int time;

    public int getSuccRank() {
        return this.bxR;
    }

    public int getErrRank() {
        return this.bxS;
    }

    public int getSlowRank() {
        return this.bxT;
    }

    public boolean ismSwitch() {
        return this.bxO;
    }

    public void setmSwitch(boolean z) {
        if (this.bxO != z) {
            com.baidu.adp.lib.stats.a jC = com.baidu.tbadk.core.util.s.jC();
            jC.append(SocialConstants.PARAM_ACT, "fallback");
            jC.append("result", z ? "1" : "0");
            jC.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
        }
        this.bxO = z;
    }

    public int getSlowNumber() {
        return this.bxP;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.bxQ;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.bxO = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.bxO = true;
                } else {
                    this.bxO = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.bxQ = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.bxP = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.bxR = optJSONObject3.optInt("succ");
                    this.bxS = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.bxT = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.bxP <= 0 || this.bxQ <= 0) {
                    this.bxO = false;
                }
            } catch (Exception e) {
                this.bxO = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
