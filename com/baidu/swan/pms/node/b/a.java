package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    static final a dmT = new a(200, 720, 10, 168);
    public final int dmP;
    public final int dmQ;
    public final int dmR;
    public final int dmS;

    public a(int i, int i2, int i3, int i4) {
        this.dmP = i;
        this.dmQ = i2;
        this.dmR = i3;
        this.dmS = i4;
    }

    public static a cg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
