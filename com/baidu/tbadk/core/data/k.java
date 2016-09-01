package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private boolean Qb;
    private int Qc;
    private int Qd;
    private int Qe = 25;
    private int Qf = 25;
    private int Qg = 10;
    private int time;

    public int getSuccRank() {
        return this.Qe;
    }

    public int getErrRank() {
        return this.Qf;
    }

    public int getSlowRank() {
        return this.Qg;
    }

    public boolean ismSwitch() {
        return this.Qb;
    }

    public void setmSwitch(boolean z) {
        if (this.Qb != z) {
            com.baidu.adp.lib.stats.d eB = com.baidu.tbadk.core.util.v.eB();
            eB.q("act", "fallback");
            eB.q("result", z ? "1" : "0");
            eB.q("type", "switch");
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
        }
        this.Qb = z;
    }

    public int getSlowNumber() {
        return this.Qc;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.Qd;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Qb = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Qb = true;
                } else {
                    this.Qb = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Qd = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Qc = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Qe = optJSONObject3.optInt("succ");
                    this.Qf = optJSONObject3.optInt("err");
                    this.Qg = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Qc <= 0 || this.Qd <= 0) {
                    this.Qb = false;
                }
            } catch (Exception e) {
                this.Qb = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
