package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean cIF;
    public int cIG;
    public String cIH;
    public String cII;
    public double fontSize;
    public String fontWeight;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.cIF = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.cIH = "";
        this.cII = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            aky();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void be(JSONObject jSONObject) {
        super.be(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        aky();
    }

    private void aky() {
        if (this.cIN != null) {
            try {
                this.textColor = Color.parseColor(this.cIN.optString("color"));
                this.cIF = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.cIF = false;
            }
            this.fontSize = this.cIN.optDouble("fontSize", 0.0d);
            this.cIG = ah.O((float) this.cIN.optDouble("lineSpace", 0.0d));
            this.textAlign = this.cIN.optString("textAlign");
            this.fontWeight = this.cIN.optString("fontWeight");
            this.cIH = this.cIN.optString("whiteSpace");
            this.cII = this.cIN.optString("lineBreak");
        }
    }

    public void ls(String str) {
        this.text = str;
    }
}
