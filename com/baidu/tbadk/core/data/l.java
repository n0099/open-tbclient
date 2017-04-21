package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private boolean UW;
    private int UX;
    private int UY;
    private int UZ = 25;
    private int Va = 25;
    private int Vb = 10;
    private int time;

    public int getSuccRank() {
        return this.UZ;
    }

    public int getErrRank() {
        return this.Va;
    }

    public int getSlowRank() {
        return this.Vb;
    }

    public boolean ismSwitch() {
        return this.UW;
    }

    public void setmSwitch(boolean z) {
        if (this.UW != z) {
            com.baidu.adp.lib.stats.c fN = com.baidu.tbadk.core.util.u.fN();
            fN.p("act", "fallback");
            fN.p("result", z ? "1" : "0");
            fN.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fN);
        }
        this.UW = z;
    }

    public int getSlowNumber() {
        return this.UX;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.UY;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.UW = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.UW = true;
                } else {
                    this.UW = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.UY = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.UX = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.UZ = optJSONObject3.optInt("succ");
                    this.Va = optJSONObject3.optInt("err");
                    this.Vb = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.UX <= 0 || this.UY <= 0) {
                    this.UW = false;
                }
            } catch (Exception e) {
                this.UW = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
