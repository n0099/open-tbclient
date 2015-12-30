package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private boolean Vq;
    private int Vr;
    private int Vs;
    private int Vt = 25;
    private int Vu = 25;
    private int Vv = 10;
    private int time;

    public int getSuccRank() {
        return this.Vt;
    }

    public int getErrRank() {
        return this.Vu;
    }

    public int getSlowRank() {
        return this.Vv;
    }

    public boolean ismSwitch() {
        return this.Vq;
    }

    public void setmSwitch(boolean z) {
        if (this.Vq != z) {
            com.baidu.adp.lib.stats.d he = com.baidu.tbadk.core.util.v.he();
            he.q("act", "fallback");
            he.q("result", z ? "1" : "0");
            he.q("type", "switch");
            com.baidu.adp.lib.stats.a.hl().b("img", he);
        }
        this.Vq = z;
    }

    public int getSlowNumber() {
        return this.Vr;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.Vs;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Vq = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Vq = true;
                } else {
                    this.Vq = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Vs = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Vr = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Vt = optJSONObject3.optInt("succ");
                    this.Vu = optJSONObject3.optInt("err");
                    this.Vv = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Vr <= 0 || this.Vs <= 0) {
                    this.Vq = false;
                }
            } catch (Exception e) {
                this.Vq = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
