package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class as {
    private int aPf;
    private int aPg;
    private int aPh;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPf = jSONObject.optInt("category_select_switch", 0);
            this.aPg = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aPh = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean Co() {
        return (com.baidu.live.ae.a.Qm().bwx == null || com.baidu.live.ae.a.Qm().bwx.aOL == null || com.baidu.live.ae.a.Qm().bwx.aOL.aPf != 1) ? false : true;
    }

    public static boolean Cp() {
        return (com.baidu.live.ae.a.Qm().bwx == null || com.baidu.live.ae.a.Qm().bwx.aOL == null || com.baidu.live.ae.a.Qm().bwx.aOL.aPg != 1) ? false : true;
    }

    public static int Cq() {
        if (com.baidu.live.ae.a.Qm().bwx == null || com.baidu.live.ae.a.Qm().bwx.aOL == null) {
            return 0;
        }
        return com.baidu.live.ae.a.Qm().bwx.aOL.aPh;
    }
}
