package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private boolean cJN;
    private int cJO;
    private int cJP;
    private int cJQ = 25;
    private int cJR = 25;
    private int cJS = 10;
    private int time;

    public int getSuccRank() {
        return this.cJQ;
    }

    public int getErrRank() {
        return this.cJR;
    }

    public int getSlowRank() {
        return this.cJS;
    }

    public boolean ismSwitch() {
        return this.cJN;
    }

    public void setmSwitch(boolean z) {
        if (this.cJN != z) {
            com.baidu.adp.lib.stats.a gt = com.baidu.tbadk.core.util.s.gt();
            gt.append("act", "fallback");
            gt.append("result", z ? "1" : "0");
            gt.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", gt);
        }
        this.cJN = z;
    }

    public int getSlowNumber() {
        return this.cJO;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.cJP;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.cJN = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.cJN = true;
                } else {
                    this.cJN = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.cJP = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.cJO = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.cJQ = optJSONObject3.optInt("succ");
                    this.cJR = optJSONObject3.optInt("err");
                    this.cJS = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.cJO <= 0 || this.cJP <= 0) {
                    this.cJN = false;
                }
            } catch (Exception e) {
                this.cJN = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
