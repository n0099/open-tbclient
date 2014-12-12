package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private boolean DJ;
    private int DK;
    private int DL;
    private int DM = 25;
    private int DN = 25;
    private int DO = 10;
    private int time;

    public int mC() {
        return this.DM;
    }

    public int mD() {
        return this.DN;
    }

    public int mE() {
        return this.DO;
    }

    public boolean mF() {
        return this.DJ;
    }

    public void ae(boolean z) {
        if (this.DJ != z) {
            com.baidu.adp.lib.stats.q ef = com.baidu.tbadk.core.util.w.ef();
            ef.r("act", "fallback");
            ef.r("result", z ? "1" : "0");
            ef.r("type", "switch");
            com.baidu.adp.lib.stats.f.es().a("img", ef);
        }
        this.DJ = z;
    }

    public int mG() {
        return this.DK;
    }

    public int getTime() {
        return this.time;
    }

    public int mH() {
        return this.DL;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.DJ = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.DJ = true;
                } else {
                    this.DJ = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.DL = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.DK = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.DM = optJSONObject3.optInt("succ");
                    this.DN = optJSONObject3.optInt("err");
                    this.DO = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.DK <= 0 || this.DL <= 0) {
                    this.DJ = false;
                }
            } catch (Exception e) {
                this.DJ = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
