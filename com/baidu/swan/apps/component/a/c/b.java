package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean cNr;
    public int cNs;
    public String cNt;
    public String cNu;
    public double fontSize;
    public String fontWeight;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.cNr = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.cNt = "";
        this.cNu = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            aor();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void be(JSONObject jSONObject) {
        super.be(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        aor();
    }

    private void aor() {
        if (this.cNz != null) {
            try {
                this.textColor = Color.parseColor(this.cNz.optString("color"));
                this.cNr = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.cNr = false;
            }
            this.fontSize = this.cNz.optDouble("fontSize", 0.0d);
            this.cNs = ah.O((float) this.cNz.optDouble("lineSpace", 0.0d));
            this.textAlign = this.cNz.optString("textAlign");
            this.fontWeight = this.cNz.optString("fontWeight");
            this.cNt = this.cNz.optString("whiteSpace");
            this.cNu = this.cNz.optString("lineBreak");
        }
    }

    public void mD(String str) {
        this.text = str;
    }
}
