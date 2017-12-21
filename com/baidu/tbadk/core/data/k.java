package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private boolean VS;
    private int VT;
    private int VU;
    private int VV = 25;
    private int VW = 25;
    private int VX = 10;
    private int time;

    public int getSuccRank() {
        return this.VV;
    }

    public int getErrRank() {
        return this.VW;
    }

    public int getSlowRank() {
        return this.VX;
    }

    public boolean ismSwitch() {
        return this.VS;
    }

    public void setmSwitch(boolean z) {
        if (this.VS != z) {
            com.baidu.adp.lib.stats.a fK = com.baidu.tbadk.core.util.s.fK();
            fK.p("act", "fallback");
            fK.p("result", z ? "1" : "0");
            fK.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fK);
        }
        this.VS = z;
    }

    public int getSlowNumber() {
        return this.VT;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.VU;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.VS = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.VS = true;
                } else {
                    this.VS = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.VU = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.VT = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.VV = optJSONObject3.optInt("succ");
                    this.VW = optJSONObject3.optInt("err");
                    this.VX = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.VT <= 0 || this.VU <= 0) {
                    this.VS = false;
                }
            } catch (Exception e) {
                this.VS = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
