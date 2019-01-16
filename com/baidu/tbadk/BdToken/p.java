package com.baidu.tbadk.BdToken;

import com.baidu.tbadk.core.util.UtilHelper;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class p {
    private long mEndTime;
    private long mStartTime;

    public void parseJson(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() == 2) {
            this.mStartTime = jSONArray.optLong(0, 0L) * 1000;
            this.mEndTime = jSONArray.optLong(1, 0L) * 1000;
        }
    }

    public long getStartTime() {
        return this.mStartTime + UtilHelper.getTimesMorning();
    }

    public long getEndTime() {
        return this.mEndTime + UtilHelper.getTimesMorning();
    }
}
