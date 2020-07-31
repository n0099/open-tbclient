package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aa {
    private int aCl;
    private int aCm;
    private int aCn;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCl = jSONObject.optInt("category_select_switch", 0);
            this.aCm = jSONObject.optInt("im_audience_watch_switch", 0);
            this.aCn = jSONObject.optInt("im_audience_watch_time", 60);
        }
    }

    public static boolean xg() {
        return (com.baidu.live.v.a.Hs().aZn == null || com.baidu.live.v.a.Hs().aZn.aCj == null || com.baidu.live.v.a.Hs().aZn.aCj.aCl != 1) ? false : true;
    }

    public static boolean xh() {
        return (com.baidu.live.v.a.Hs().aZn == null || com.baidu.live.v.a.Hs().aZn.aCj == null || com.baidu.live.v.a.Hs().aZn.aCj.aCm != 1) ? false : true;
    }

    public static int xi() {
        if (com.baidu.live.v.a.Hs().aZn == null || com.baidu.live.v.a.Hs().aZn.aCj == null) {
            return 0;
        }
        return com.baidu.live.v.a.Hs().aZn.aCj.aCn;
    }
}
