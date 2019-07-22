package com.baidu.swan.apps.button.b.b;

import android.text.TextUtils;
import com.baidu.swan.apps.button.b.b.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a<M extends a> extends com.baidu.swan.apps.button.b.a<M> {
    public String alc;
    public String ald;
    public String fontWeight;
    public double nK;
    public String text;
    public String textAlign;
    public int textSize;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.button.b.b.a<M extends com.baidu.swan.apps.button.b.b.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.button.b.a
    public /* bridge */ /* synthetic */ void a(com.baidu.swan.apps.button.b.a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        a((a<M>) aVar, aVar2);
    }

    public a(String str, String str2) {
        super(str, str2);
    }

    @Override // com.baidu.swan.apps.button.b.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.text = jSONObject.optString("text");
        if (this.akZ != null) {
            this.alc = this.akZ.optString("color");
            this.textSize = this.akZ.optInt("fontSize");
            this.nK = this.akZ.optDouble("lineHeight", 0.0d);
            this.textAlign = this.akZ.optString("textAlign");
            this.fontWeight = this.akZ.optString("fontWeight");
            this.ald = this.akZ.optString("whiteSpace");
        }
    }

    public void a(M m, com.baidu.swan.apps.view.container.c.a aVar) {
        super.a((a<M>) m, aVar);
        if (!TextUtils.equals(this.text, m.text)) {
            aVar.eL(2);
        }
    }
}
