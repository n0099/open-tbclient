package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public String cIA;
    public String cIB;
    public boolean cIz;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.cIz = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.cIA = "";
        this.cIB = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            ani();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aW(JSONObject jSONObject) {
        super.aW(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        ani();
    }

    private void ani() {
        if (this.cIG != null) {
            try {
                this.textColor = Color.parseColor(this.cIG.optString("color"));
                this.cIz = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.cIz = false;
            }
            this.fontSize = this.cIG.optDouble("fontSize", 0.0d);
            this.lineSpace = ah.M((float) this.cIG.optDouble("lineSpace", 0.0d));
            this.textAlign = this.cIG.optString("textAlign");
            this.fontWeight = this.cIG.optString("fontWeight");
            this.cIA = this.cIG.optString("whiteSpace");
            this.cIB = this.cIG.optString("lineBreak");
        }
    }

    public void mK(String str) {
        this.text = str;
    }
}
