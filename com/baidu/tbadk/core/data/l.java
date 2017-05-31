package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private boolean Ua;
    private int Ub;
    private int Uc;
    private int Ud = 25;
    private int Ue = 25;
    private int Uf = 10;
    private int time;

    public int getSuccRank() {
        return this.Ud;
    }

    public int getErrRank() {
        return this.Ue;
    }

    public int getSlowRank() {
        return this.Uf;
    }

    public boolean ismSwitch() {
        return this.Ua;
    }

    public void setmSwitch(boolean z) {
        if (this.Ua != z) {
            com.baidu.adp.lib.stats.c fN = com.baidu.tbadk.core.util.u.fN();
            fN.p("act", "fallback");
            fN.p("result", z ? "1" : "0");
            fN.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fN);
        }
        this.Ua = z;
    }

    public int getSlowNumber() {
        return this.Ub;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.Uc;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Ua = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Ua = true;
                } else {
                    this.Ua = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Uc = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Ub = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Ud = optJSONObject3.optInt("succ");
                    this.Ue = optJSONObject3.optInt("err");
                    this.Uf = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Ub <= 0 || this.Uc <= 0) {
                    this.Ua = false;
                }
            } catch (Exception e) {
                this.Ua = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
