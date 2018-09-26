package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private boolean ahh;
    private int ahi;
    private int ahj;
    private int ahk = 25;
    private int ahl = 25;
    private int ahm = 10;
    private int time;

    public int getSuccRank() {
        return this.ahk;
    }

    public int getErrRank() {
        return this.ahl;
    }

    public int getSlowRank() {
        return this.ahm;
    }

    public boolean ismSwitch() {
        return this.ahh;
    }

    public void setmSwitch(boolean z) {
        if (this.ahh != z) {
            com.baidu.adp.lib.stats.a jo = com.baidu.tbadk.core.util.s.jo();
            jo.append(SocialConstants.PARAM_ACT, "fallback");
            jo.append("result", z ? "1" : "0");
            jo.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
        }
        this.ahh = z;
    }

    public int getSlowNumber() {
        return this.ahi;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.ahj;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.ahh = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.ahh = true;
                } else {
                    this.ahh = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.ahj = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.ahi = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.ahk = optJSONObject3.optInt("succ");
                    this.ahl = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.ahm = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.ahi <= 0 || this.ahj <= 0) {
                    this.ahh = false;
                }
            } catch (Exception e) {
                this.ahh = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
