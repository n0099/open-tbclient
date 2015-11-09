package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private int UA;
    private int UB;
    private int UC = 25;
    private int UD = 25;
    private int UE = 10;
    private boolean Uz;
    private int time;

    public int getSuccRank() {
        return this.UC;
    }

    public int getErrRank() {
        return this.UD;
    }

    public int getSlowRank() {
        return this.UE;
    }

    public boolean ismSwitch() {
        return this.Uz;
    }

    public void setmSwitch(boolean z) {
        if (this.Uz != z) {
            com.baidu.adp.lib.stats.d hc = com.baidu.tbadk.core.util.r.hc();
            hc.q("act", "fallback");
            hc.q("result", z ? "1" : "0");
            hc.q("type", "switch");
            com.baidu.adp.lib.stats.a.hj().b("img", hc);
        }
        this.Uz = z;
    }

    public int getSlowNumber() {
        return this.UA;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.UB;
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
                    this.UB = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.UA = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.UC = optJSONObject3.optInt("succ");
                    this.UD = optJSONObject3.optInt("err");
                    this.UE = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.UA <= 0 || this.UB <= 0) {
                    this.Uz = false;
                }
            } catch (Exception e) {
                this.Uz = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
