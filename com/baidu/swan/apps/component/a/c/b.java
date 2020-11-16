package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean cBE;
    public String cBF;
    public String cBG;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.cBE = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.cBF = "";
        this.cBG = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            aka();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aU(JSONObject jSONObject) {
        super.aU(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        aka();
    }

    private void aka() {
        if (this.cBL != null) {
            try {
                this.textColor = Color.parseColor(this.cBL.optString("color"));
                this.cBE = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.cBE = false;
            }
            this.fontSize = this.cBL.optDouble("fontSize", 0.0d);
            this.lineSpace = ah.M((float) this.cBL.optDouble("lineSpace", 0.0d));
            this.textAlign = this.cBL.optString("textAlign");
            this.fontWeight = this.cBL.optString("fontWeight");
            this.cBF = this.cBL.optString("whiteSpace");
            this.cBG = this.cBL.optString("lineBreak");
        }
    }

    public void md(String str) {
        this.text = str;
    }
}
