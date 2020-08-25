package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean cax;
    public String cay;
    public String caz;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.cax = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.cay = "";
        this.caz = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            acU();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aH(JSONObject jSONObject) {
        super.aH(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        acU();
    }

    private void acU() {
        if (this.caE != null) {
            try {
                this.textColor = Color.parseColor(this.caE.optString("color"));
                this.cax = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.cax = false;
            }
            this.fontSize = this.caE.optDouble("fontSize", 0.0d);
            this.lineSpace = ah.H((float) this.caE.optDouble("lineSpace", 0.0d));
            this.textAlign = this.caE.optString("textAlign");
            this.fontWeight = this.caE.optString("fontWeight");
            this.cay = this.caE.optString("whiteSpace");
            this.caz = this.caE.optString("lineBreak");
        }
    }

    public void kv(String str) {
        this.text = str;
    }
}
