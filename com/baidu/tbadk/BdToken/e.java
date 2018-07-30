package com.baidu.tbadk.BdToken;

import com.baidu.tbadk.core.util.UtilHelper;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class e {
    private long ZI;
    private long mStartTime;

    public void b(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() == 2) {
            this.mStartTime = jSONArray.optLong(0, 0L) * 1000;
            this.ZI = jSONArray.optLong(1, 0L) * 1000;
        }
    }

    public long getStartTime() {
        return this.mStartTime + UtilHelper.getTimesMorning();
    }

    public long getEndTime() {
        return this.ZI + UtilHelper.getTimesMorning();
    }
}
