package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a {
    static final a dxw = new a(200, 720, 10, 168);
    public final int dxs;
    public final int dxt;
    public final int dxu;
    public final int dxv;

    public a(int i, int i2, int i3, int i4) {
        this.dxs = i;
        this.dxt = i2;
        this.dxu = i3;
        this.dxv = i4;
    }

    public static a ct(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
