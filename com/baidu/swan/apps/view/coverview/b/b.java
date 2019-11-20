package com.baidu.swan.apps.view.coverview.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a {
    public String bvo;
    public boolean bvp;

    public b() {
        super("coverImage");
        this.bvp = false;
    }

    @Override // com.baidu.swan.apps.view.coverview.b.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        if (jSONObject != null) {
            this.bvo = jSONObject.optString("src");
            this.bvp = jSONObject.optBoolean("loadState", false);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.b.a
    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        super.a(aVar, aVar2);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (!TextUtils.equals(this.bvo, bVar.bvo)) {
                aVar2.fG(2);
            }
            if (this.bvp != bVar.bvp) {
                aVar2.fG(2);
            }
        }
    }
}
