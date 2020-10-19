package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ah {
    private int aLW;
    private int aLX;
    private int aLY;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLW = jSONObject.optInt("category_select_switch", 0);
            this.aLX = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aLY = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean DW() {
        return (com.baidu.live.x.a.OS().blo == null || com.baidu.live.x.a.OS().blo.aLQ == null || com.baidu.live.x.a.OS().blo.aLQ.aLW != 1) ? false : true;
    }

    public static boolean DX() {
        return (com.baidu.live.x.a.OS().blo == null || com.baidu.live.x.a.OS().blo.aLQ == null || com.baidu.live.x.a.OS().blo.aLQ.aLX != 1) ? false : true;
    }

    public static int DY() {
        if (com.baidu.live.x.a.OS().blo == null || com.baidu.live.x.a.OS().blo.aLQ == null) {
            return 0;
        }
        return com.baidu.live.x.a.OS().blo.aLQ.aLY;
    }
}
