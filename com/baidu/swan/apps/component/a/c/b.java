package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean bGm;
    public String bGn;
    public String bGo;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.bGm = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.bGn = "";
        this.bGo = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            Sr();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aj(JSONObject jSONObject) {
        super.aj(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        Sr();
    }

    private void Sr() {
        if (this.bGt != null) {
            try {
                this.textColor = Color.parseColor(this.bGt.optString("color"));
                this.bGm = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.bGm = false;
            }
            this.fontSize = this.bGt.optDouble("fontSize", 0.0d);
            this.lineSpace = af.C((float) this.bGt.optDouble("lineSpace", 0.0d));
            this.textAlign = this.bGt.optString("textAlign");
            this.fontWeight = this.bGt.optString("fontWeight");
            this.bGn = this.bGt.optString("whiteSpace");
            this.bGo = this.bGt.optString("lineBreak");
        }
    }

    public void hD(String str) {
        this.text = str;
    }
}
