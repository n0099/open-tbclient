package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private boolean DI;
    private int DJ;
    private int DK;
    private int DL = 25;
    private int DM = 25;
    private int DN = 10;
    private int time;

    public int mv() {
        return this.DL;
    }

    public int mw() {
        return this.DM;
    }

    public int mx() {
        return this.DN;
    }

    public boolean my() {
        return this.DI;
    }

    public void af(boolean z) {
        if (this.DI != z) {
            com.baidu.adp.lib.stats.q ed = com.baidu.tbadk.core.util.w.ed();
            ed.r("act", "fallback");
            ed.r("result", z ? "1" : "0");
            ed.r("type", "switch");
            com.baidu.adp.lib.stats.f.eq().a("img", ed);
        }
        this.DI = z;
    }

    public int mz() {
        return this.DJ;
    }

    public int getTime() {
        return this.time;
    }

    public int mA() {
        return this.DK;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.DI = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.DI = true;
                } else {
                    this.DI = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.DK = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.DJ = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.DL = optJSONObject3.optInt("succ");
                    this.DM = optJSONObject3.optInt("err");
                    this.DN = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.DJ <= 0 || this.DK <= 0) {
                    this.DI = false;
                }
            } catch (Exception e) {
                this.DI = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
