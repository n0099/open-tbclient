package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private boolean SK;
    private int SL;
    private int SM;
    private int SN = 25;
    private int SO = 25;
    private int SQ = 10;
    private int time;

    public int getSuccRank() {
        return this.SN;
    }

    public int getErrRank() {
        return this.SO;
    }

    public int getSlowRank() {
        return this.SQ;
    }

    public boolean ismSwitch() {
        return this.SK;
    }

    public void setmSwitch(boolean z) {
        if (this.SK != z) {
            com.baidu.adp.lib.stats.d hs = com.baidu.tbadk.core.util.v.hs();
            hs.r("act", "fallback");
            hs.r("result", z ? "1" : "0");
            hs.r("type", "switch");
            com.baidu.adp.lib.stats.a.hz().b("img", hs);
        }
        this.SK = z;
    }

    public int getSlowNumber() {
        return this.SL;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.SM;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.SK = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.SK = true;
                } else {
                    this.SK = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.SM = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.SL = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.SN = optJSONObject3.optInt("succ");
                    this.SO = optJSONObject3.optInt("err");
                    this.SQ = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.SL <= 0 || this.SM <= 0) {
                    this.SK = false;
                }
            } catch (Exception e) {
                this.SK = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
