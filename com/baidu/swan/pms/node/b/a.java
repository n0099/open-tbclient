package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    static final a ehs = new a(200, 720, 10, 168);
    public final int eho;
    public final int ehp;
    public final int ehq;
    public final int ehr;

    public a(int i, int i2, int i3, int i4) {
        this.eho = i;
        this.ehp = i2;
        this.ehq = i3;
        this.ehr = i4;
    }

    public static a cL(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
