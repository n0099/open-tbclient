package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private boolean aKp;
    private int aKq;
    private int aKr;
    private int aKs = 25;
    private int aKt = 25;
    private int aKu = 10;
    private int time;

    public int getSuccRank() {
        return this.aKs;
    }

    public int getErrRank() {
        return this.aKt;
    }

    public int getSlowRank() {
        return this.aKu;
    }

    public boolean ismSwitch() {
        return this.aKp;
    }

    public void setmSwitch(boolean z) {
        if (this.aKp != z) {
            com.baidu.adp.lib.stats.a nm = com.baidu.tbadk.core.util.s.nm();
            nm.append("act", "fallback");
            nm.append("result", z ? "1" : "0");
            nm.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", nm);
        }
        this.aKp = z;
    }

    public int getSlowNumber() {
        return this.aKq;
    }

    public int getTime() {
        return this.time;
    }

    public int getErrNumber() {
        return this.aKr;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aKp = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aKp = true;
                } else {
                    this.aKp = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aKr = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.aKq = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.aKs = optJSONObject3.optInt("succ");
                    this.aKt = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.aKu = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aKq <= 0 || this.aKr <= 0) {
                    this.aKp = false;
                }
            } catch (Exception e) {
                this.aKp = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
