package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    static final a ewW = new a(200, 720, 10, 168);
    public final int ewS;
    public final int ewT;
    public final int ewU;
    public final int ewV;

    public a(int i, int i2, int i3, int i4) {
        this.ewS = i;
        this.ewT = i2;
        this.ewU = i3;
        this.ewV = i4;
    }

    public static a cU(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
