package com.baidu.searchbox.ui.animview.praise.guide;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CurrentShowData {
    public int cycleCurrentcount;
    public int dayCurrentCount;
    public int sessionCurrentCount;

    public int getCycleCurrentcount() {
        return this.cycleCurrentcount;
    }

    public int getDayCurrentCount() {
        return this.dayCurrentCount;
    }

    public int getSessionCurrentCount() {
        return this.sessionCurrentCount;
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("day_current_count", this.dayCurrentCount);
            jSONObject.put("cycle_current_count", this.cycleCurrentcount);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void parseData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            setDayCurrentCount(jSONObject.optInt("day_current_count", 0));
            setCycleCurrentcount(jSONObject.optInt("cycle_current_count", 0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setCycleCurrentcount(int i) {
        this.cycleCurrentcount = i;
    }

    public void setDayCurrentCount(int i) {
        this.dayCurrentCount = i;
    }

    public void setSessionCurrentCount(int i) {
        this.sessionCurrentCount = i;
    }
}
