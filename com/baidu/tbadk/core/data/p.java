package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private boolean dOe;
    private int dOf;
    private int dOg;
    private int dOh = 25;
    private int dOi = 25;
    private int dOj = 10;
    private int time;

    public int getSuccRank() {
        return this.dOh;
    }

    public int getErrRank() {
        return this.dOi;
    }

    public int getSlowRank() {
        return this.dOj;
    }

    public boolean ismSwitch() {
        return this.dOe;
    }

    public void setmSwitch(boolean z) {
        if (this.dOe != z) {
            com.baidu.adp.lib.stats.a lo = com.baidu.tbadk.core.util.u.lo();
            lo.append("act", "fallback");
            lo.append("result", z ? "1" : "0");
            lo.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", lo);
        }
        this.dOe = z;
    }

    public int getSlowNumber() {
        return this.dOf;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.dOg;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.dOe = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.dOe = true;
                } else {
                    this.dOe = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.dOg = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.dOf = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.dOh = optJSONObject3.optInt("succ");
                    this.dOi = optJSONObject3.optInt("err");
                    this.dOj = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.dOf <= 0 || this.dOg <= 0) {
                    this.dOe = false;
                }
            } catch (Exception e) {
                this.dOe = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
