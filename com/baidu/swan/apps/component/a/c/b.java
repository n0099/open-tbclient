package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean bhM;
    public String bhN;
    public String bhO;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.bhM = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.bhN = "";
        this.bhO = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            Ky();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        Ky();
    }

    private void Ky() {
        if (this.bhT != null) {
            try {
                this.textColor = Color.parseColor(this.bhT.optString("color"));
                this.bhM = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.bhM = false;
            }
            this.fontSize = this.bhT.optDouble("fontSize", 0.0d);
            this.lineSpace = af.S((float) this.bhT.optDouble("lineSpace", 0.0d));
            this.textAlign = this.bhT.optString("textAlign");
            this.fontWeight = this.bhT.optString("fontWeight");
            this.bhN = this.bhT.optString("whiteSpace");
            this.bhO = this.bhT.optString("lineBreak");
        }
    }

    public void gq(String str) {
        this.text = str;
    }
}
