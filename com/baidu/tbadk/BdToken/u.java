package com.baidu.tbadk.BdToken;

import com.baidu.tbadk.core.util.UtilHelper;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class u {
    private long baF;
    private long mStartTime;

    public void parseJson(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() == 2) {
            this.mStartTime = jSONArray.optLong(0, 0L) * 1000;
            this.baF = jSONArray.optLong(1, 0L) * 1000;
        }
    }

    public long getStartTime() {
        return this.mStartTime + UtilHelper.getTimesMorning();
    }

    public long getEndTime() {
        return this.baF + UtilHelper.getTimesMorning();
    }
}
