package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private boolean UG;
    private int UH;
    private int UI;
    private int UJ = 25;
    private int UK = 25;
    private int UL = 10;
    private int time;

    public int getSuccRank() {
        return this.UJ;
    }

    public int getErrRank() {
        return this.UK;
    }

    public int getSlowRank() {
        return this.UL;
    }

    public boolean ismSwitch() {
        return this.UG;
    }

    public void setmSwitch(boolean z) {
        if (this.UG != z) {
            com.baidu.adp.lib.stats.d hd = com.baidu.tbadk.core.util.r.hd();
            hd.q("act", "fallback");
            hd.q("result", z ? "1" : "0");
            hd.q("type", "switch");
            com.baidu.adp.lib.stats.a.hk().b("img", hd);
        }
        this.UG = z;
    }

    public int getSlowNumber() {
        return this.UH;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.UI;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.UG = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.UG = true;
                } else {
                    this.UG = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.UI = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.UH = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.UJ = optJSONObject3.optInt("succ");
                    this.UK = optJSONObject3.optInt("err");
                    this.UL = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.UH <= 0 || this.UI <= 0) {
                    this.UG = false;
                }
            } catch (Exception e) {
                this.UG = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
