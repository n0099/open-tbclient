package com.baidu.swan.pms.node.a;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private JSONArray evn;
    private JSONObject evo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(JSONArray jSONArray, JSONObject jSONObject) {
        this.evn = jSONArray;
        this.evo = jSONObject;
    }

    public JSONObject bdy() {
        return this.evo;
    }

    public JSONArray bdz() {
        return this.evn;
    }
}
