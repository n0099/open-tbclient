package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private boolean dZB;
    private int dZC;
    private int dZD;
    private int dZE = 25;
    private int dZF = 25;
    private int dZG = 10;
    private int time;

    public int getSuccRank() {
        return this.dZE;
    }

    public int getErrRank() {
        return this.dZF;
    }

    public int getSlowRank() {
        return this.dZG;
    }

    public boolean ismSwitch() {
        return this.dZB;
    }

    public void setmSwitch(boolean z) {
        if (this.dZB != z) {
            com.baidu.adp.lib.stats.a mS = com.baidu.tbadk.core.util.u.mS();
            mS.append("act", "fallback");
            mS.append("result", z ? "1" : "0");
            mS.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", mS);
        }
        this.dZB = z;
    }

    public int getSlowNumber() {
        return this.dZC;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.dZD;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.dZB = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.dZB = true;
                } else {
                    this.dZB = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.dZD = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.dZC = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.dZE = optJSONObject3.optInt("succ");
                    this.dZF = optJSONObject3.optInt("err");
                    this.dZG = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.dZC <= 0 || this.dZD <= 0) {
                    this.dZB = false;
                }
            } catch (Exception e) {
                this.dZB = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
