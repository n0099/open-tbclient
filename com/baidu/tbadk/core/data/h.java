package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private boolean Vb;
    private int Vc;
    private int Vd;
    private int Ve = 25;
    private int Vf = 25;
    private int Vg = 10;
    private int time;

    public int getSuccRank() {
        return this.Ve;
    }

    public int getErrRank() {
        return this.Vf;
    }

    public int getSlowRank() {
        return this.Vg;
    }

    public boolean ismSwitch() {
        return this.Vb;
    }

    public void setmSwitch(boolean z) {
        if (this.Vb != z) {
            com.baidu.adp.lib.stats.d hm = com.baidu.tbadk.core.util.u.hm();
            hm.r("act", "fallback");
            hm.r("result", z ? "1" : "0");
            hm.r("type", "switch");
            com.baidu.adp.lib.stats.a.ht().b("img", hm);
        }
        this.Vb = z;
    }

    public int getSlowNumber() {
        return this.Vc;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.Vd;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Vb = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Vb = true;
                } else {
                    this.Vb = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Vd = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Vc = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Ve = optJSONObject3.optInt("succ");
                    this.Vf = optJSONObject3.optInt("err");
                    this.Vg = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Vc <= 0 || this.Vd <= 0) {
                    this.Vb = false;
                }
            } catch (Exception e) {
                this.Vb = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
