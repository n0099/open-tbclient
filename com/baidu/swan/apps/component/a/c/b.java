package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean bib;
    public String bic;
    public String bie;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.bib = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.bic = "";
        this.bie = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            KD();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        KD();
    }

    private void KD() {
        if (this.bik != null) {
            try {
                this.textColor = Color.parseColor(this.bik.optString("color"));
                this.bib = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.bib = false;
            }
            this.fontSize = this.bik.optDouble("fontSize", 0.0d);
            this.lineSpace = af.S((float) this.bik.optDouble("lineSpace", 0.0d));
            this.textAlign = this.bik.optString("textAlign");
            this.fontWeight = this.bik.optString("fontWeight");
            this.bic = this.bik.optString("whiteSpace");
            this.bie = this.bik.optString("lineBreak");
        }
    }

    public void gp(String str) {
        this.text = str;
    }
}
