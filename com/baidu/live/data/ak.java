package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ak {
    private int aMB;
    private int aMC;
    private int aMD;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aMB = jSONObject.optInt("category_select_switch", 0);
            this.aMC = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aMD = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean Ef() {
        return (com.baidu.live.z.a.Pq().bmJ == null || com.baidu.live.z.a.Pq().bmJ.aMu == null || com.baidu.live.z.a.Pq().bmJ.aMu.aMB != 1) ? false : true;
    }

    public static boolean Eg() {
        return (com.baidu.live.z.a.Pq().bmJ == null || com.baidu.live.z.a.Pq().bmJ.aMu == null || com.baidu.live.z.a.Pq().bmJ.aMu.aMC != 1) ? false : true;
    }

    public static int Eh() {
        if (com.baidu.live.z.a.Pq().bmJ == null || com.baidu.live.z.a.Pq().bmJ.aMu == null) {
            return 0;
        }
        return com.baidu.live.z.a.Pq().bmJ.aMu.aMD;
    }
}
