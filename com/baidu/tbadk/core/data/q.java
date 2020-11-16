package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private boolean eyn;
    private int eyo;
    private int eyp;
    private int eyq = 25;
    private int eyr = 25;
    private int eys = 10;
    private int time;

    public int getSuccRank() {
        return this.eyq;
    }

    public int getErrRank() {
        return this.eyr;
    }

    public int getSlowRank() {
        return this.eys;
    }

    public boolean ismSwitch() {
        return this.eyn;
    }

    public void setmSwitch(boolean z) {
        if (this.eyn != z) {
            com.baidu.adp.lib.stats.a mT = com.baidu.tbadk.core.util.u.mT();
            mT.append("act", "fallback");
            mT.append("result", z ? "1" : "0");
            mT.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", mT);
        }
        this.eyn = z;
    }

    public int getSlowNumber() {
        return this.eyo;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.eyp;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.eyn = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.eyn = true;
                } else {
                    this.eyn = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.eyp = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.eyo = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.eyq = optJSONObject3.optInt("succ");
                    this.eyr = optJSONObject3.optInt("err");
                    this.eys = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.eyo <= 0 || this.eyp <= 0) {
                    this.eyn = false;
                }
            } catch (Exception e) {
                this.eyn = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
