package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private boolean VV;
    private int VW;
    private int VX;
    private int VY = 25;
    private int VZ = 25;
    private int Wa = 10;
    private int time;

    public int getSuccRank() {
        return this.VY;
    }

    public int getErrRank() {
        return this.VZ;
    }

    public int getSlowRank() {
        return this.Wa;
    }

    public boolean ismSwitch() {
        return this.VV;
    }

    public void setmSwitch(boolean z) {
        if (this.VV != z) {
            com.baidu.adp.lib.stats.a fK = com.baidu.tbadk.core.util.s.fK();
            fK.p("act", "fallback");
            fK.p("result", z ? "1" : "0");
            fK.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fK);
        }
        this.VV = z;
    }

    public int getSlowNumber() {
        return this.VW;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.VX;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.VV = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.VV = true;
                } else {
                    this.VV = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.VX = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.VW = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.VY = optJSONObject3.optInt("succ");
                    this.VZ = optJSONObject3.optInt("err");
                    this.Wa = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.VW <= 0 || this.VX <= 0) {
                    this.VV = false;
                }
            } catch (Exception e) {
                this.VV = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
