package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a {
    static final a dGC = new a(200, 720, 10, 168);
    public final int dGA;
    public final int dGB;
    public final int dGy;
    public final int dGz;

    public a(int i, int i2, int i3, int i4) {
        this.dGy = i;
        this.dGz = i2;
        this.dGA = i3;
        this.dGB = i4;
    }

    public static a cy(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
