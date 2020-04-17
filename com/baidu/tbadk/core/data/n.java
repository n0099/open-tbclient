package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private boolean dnv;
    private int dnw;
    private int dnx;
    private int time;
    private int dny = 25;
    private int dnz = 25;
    private int dnA = 10;

    public int getSuccRank() {
        return this.dny;
    }

    public int getErrRank() {
        return this.dnz;
    }

    public int getSlowRank() {
        return this.dnA;
    }

    public boolean ismSwitch() {
        return this.dnv;
    }

    public void setmSwitch(boolean z) {
        if (this.dnv != z) {
            com.baidu.adp.lib.stats.a kW = com.baidu.tbadk.core.util.s.kW();
            kW.append("act", "fallback");
            kW.append("result", z ? "1" : "0");
            kW.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", kW);
        }
        this.dnv = z;
    }

    public int getSlowNumber() {
        return this.dnw;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.dnx;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.dnv = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.dnv = true;
                } else {
                    this.dnv = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.dnx = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.dnw = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.dny = optJSONObject3.optInt("succ");
                    this.dnz = optJSONObject3.optInt("err");
                    this.dnA = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.dnw <= 0 || this.dnx <= 0) {
                    this.dnv = false;
                }
            } catch (Exception e) {
                this.dnv = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
