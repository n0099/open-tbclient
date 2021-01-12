package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ao {
    private int aKJ;
    private int aKK;
    private int aKL;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKJ = jSONObject.optInt("category_select_switch", 0);
            this.aKK = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aKL = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean AY() {
        return (com.baidu.live.af.a.OJ().bru == null || com.baidu.live.af.a.OJ().bru.aKy == null || com.baidu.live.af.a.OJ().bru.aKy.aKJ != 1) ? false : true;
    }

    public static boolean AZ() {
        return (com.baidu.live.af.a.OJ().bru == null || com.baidu.live.af.a.OJ().bru.aKy == null || com.baidu.live.af.a.OJ().bru.aKy.aKK != 1) ? false : true;
    }

    public static int Ba() {
        if (com.baidu.live.af.a.OJ().bru == null || com.baidu.live.af.a.OJ().bru.aKy == null) {
            return 0;
        }
        return com.baidu.live.af.a.OJ().bru.aKy.aKL;
    }
}
