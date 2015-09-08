package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private boolean UH;
    private int UI;
    private int UJ;
    private int UK = 25;
    private int UL = 25;
    private int UM = 10;
    private int time;

    public int getSuccRank() {
        return this.UK;
    }

    public int getErrRank() {
        return this.UL;
    }

    public int getSlowRank() {
        return this.UM;
    }

    public boolean ismSwitch() {
        return this.UH;
    }

    public void setmSwitch(boolean z) {
        if (this.UH != z) {
            com.baidu.adp.lib.stats.d ha = com.baidu.tbadk.core.util.r.ha();
            ha.q("act", "fallback");
            ha.q("result", z ? "1" : "0");
            ha.q("type", "switch");
            com.baidu.adp.lib.stats.a.hh().b("img", ha);
        }
        this.UH = z;
    }

    public int getSlowNumber() {
        return this.UI;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.UJ;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.UH = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.UH = true;
                } else {
                    this.UH = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.UJ = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.UI = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.UK = optJSONObject3.optInt("succ");
                    this.UL = optJSONObject3.optInt("err");
                    this.UM = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.UI <= 0 || this.UJ <= 0) {
                    this.UH = false;
                }
            } catch (Exception e) {
                this.UH = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
