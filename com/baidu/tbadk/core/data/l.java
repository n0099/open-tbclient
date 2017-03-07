package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private int UB;
    private int UC;
    private int UD = 25;
    private int UE = 25;
    private int UF = 10;
    private boolean Uz;
    private int time;

    public int getSuccRank() {
        return this.UD;
    }

    public int getErrRank() {
        return this.UE;
    }

    public int getSlowRank() {
        return this.UF;
    }

    public boolean ismSwitch() {
        return this.Uz;
    }

    public void setmSwitch(boolean z) {
        if (this.Uz != z) {
            com.baidu.adp.lib.stats.c fH = com.baidu.tbadk.core.util.u.fH();
            fH.p("act", "fallback");
            fH.p("result", z ? "1" : "0");
            fH.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fH);
        }
        this.Uz = z;
    }

    public int getSlowNumber() {
        return this.UB;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.UC;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Uz = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Uz = true;
                } else {
                    this.Uz = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.UC = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.UB = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.UD = optJSONObject3.optInt("succ");
                    this.UE = optJSONObject3.optInt("err");
                    this.UF = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.UB <= 0 || this.UC <= 0) {
                    this.Uz = false;
                }
            } catch (Exception e) {
                this.Uz = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
