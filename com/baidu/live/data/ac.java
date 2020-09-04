package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ac {
    private int aHx;
    private int aHy;
    private int aHz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHx = jSONObject.optInt("category_select_switch", 0);
            this.aHy = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aHz = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean CJ() {
        return (com.baidu.live.w.a.Nk().beJ == null || com.baidu.live.w.a.Nk().beJ.aHv == null || com.baidu.live.w.a.Nk().beJ.aHv.aHx != 1) ? false : true;
    }

    public static boolean CK() {
        return (com.baidu.live.w.a.Nk().beJ == null || com.baidu.live.w.a.Nk().beJ.aHv == null || com.baidu.live.w.a.Nk().beJ.aHv.aHy != 1) ? false : true;
    }

    public static int CL() {
        if (com.baidu.live.w.a.Nk().beJ == null || com.baidu.live.w.a.Nk().beJ.aHv == null) {
            return 0;
        }
        return com.baidu.live.w.a.Nk().beJ.aHv.aHz;
    }
}
