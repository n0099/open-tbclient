package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private boolean aeG;
    private int aeH;
    private int aeI;
    private int aeJ = 25;
    private int aeK = 25;
    private int aeL = 10;
    private int time;

    public int getSuccRank() {
        return this.aeJ;
    }

    public int getErrRank() {
        return this.aeK;
    }

    public int getSlowRank() {
        return this.aeL;
    }

    public boolean ismSwitch() {
        return this.aeG;
    }

    public void setmSwitch(boolean z) {
        if (this.aeG != z) {
            com.baidu.adp.lib.stats.a ii = com.baidu.tbadk.core.util.t.ii();
            ii.append(SocialConstants.PARAM_ACT, "fallback");
            ii.append("result", z ? "1" : "0");
            ii.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
        }
        this.aeG = z;
    }

    public int getSlowNumber() {
        return this.aeH;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.aeI;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aeG = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aeG = true;
                } else {
                    this.aeG = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aeI = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.aeH = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.aeJ = optJSONObject3.optInt("succ");
                    this.aeK = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.aeL = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aeH <= 0 || this.aeI <= 0) {
                    this.aeG = false;
                }
            } catch (Exception e) {
                this.aeG = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
