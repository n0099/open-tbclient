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
    private boolean bEZ;
    private int bFa;
    private int bFb;
    private int bFc = 25;
    private int bFd = 25;
    private int bFe = 10;
    private int time;

    public int getSuccRank() {
        return this.bFc;
    }

    public int getErrRank() {
        return this.bFd;
    }

    public int getSlowRank() {
        return this.bFe;
    }

    public boolean ismSwitch() {
        return this.bEZ;
    }

    public void setmSwitch(boolean z) {
        if (this.bEZ != z) {
            com.baidu.adp.lib.stats.a iw = com.baidu.tbadk.core.util.s.iw();
            iw.append(SocialConstants.PARAM_ACT, "fallback");
            iw.append("result", z ? "1" : "0");
            iw.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
        }
        this.bEZ = z;
    }

    public int getSlowNumber() {
        return this.bFa;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.bFb;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.bEZ = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.bEZ = true;
                } else {
                    this.bEZ = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.bFb = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.bFa = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.bFc = optJSONObject3.optInt("succ");
                    this.bFd = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.bFe = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.bFa <= 0 || this.bFb <= 0) {
                    this.bEZ = false;
                }
            } catch (Exception e) {
                this.bEZ = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
