package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.v;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private int time;
    private boolean zD;
    private int zE;
    private int zF;
    private int zG = 25;
    private int zH = 25;
    private int zI = 10;

    public int jN() {
        return this.zG;
    }

    public int jO() {
        return this.zH;
    }

    public int jP() {
        return this.zI;
    }

    public boolean jQ() {
        return this.zD;
    }

    public void O(boolean z) {
        if (this.zD != z) {
            com.baidu.adp.lib.stats.q logItem = v.getLogItem();
            logItem.n("act", "fallback");
            logItem.n("result", z ? "1" : "0");
            logItem.n("type", "switch");
            com.baidu.adp.lib.stats.f.er().a("img", logItem);
        }
        this.zD = z;
    }

    public int jR() {
        return this.zE;
    }

    public int getTime() {
        return this.time;
    }

    public int jS() {
        return this.zF;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.zD = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.zD = true;
                } else {
                    this.zD = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.zF = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.zE = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.zG = optJSONObject3.optInt("succ");
                    this.zH = optJSONObject3.optInt("err");
                    this.zI = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.zE <= 0 || this.zF <= 0) {
                    this.zD = false;
                }
            } catch (Exception e) {
                this.zD = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
