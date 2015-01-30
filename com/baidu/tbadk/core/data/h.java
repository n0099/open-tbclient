package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private boolean DL;
    private int DM;
    private int DN;
    private int DO = 25;
    private int DP = 25;
    private int DQ = 10;
    private int time;

    public int mC() {
        return this.DO;
    }

    public int mD() {
        return this.DP;
    }

    public int mE() {
        return this.DQ;
    }

    public boolean mF() {
        return this.DL;
    }

    public void af(boolean z) {
        if (this.DL != z) {
            com.baidu.adp.lib.stats.q ed = com.baidu.tbadk.core.util.w.ed();
            ed.r("act", "fallback");
            ed.r("result", z ? "1" : "0");
            ed.r("type", "switch");
            com.baidu.adp.lib.stats.f.eq().a("img", ed);
        }
        this.DL = z;
    }

    public int mG() {
        return this.DM;
    }

    public int getTime() {
        return this.time;
    }

    public int mH() {
        return this.DN;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.DL = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.DL = true;
                } else {
                    this.DL = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.DN = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.DM = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.DO = optJSONObject3.optInt("succ");
                    this.DP = optJSONObject3.optInt("err");
                    this.DQ = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.DM <= 0 || this.DN <= 0) {
                    this.DL = false;
                }
            } catch (Exception e) {
                this.DL = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
