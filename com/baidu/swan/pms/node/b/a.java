package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    static final a etp = new a(200, 720, 10, 168);
    public final int etl;
    public final int etm;
    public final int etn;
    public final int eto;

    public a(int i, int i2, int i3, int i4) {
        this.etl = i;
        this.etm = i2;
        this.etn = i3;
        this.eto = i4;
    }

    public static a cV(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
