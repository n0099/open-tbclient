package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private boolean Qr;
    private int Qs;
    private int Qt;
    private int Qu = 25;
    private int Qv = 25;
    private int Qw = 10;
    private int time;

    public int getSuccRank() {
        return this.Qu;
    }

    public int getErrRank() {
        return this.Qv;
    }

    public int getSlowRank() {
        return this.Qw;
    }

    public boolean ismSwitch() {
        return this.Qr;
    }

    public void setmSwitch(boolean z) {
        if (this.Qr != z) {
            com.baidu.adp.lib.stats.d eB = com.baidu.tbadk.core.util.u.eB();
            eB.q("act", "fallback");
            eB.q("result", z ? "1" : "0");
            eB.q("type", "switch");
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
        }
        this.Qr = z;
    }

    public int getSlowNumber() {
        return this.Qs;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.Qt;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Qr = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Qr = true;
                } else {
                    this.Qr = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Qt = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Qs = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Qu = optJSONObject3.optInt("succ");
                    this.Qv = optJSONObject3.optInt("err");
                    this.Qw = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Qs <= 0 || this.Qt <= 0) {
                    this.Qr = false;
                }
            } catch (Exception e) {
                this.Qr = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
