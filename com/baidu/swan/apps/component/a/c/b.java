package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean cKT;
    public int cKU;
    public String cKV;
    public String cKW;
    public double fontSize;
    public String fontWeight;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.cKT = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.cKV = "";
        this.cKW = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            akW();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void bb(JSONObject jSONObject) {
        super.bb(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        akW();
    }

    private void akW() {
        if (this.cLb != null) {
            try {
                this.textColor = Color.parseColor(this.cLb.optString("color"));
                this.cKT = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.cKT = false;
            }
            this.fontSize = this.cLb.optDouble("fontSize", 0.0d);
            this.cKU = ah.P((float) this.cLb.optDouble("lineSpace", 0.0d));
            this.textAlign = this.cLb.optString("textAlign");
            this.fontWeight = this.cLb.optString("fontWeight");
            this.cKV = this.cLb.optString("whiteSpace");
            this.cKW = this.cLb.optString("lineBreak");
        }
    }

    public void lK(String str) {
        this.text = str;
    }
}
