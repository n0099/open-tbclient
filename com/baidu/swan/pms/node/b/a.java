package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    static final a eyc = new a(200, 720, 10, 168);
    public final int exY;
    public final int exZ;
    public final int eya;
    public final int eyb;

    public a(int i, int i2, int i3, int i4) {
        this.exY = i;
        this.exZ = i2;
        this.eya = i3;
        this.eyb = i4;
    }

    public static a cV(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
