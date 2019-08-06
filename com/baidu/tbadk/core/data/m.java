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
    private boolean bGc;
    private int bGd;
    private int bGe;
    private int bGf = 25;
    private int bGg = 25;
    private int bGh = 10;
    private int time;

    public int getSuccRank() {
        return this.bGf;
    }

    public int getErrRank() {
        return this.bGg;
    }

    public int getSlowRank() {
        return this.bGh;
    }

    public boolean ismSwitch() {
        return this.bGc;
    }

    public void setmSwitch(boolean z) {
        if (this.bGc != z) {
            com.baidu.adp.lib.stats.a iF = com.baidu.tbadk.core.util.s.iF();
            iF.append(SocialConstants.PARAM_ACT, "fallback");
            iF.append("result", z ? "1" : "0");
            iF.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
        }
        this.bGc = z;
    }

    public int getSlowNumber() {
        return this.bGd;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.bGe;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.bGc = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.bGc = true;
                } else {
                    this.bGc = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.bGe = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.bGd = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.bGf = optJSONObject3.optInt("succ");
                    this.bGg = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.bGh = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.bGd <= 0 || this.bGe <= 0) {
                    this.bGc = false;
                }
            } catch (Exception e) {
                this.bGc = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
