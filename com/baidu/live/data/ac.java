package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ac {
    private int aHv;
    private int aHw;
    private int aHx;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHv = jSONObject.optInt("category_select_switch", 0);
            this.aHw = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aHx = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean CJ() {
        return (com.baidu.live.w.a.Nk().beH == null || com.baidu.live.w.a.Nk().beH.aHt == null || com.baidu.live.w.a.Nk().beH.aHt.aHv != 1) ? false : true;
    }

    public static boolean CK() {
        return (com.baidu.live.w.a.Nk().beH == null || com.baidu.live.w.a.Nk().beH.aHt == null || com.baidu.live.w.a.Nk().beH.aHt.aHw != 1) ? false : true;
    }

    public static int CL() {
        if (com.baidu.live.w.a.Nk().beH == null || com.baidu.live.w.a.Nk().beH.aHt == null) {
            return 0;
        }
        return com.baidu.live.w.a.Nk().beH.aHt.aHx;
    }
}
