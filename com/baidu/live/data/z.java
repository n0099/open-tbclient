package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class z {
    private int ayH;
    private int ayI;
    private int ayJ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayH = jSONObject.optInt("category_select_switch", 0);
            this.ayI = jSONObject.optInt("im_audience_watch_switch", 0);
            this.ayJ = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean wg() {
        return (com.baidu.live.v.a.Ge().aWF == null || com.baidu.live.v.a.Ge().aWF.ayF == null || com.baidu.live.v.a.Ge().aWF.ayF.ayH != 1) ? false : true;
    }

    public static boolean wh() {
        return (com.baidu.live.v.a.Ge().aWF == null || com.baidu.live.v.a.Ge().aWF.ayF == null || com.baidu.live.v.a.Ge().aWF.ayF.ayI != 1) ? false : true;
    }

    public static int wi() {
        if (com.baidu.live.v.a.Ge().aWF == null || com.baidu.live.v.a.Ge().aWF.ayF == null) {
            return 0;
        }
        return com.baidu.live.v.a.Ge().aWF.ayF.ayJ;
    }
}
