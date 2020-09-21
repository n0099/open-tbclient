package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ah {
    private int aIR;
    private int aIS;
    private int aIT;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIR = jSONObject.optInt("category_select_switch", 0);
            this.aIS = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aIT = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean CZ() {
        return (com.baidu.live.x.a.NN().bhy == null || com.baidu.live.x.a.NN().bhy.aIM == null || com.baidu.live.x.a.NN().bhy.aIM.aIR != 1) ? false : true;
    }

    public static boolean Da() {
        return (com.baidu.live.x.a.NN().bhy == null || com.baidu.live.x.a.NN().bhy.aIM == null || com.baidu.live.x.a.NN().bhy.aIM.aIS != 1) ? false : true;
    }

    public static int Db() {
        if (com.baidu.live.x.a.NN().bhy == null || com.baidu.live.x.a.NN().bhy.aIM == null) {
            return 0;
        }
        return com.baidu.live.x.a.NN().bhy.aIM.aIT;
    }
}
