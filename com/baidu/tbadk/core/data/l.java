package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private boolean Up;
    private int Uq;
    private int Ur;
    private int Us = 25;
    private int Ut = 25;
    private int Uu = 10;
    private int time;

    public int getSuccRank() {
        return this.Us;
    }

    public int getErrRank() {
        return this.Ut;
    }

    public int getSlowRank() {
        return this.Uu;
    }

    public boolean ismSwitch() {
        return this.Up;
    }

    public void setmSwitch(boolean z) {
        if (this.Up != z) {
            com.baidu.adp.lib.stats.a fK = com.baidu.tbadk.core.util.r.fK();
            fK.p("act", "fallback");
            fK.p("result", z ? "1" : "0");
            fK.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fK);
        }
        this.Up = z;
    }

    public int getSlowNumber() {
        return this.Uq;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.Ur;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Up = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Up = true;
                } else {
                    this.Up = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Ur = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Uq = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Us = optJSONObject3.optInt("succ");
                    this.Ut = optJSONObject3.optInt("err");
                    this.Uu = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Uq <= 0 || this.Ur <= 0) {
                    this.Up = false;
                }
            } catch (Exception e) {
                this.Up = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
