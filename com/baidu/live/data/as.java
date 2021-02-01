package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class as {
    private int aNF;
    private int aNG;
    private int aNH;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNF = jSONObject.optInt("category_select_switch", 0);
            this.aNG = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aNH = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean Cl() {
        return (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNl == null || com.baidu.live.ae.a.Qj().buX.aNl.aNF != 1) ? false : true;
    }

    public static boolean Cm() {
        return (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNl == null || com.baidu.live.ae.a.Qj().buX.aNl.aNG != 1) ? false : true;
    }

    public static int Cn() {
        if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNl == null) {
            return 0;
        }
        return com.baidu.live.ae.a.Qj().buX.aNl.aNH;
    }
}
