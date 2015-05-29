package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.game.GameInfoData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private boolean PV;
    private int PW;
    private int PX;
    private int PY = 25;
    private int PZ = 25;
    private int Qa = 10;
    private int time;

    public int getSuccRank() {
        return this.PY;
    }

    public int getErrRank() {
        return this.PZ;
    }

    public int getSlowRank() {
        return this.Qa;
    }

    public boolean ismSwitch() {
        return this.PV;
    }

    public void setmSwitch(boolean z) {
        if (this.PV != z) {
            com.baidu.adp.lib.stats.q hm = com.baidu.tbadk.core.util.t.hm();
            hm.r("act", "fallback");
            hm.r("result", z ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hm.r("type", "switch");
            com.baidu.adp.lib.stats.f.hz().a("img", hm);
        }
        this.PV = z;
    }

    public int getSlowNumber() {
        return this.PW;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.PX;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.PV = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.PV = true;
                } else {
                    this.PV = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.PX = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.PW = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.PY = optJSONObject3.optInt("succ");
                    this.PZ = optJSONObject3.optInt("err");
                    this.Qa = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.PW <= 0 || this.PX <= 0) {
                    this.PV = false;
                }
            } catch (Exception e) {
                this.PV = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
