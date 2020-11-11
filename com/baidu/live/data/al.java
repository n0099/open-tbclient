package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class al {
    private int aND;
    private int aNE;
    private int aNF;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aND = jSONObject.optInt("category_select_switch", 0);
            this.aNE = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aNF = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean EB() {
        return (com.baidu.live.aa.a.PQ().bod == null || com.baidu.live.aa.a.PQ().bod.aNu == null || com.baidu.live.aa.a.PQ().bod.aNu.aND != 1) ? false : true;
    }

    public static boolean EC() {
        return (com.baidu.live.aa.a.PQ().bod == null || com.baidu.live.aa.a.PQ().bod.aNu == null || com.baidu.live.aa.a.PQ().bod.aNu.aNE != 1) ? false : true;
    }

    public static int ED() {
        if (com.baidu.live.aa.a.PQ().bod == null || com.baidu.live.aa.a.PQ().bod.aNu == null) {
            return 0;
        }
        return com.baidu.live.aa.a.PQ().bod.aNu.aNF;
    }
}
