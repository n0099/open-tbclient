package com.baidu.tbadk.BdToken;

import com.baidu.tbadk.core.util.UtilHelper;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class t {
    private long aGl;
    private long mStartTime;

    public void e(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() == 2) {
            this.mStartTime = jSONArray.optLong(0, 0L) * 1000;
            this.aGl = jSONArray.optLong(1, 0L) * 1000;
        }
    }

    public long getStartTime() {
        return this.mStartTime + UtilHelper.getTimesMorning();
    }

    public long getEndTime() {
        return this.aGl + UtilHelper.getTimesMorning();
    }
}
