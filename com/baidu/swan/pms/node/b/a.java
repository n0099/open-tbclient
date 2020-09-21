package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes24.dex */
public class a {
    static final a dIK = new a(200, 720, 10, 168);
    public final int dIG;
    public final int dIH;
    public final int dII;
    public final int dIJ;

    public a(int i, int i2, int i3, int i4) {
        this.dIG = i;
        this.dIH = i2;
        this.dII = i3;
        this.dIJ = i4;
    }

    public static a cB(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
