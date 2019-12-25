package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean bcK;
    public String bcL;
    public String bcM;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.bcK = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.bcL = "";
        this.bcM = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            HN();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        HN();
    }

    private void HN() {
        if (this.bcR != null) {
            try {
                this.textColor = Color.parseColor(this.bcR.optString("color"));
                this.bcK = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.bcK = false;
            }
            this.fontSize = this.bcR.optDouble("fontSize", 0.0d);
            this.lineSpace = af.T((float) this.bcR.optDouble("lineSpace", 0.0d));
            this.textAlign = this.bcR.optString("textAlign");
            this.fontWeight = this.bcR.optString("fontWeight");
            this.bcL = this.bcR.optString("whiteSpace");
            this.bcM = this.bcR.optString("lineBreak");
        }
    }

    public void fY(String str) {
        this.text = str;
    }
}
