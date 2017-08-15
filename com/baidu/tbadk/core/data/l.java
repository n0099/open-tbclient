package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private boolean VQ;
    private int VR;
    private int VS;
    private int VT = 25;
    private int VU = 25;
    private int VV = 10;
    private int time;

    public int getSuccRank() {
        return this.VT;
    }

    public int getErrRank() {
        return this.VU;
    }

    public int getSlowRank() {
        return this.VV;
    }

    public boolean ismSwitch() {
        return this.VQ;
    }

    public void setmSwitch(boolean z) {
        if (this.VQ != z) {
            com.baidu.adp.lib.stats.a fV = com.baidu.tbadk.core.util.r.fV();
            fV.p("act", "fallback");
            fV.p("result", z ? "1" : "0");
            fV.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fV);
        }
        this.VQ = z;
    }

    public int getSlowNumber() {
        return this.VR;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.VS;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.VQ = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.VQ = true;
                } else {
                    this.VQ = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.VS = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.VR = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.VT = optJSONObject3.optInt("succ");
                    this.VU = optJSONObject3.optInt("err");
                    this.VV = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.VR <= 0 || this.VS <= 0) {
                    this.VQ = false;
                }
            } catch (Exception e) {
                this.VQ = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
