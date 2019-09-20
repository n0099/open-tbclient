package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private boolean bGA;
    private int bGB;
    private int bGC;
    private int bGD = 25;
    private int bGE = 25;
    private int bGF = 10;
    private int time;

    public int getSuccRank() {
        return this.bGD;
    }

    public int getErrRank() {
        return this.bGE;
    }

    public int getSlowRank() {
        return this.bGF;
    }

    public boolean ismSwitch() {
        return this.bGA;
    }

    public void setmSwitch(boolean z) {
        if (this.bGA != z) {
            com.baidu.adp.lib.stats.a iF = com.baidu.tbadk.core.util.s.iF();
            iF.append(SocialConstants.PARAM_ACT, "fallback");
            iF.append("result", z ? "1" : "0");
            iF.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
        }
        this.bGA = z;
    }

    public int getSlowNumber() {
        return this.bGB;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.bGC;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.bGA = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.bGA = true;
                } else {
                    this.bGA = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.bGC = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.bGB = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.bGD = optJSONObject3.optInt("succ");
                    this.bGE = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.bGF = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.bGB <= 0 || this.bGC <= 0) {
                    this.bGA = false;
                }
            } catch (Exception e) {
                this.bGA = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
