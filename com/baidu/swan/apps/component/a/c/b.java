package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean caB;
    public String caC;
    public String caD;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.caB = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.caC = "";
        this.caD = "";
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
        if (this.caI != null) {
            try {
                this.textColor = Color.parseColor(this.caI.optString("color"));
                this.caB = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.caB = false;
            }
            this.fontSize = this.caI.optDouble("fontSize", 0.0d);
            this.lineSpace = ah.H((float) this.caI.optDouble("lineSpace", 0.0d));
            this.textAlign = this.caI.optString("textAlign");
            this.fontWeight = this.caI.optString("fontWeight");
            this.caC = this.caI.optString("whiteSpace");
            this.caD = this.caI.optString("lineBreak");
        }
    }

    public void kw(String str) {
        this.text = str;
    }
}
