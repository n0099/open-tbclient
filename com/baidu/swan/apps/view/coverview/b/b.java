package com.baidu.swan.apps.view.coverview.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a {
    public String aZf;
    public boolean aZg;

    public b() {
        super("coverImage");
        this.aZg = false;
    }

    @Override // com.baidu.swan.apps.view.coverview.b.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        if (jSONObject != null) {
            this.aZf = jSONObject.optString("src");
            this.aZg = jSONObject.optBoolean("loadState", false);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.b.a
    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        super.a(aVar, aVar2);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (!TextUtils.equals(this.aZf, bVar.aZf)) {
                aVar2.ex(2);
            }
            if (this.aZg != bVar.aZg) {
                aVar2.ex(2);
            }
        }
    }
}
