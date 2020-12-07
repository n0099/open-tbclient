package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    static final a eou = new a(200, 720, 10, 168);
    public final int eoq;
    public final int eor;
    public final int eos;
    public final int eot;

    public a(int i, int i2, int i3, int i4) {
        this.eoq = i;
        this.eor = i2;
        this.eos = i3;
        this.eot = i4;
    }

    public static a cN(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
