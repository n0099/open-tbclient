package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a {
    static final a dGG = new a(200, 720, 10, 168);
    public final int dGC;
    public final int dGD;
    public final int dGE;
    public final int dGF;

    public a(int i, int i2, int i3, int i4) {
        this.dGC = i;
        this.dGD = i2;
        this.dGE = i3;
        this.dGF = i4;
    }

    public static a cy(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
