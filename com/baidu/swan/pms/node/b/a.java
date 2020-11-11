package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a {
    static final a eiZ = new a(200, 720, 10, 168);
    public final int eiV;
    public final int eiW;
    public final int eiX;
    public final int eiY;

    public a(int i, int i2, int i3, int i4) {
        this.eiV = i;
        this.eiW = i2;
        this.eiX = i3;
        this.eiY = i4;
    }

    public static a cR(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
