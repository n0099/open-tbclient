package com.baidu.searchbox.ui.animview.praise.guide;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class ControlShowData {
    private boolean open = true;
    private int sessionMaxCount = 1;
    private int dayMaxCount = 2;
    private int cycleMaxcount = 6;
    private int cycleTime = 60;

    public boolean isOpen() {
        return this.open;
    }

    public void setOpen(boolean z) {
        this.open = z;
    }

    public int getSessionMaxCount() {
        return this.sessionMaxCount;
    }

    public void setSessionMaxCount(int i) {
        this.sessionMaxCount = i;
    }

    public int getDayMaxCount() {
        return this.dayMaxCount;
    }

    public void setDayMaxCount(int i) {
        this.dayMaxCount = i;
    }

    public int getCycleMaxcount() {
        return this.cycleMaxcount;
    }

    public void setCycleMaxcount(int i) {
        this.cycleMaxcount = i;
    }

    public int getCycleTime() {
        return this.cycleTime;
    }

    public void setCycleTime(int i) {
        this.cycleTime = i;
    }

    public void parseData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                setOpen(jSONObject.optInt("switch", 1) == 1);
                setSessionMaxCount(jSONObject.optInt("session_max_count", 1));
                setDayMaxCount(jSONObject.optInt("day_max_count", 2));
                setCycleMaxcount(jSONObject.optInt("cycle_max_count", 6));
                setCycleTime(jSONObject.optInt("cycle_time", 60));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switch", this.open ? "1" : "0");
            jSONObject.put("session_max_count", this.sessionMaxCount);
            jSONObject.put("day_max_count", this.dayMaxCount);
            jSONObject.put("cycle_max_count", this.cycleMaxcount);
            jSONObject.put("cycle_time", this.cycleTime);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
