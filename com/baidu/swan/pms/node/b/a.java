package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a {
    static final a dUL = new a(200, 720, 10, 168);
    public final int dUH;
    public final int dUI;
    public final int dUJ;
    public final int dUK;

    public a(int i, int i2, int i3, int i4) {
        this.dUH = i;
        this.dUI = i2;
        this.dUJ = i3;
        this.dUK = i4;
    }

    public static a cI(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
