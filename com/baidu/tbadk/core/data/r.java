package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private boolean eMD;
    private int eME;
    private int eMF;
    private int eMG = 25;
    private int eMH = 25;
    private int eMI = 10;
    private int time;

    public int getSuccRank() {
        return this.eMG;
    }

    public int getErrRank() {
        return this.eMH;
    }

    public int getSlowRank() {
        return this.eMI;
    }

    public boolean ismSwitch() {
        return this.eMD;
    }

    public void setmSwitch(boolean z) {
        if (this.eMD != z) {
            com.baidu.adp.lib.stats.a pg = com.baidu.tbadk.core.util.u.pg();
            pg.append("act", "fallback");
            pg.append("result", z ? "1" : "0");
            pg.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", pg);
        }
        this.eMD = z;
    }

    public int getSlowNumber() {
        return this.eME;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.eMF;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.eMD = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.eMD = true;
                } else {
                    this.eMD = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.eMF = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.eME = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.eMG = optJSONObject3.optInt("succ");
                    this.eMH = optJSONObject3.optInt("err");
                    this.eMI = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.eME <= 0 || this.eMF <= 0) {
                    this.eMD = false;
                }
            } catch (Exception e) {
                this.eMD = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
