package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a {
    static final a edh = new a(200, 720, 10, 168);
    public final int edd;
    public final int ede;
    public final int edf;
    public final int edg;

    public a(int i, int i2, int i3, int i4) {
        this.edd = i;
        this.ede = i2;
        this.edf = i3;
        this.edg = i4;
    }

    public static a cL(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
