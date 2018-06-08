package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private boolean aeX;
    private int aeY;
    private int aeZ;
    private int afa = 25;
    private int afb = 25;
    private int afc = 10;
    private int time;

    public int getSuccRank() {
        return this.afa;
    }

    public int getErrRank() {
        return this.afb;
    }

    public int getSlowRank() {
        return this.afc;
    }

    public boolean ismSwitch() {
        return this.aeX;
    }

    public void setmSwitch(boolean z) {
        if (this.aeX != z) {
            com.baidu.adp.lib.stats.a ih = com.baidu.tbadk.core.util.t.ih();
            ih.append(SocialConstants.PARAM_ACT, "fallback");
            ih.append("result", z ? "1" : "0");
            ih.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", ih);
        }
        this.aeX = z;
    }

    public int getSlowNumber() {
        return this.aeY;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.aeZ;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aeX = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aeX = true;
                } else {
                    this.aeX = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aeZ = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.aeY = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.afa = optJSONObject3.optInt("succ");
                    this.afb = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.afc = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aeY <= 0 || this.aeZ <= 0) {
                    this.aeX = false;
                }
            } catch (Exception e) {
                this.aeX = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
