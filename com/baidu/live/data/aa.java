package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aa {
    private int aAY;
    private int aAZ;
    private int aBa;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAY = jSONObject.optInt("category_select_switch", 0);
            this.aAZ = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aBa = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean wE() {
        return (com.baidu.live.v.a.Hm().aZp == null || com.baidu.live.v.a.Hm().aZp.aAW == null || com.baidu.live.v.a.Hm().aZp.aAW.aAY != 1) ? false : true;
    }

    public static boolean wF() {
        return (com.baidu.live.v.a.Hm().aZp == null || com.baidu.live.v.a.Hm().aZp.aAW == null || com.baidu.live.v.a.Hm().aZp.aAW.aAZ != 1) ? false : true;
    }

    public static int wG() {
        if (com.baidu.live.v.a.Hm().aZp == null || com.baidu.live.v.a.Hm().aZp.aAW == null) {
            return 0;
        }
        return com.baidu.live.v.a.Hm().aZp.aAW.aBa;
    }
}
