package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private boolean dHT;
    private int dHU;
    private int dHV;
    private int dHW = 25;
    private int dHX = 25;
    private int dHY = 10;
    private int time;

    public int getSuccRank() {
        return this.dHW;
    }

    public int getErrRank() {
        return this.dHX;
    }

    public int getSlowRank() {
        return this.dHY;
    }

    public boolean ismSwitch() {
        return this.dHT;
    }

    public void setmSwitch(boolean z) {
        if (this.dHT != z) {
            com.baidu.adp.lib.stats.a lo = com.baidu.tbadk.core.util.t.lo();
            lo.append("act", "fallback");
            lo.append("result", z ? "1" : "0");
            lo.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", lo);
        }
        this.dHT = z;
    }

    public int getSlowNumber() {
        return this.dHU;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.dHV;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.dHT = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.dHT = true;
                } else {
                    this.dHT = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.dHV = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.dHU = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.dHW = optJSONObject3.optInt("succ");
                    this.dHX = optJSONObject3.optInt("err");
                    this.dHY = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.dHU <= 0 || this.dHV <= 0) {
                    this.dHT = false;
                }
            } catch (Exception e) {
                this.dHT = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
