package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    static final a evv = new a(200, 720, 10, 168);
    public final int evr;
    public final int evs;
    public final int evt;
    public final int evu;

    public a(int i, int i2, int i3, int i4) {
        this.evr = i;
        this.evs = i2;
        this.evt = i3;
        this.evu = i4;
    }

    public static a cS(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
