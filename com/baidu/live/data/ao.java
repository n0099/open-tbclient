package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ao {
    private int aPw;
    private int aPx;
    private int aPy;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPw = jSONObject.optInt("category_select_switch", 0);
            this.aPx = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aPy = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean ET() {
        return (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPl == null || com.baidu.live.af.a.SE().bwi.aPl.aPw != 1) ? false : true;
    }

    public static boolean EU() {
        return (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPl == null || com.baidu.live.af.a.SE().bwi.aPl.aPx != 1) ? false : true;
    }

    public static int EV() {
        if (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPl == null) {
            return 0;
        }
        return com.baidu.live.af.a.SE().bwi.aPl.aPy;
    }
}
