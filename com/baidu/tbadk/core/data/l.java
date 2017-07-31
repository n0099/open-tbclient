package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private boolean VO;
    private int VP;
    private int VQ;
    private int VR = 25;
    private int VS = 25;
    private int VT = 10;
    private int time;

    public int getSuccRank() {
        return this.VR;
    }

    public int getErrRank() {
        return this.VS;
    }

    public int getSlowRank() {
        return this.VT;
    }

    public boolean ismSwitch() {
        return this.VO;
    }

    public void setmSwitch(boolean z) {
        if (this.VO != z) {
            com.baidu.adp.lib.stats.a fV = com.baidu.tbadk.core.util.r.fV();
            fV.p("act", "fallback");
            fV.p("result", z ? "1" : "0");
            fV.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fV);
        }
        this.VO = z;
    }

    public int getSlowNumber() {
        return this.VP;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.VQ;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.VO = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.VO = true;
                } else {
                    this.VO = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.VQ = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.VP = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.VR = optJSONObject3.optInt("succ");
                    this.VS = optJSONObject3.optInt("err");
                    this.VT = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.VP <= 0 || this.VQ <= 0) {
                    this.VO = false;
                }
            } catch (Exception e) {
                this.VO = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
