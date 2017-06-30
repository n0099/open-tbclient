package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private boolean TZ;
    private int Ua;
    private int Ub;
    private int Uc = 25;
    private int Ud = 25;
    private int Ue = 10;
    private int time;

    public int getSuccRank() {
        return this.Uc;
    }

    public int getErrRank() {
        return this.Ud;
    }

    public int getSlowRank() {
        return this.Ue;
    }

    public boolean ismSwitch() {
        return this.TZ;
    }

    public void setmSwitch(boolean z) {
        if (this.TZ != z) {
            com.baidu.adp.lib.stats.c fM = com.baidu.tbadk.core.util.w.fM();
            fM.p("act", "fallback");
            fM.p("result", z ? "1" : "0");
            fM.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fM);
        }
        this.TZ = z;
    }

    public int getSlowNumber() {
        return this.Ua;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.Ub;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.TZ = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.TZ = true;
                } else {
                    this.TZ = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Ub = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Ua = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Uc = optJSONObject3.optInt("succ");
                    this.Ud = optJSONObject3.optInt("err");
                    this.Ue = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Ua <= 0 || this.Ub <= 0) {
                    this.TZ = false;
                }
            } catch (Exception e) {
                this.TZ = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
