package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private boolean Vi;
    private int Vj;
    private int Vk;
    private int Vl = 25;
    private int Vm = 25;
    private int Vn = 10;
    private int time;

    public int getSuccRank() {
        return this.Vl;
    }

    public int getErrRank() {
        return this.Vm;
    }

    public int getSlowRank() {
        return this.Vn;
    }

    public boolean ismSwitch() {
        return this.Vi;
    }

    public void setmSwitch(boolean z) {
        if (this.Vi != z) {
            com.baidu.adp.lib.stats.a fK = com.baidu.tbadk.core.util.s.fK();
            fK.p("act", "fallback");
            fK.p("result", z ? "1" : "0");
            fK.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fK);
        }
        this.Vi = z;
    }

    public int getSlowNumber() {
        return this.Vj;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.Vk;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Vi = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Vi = true;
                } else {
                    this.Vi = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Vk = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Vj = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Vl = optJSONObject3.optInt("succ");
                    this.Vm = optJSONObject3.optInt("err");
                    this.Vn = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Vj <= 0 || this.Vk <= 0) {
                    this.Vi = false;
                }
            } catch (Exception e) {
                this.Vi = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
