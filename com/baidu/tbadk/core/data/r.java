package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private boolean eOe;
    private int eOf;
    private int eOg;
    private int eOh = 25;
    private int eOi = 25;
    private int eOj = 10;
    private int time;

    public int getSuccRank() {
        return this.eOh;
    }

    public int getErrRank() {
        return this.eOi;
    }

    public int getSlowRank() {
        return this.eOj;
    }

    public boolean ismSwitch() {
        return this.eOe;
    }

    public void setmSwitch(boolean z) {
        if (this.eOe != z) {
            com.baidu.adp.lib.stats.a pg = com.baidu.tbadk.core.util.u.pg();
            pg.append("act", "fallback");
            pg.append("result", z ? "1" : "0");
            pg.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", pg);
        }
        this.eOe = z;
    }

    public int getSlowNumber() {
        return this.eOf;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.eOg;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.eOe = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.eOe = true;
                } else {
                    this.eOe = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.eOg = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.eOf = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.eOh = optJSONObject3.optInt("succ");
                    this.eOi = optJSONObject3.optInt("err");
                    this.eOj = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.eOf <= 0 || this.eOg <= 0) {
                    this.eOe = false;
                }
            } catch (Exception e) {
                this.eOe = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
