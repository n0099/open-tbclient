package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class am {
    private int aOP;
    private int aOQ;
    private int aOR;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOP = jSONObject.optInt("category_select_switch", 0);
            this.aOQ = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aOR = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean FD() {
        return (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOE == null || com.baidu.live.ae.a.RB().brA.aOE.aOP != 1) ? false : true;
    }

    public static boolean FE() {
        return (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOE == null || com.baidu.live.ae.a.RB().brA.aOE.aOQ != 1) ? false : true;
    }

    public static int FF() {
        if (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOE == null) {
            return 0;
        }
        return com.baidu.live.ae.a.RB().brA.aOE.aOR;
    }
}
