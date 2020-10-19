package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean coT;
    public String coU;
    public String coV;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.coT = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.coU = "";
        this.coV = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            ago();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aR(JSONObject jSONObject) {
        super.aR(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        ago();
    }

    private void ago() {
        if (this.cpa != null) {
            try {
                this.textColor = Color.parseColor(this.cpa.optString("color"));
                this.coT = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.coT = false;
            }
            this.fontSize = this.cpa.optDouble("fontSize", 0.0d);
            this.lineSpace = ah.J((float) this.cpa.optDouble("lineSpace", 0.0d));
            this.textAlign = this.cpa.optString("textAlign");
            this.fontWeight = this.cpa.optString("fontWeight");
            this.coU = this.cpa.optString("whiteSpace");
            this.coV = this.cpa.optString("lineBreak");
        }
    }

    public void lB(String str) {
        this.text = str;
    }
}
