package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private boolean Un;
    private int Uo;
    private int Up;
    private int Uq = 25;
    private int Ur = 25;
    private int Us = 10;
    private int time;

    public int getSuccRank() {
        return this.Uq;
    }

    public int getErrRank() {
        return this.Ur;
    }

    public int getSlowRank() {
        return this.Us;
    }

    public boolean ismSwitch() {
        return this.Un;
    }

    public void setmSwitch(boolean z) {
        if (this.Un != z) {
            com.baidu.adp.lib.stats.c fN = com.baidu.tbadk.core.util.u.fN();
            fN.p("act", "fallback");
            fN.p("result", z ? "1" : "0");
            fN.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fN);
        }
        this.Un = z;
    }

    public int getSlowNumber() {
        return this.Uo;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.Up;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Un = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Un = true;
                } else {
                    this.Un = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Up = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Uo = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Uq = optJSONObject3.optInt("succ");
                    this.Ur = optJSONObject3.optInt("err");
                    this.Us = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Uo <= 0 || this.Up <= 0) {
                    this.Un = false;
                }
            } catch (Exception e) {
                this.Un = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
