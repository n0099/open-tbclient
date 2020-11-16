package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class al {
    private int aLS;
    private int aLT;
    private int aLU;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLS = jSONObject.optInt("category_select_switch", 0);
            this.aLT = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aLU = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean DS() {
        return (com.baidu.live.aa.a.Ph().bms == null || com.baidu.live.aa.a.Ph().bms.aLJ == null || com.baidu.live.aa.a.Ph().bms.aLJ.aLS != 1) ? false : true;
    }

    public static boolean DT() {
        return (com.baidu.live.aa.a.Ph().bms == null || com.baidu.live.aa.a.Ph().bms.aLJ == null || com.baidu.live.aa.a.Ph().bms.aLJ.aLT != 1) ? false : true;
    }

    public static int DU() {
        if (com.baidu.live.aa.a.Ph().bms == null || com.baidu.live.aa.a.Ph().bms.aLJ == null) {
            return 0;
        }
        return com.baidu.live.aa.a.Ph().bms.aLJ.aLU;
    }
}
