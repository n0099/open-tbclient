package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private boolean WV;
    private int WW;
    private int WX;
    private int WY = 25;
    private int WZ = 25;
    private int Xa = 10;
    private int time;

    public int getSuccRank() {
        return this.WY;
    }

    public int getErrRank() {
        return this.WZ;
    }

    public int getSlowRank() {
        return this.Xa;
    }

    public boolean ismSwitch() {
        return this.WV;
    }

    public void setmSwitch(boolean z) {
        if (this.WV != z) {
            com.baidu.adp.lib.stats.a fq = com.baidu.tbadk.core.util.s.fq();
            fq.append(SocialConstants.PARAM_ACT, "fallback");
            fq.append("result", z ? "1" : "0");
            fq.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fq);
        }
        this.WV = z;
    }

    public int getSlowNumber() {
        return this.WW;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.WX;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.WV = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.WV = true;
                } else {
                    this.WV = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.WX = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.WW = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.WY = optJSONObject3.optInt("succ");
                    this.WZ = optJSONObject3.optInt("err");
                    this.Xa = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.WW <= 0 || this.WX <= 0) {
                    this.WV = false;
                }
            } catch (Exception e) {
                this.WV = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
