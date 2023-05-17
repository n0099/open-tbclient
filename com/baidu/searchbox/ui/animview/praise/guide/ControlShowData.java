package com.baidu.searchbox.ui.animview.praise.guide;

import android.text.TextUtils;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ControlShowData {
    public boolean open = true;
    public int sessionMaxCount = 1;
    public int dayMaxCount = 2;
    public int cycleMaxcount = 6;
    public int cycleTime = 60;

    public int getCycleMaxcount() {
        return this.cycleMaxcount;
    }

    public int getCycleTime() {
        return this.cycleTime;
    }

    public int getDayMaxCount() {
        return this.dayMaxCount;
    }

    public int getSessionMaxCount() {
        return this.sessionMaxCount;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void parseData(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            setOpen(z);
            setSessionMaxCount(jSONObject.optInt("session_max_count", 1));
            setDayMaxCount(jSONObject.optInt("day_max_count", 2));
            setCycleMaxcount(jSONObject.optInt("cycle_max_count", 6));
            setCycleTime(jSONObject.optInt("cycle_time", 60));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setCycleMaxcount(int i) {
        this.cycleMaxcount = i;
    }

    public void setCycleTime(int i) {
        this.cycleTime = i;
    }

    public void setDayMaxCount(int i) {
        this.dayMaxCount = i;
    }

    public void setOpen(boolean z) {
        this.open = z;
    }

    public void setSessionMaxCount(int i) {
        this.sessionMaxCount = i;
    }

    public String toJson() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.open) {
                str = "1";
            } else {
                str = "0";
            }
            jSONObject.put(SetImageWatermarkTypeReqMsg.SWITCH, str);
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
