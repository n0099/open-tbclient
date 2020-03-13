package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private boolean cOd;
    private int cOe;
    private int cOf;
    private int cOg = 25;
    private int cOh = 25;
    private int cOi = 10;
    private int time;

    public int getSuccRank() {
        return this.cOg;
    }

    public int getErrRank() {
        return this.cOh;
    }

    public int getSlowRank() {
        return this.cOi;
    }

    public boolean ismSwitch() {
        return this.cOd;
    }

    public void setmSwitch(boolean z) {
        if (this.cOd != z) {
            com.baidu.adp.lib.stats.a gs = com.baidu.tbadk.core.util.s.gs();
            gs.append("act", "fallback");
            gs.append("result", z ? "1" : "0");
            gs.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", gs);
        }
        this.cOd = z;
    }

    public int getSlowNumber() {
        return this.cOe;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.cOf;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.cOd = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.cOd = true;
                } else {
                    this.cOd = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.cOf = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.cOe = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.cOg = optJSONObject3.optInt("succ");
                    this.cOh = optJSONObject3.optInt("err");
                    this.cOi = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.cOe <= 0 || this.cOf <= 0) {
                    this.cOd = false;
                }
            } catch (Exception e) {
                this.cOd = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
