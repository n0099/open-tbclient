package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private boolean Qo;
    private int Qp;
    private int Qq;
    private int Qr = 25;
    private int Qs = 25;
    private int Qt = 10;
    private int time;

    public int getSuccRank() {
        return this.Qr;
    }

    public int getErrRank() {
        return this.Qs;
    }

    public int getSlowRank() {
        return this.Qt;
    }

    public boolean ismSwitch() {
        return this.Qo;
    }

    public void setmSwitch(boolean z) {
        if (this.Qo != z) {
            com.baidu.adp.lib.stats.d eB = com.baidu.tbadk.core.util.u.eB();
            eB.q("act", "fallback");
            eB.q("result", z ? "1" : "0");
            eB.q("type", "switch");
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
        }
        this.Qo = z;
    }

    public int getSlowNumber() {
        return this.Qp;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.Qq;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Qo = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Qo = true;
                } else {
                    this.Qo = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Qq = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Qp = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Qr = optJSONObject3.optInt("succ");
                    this.Qs = optJSONObject3.optInt("err");
                    this.Qt = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Qp <= 0 || this.Qq <= 0) {
                    this.Qo = false;
                }
            } catch (Exception e) {
                this.Qo = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
