package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean cDo;
    public String cDp;
    public String cDq;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.cDo = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.cDp = "";
        this.cDq = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            akI();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void ba(JSONObject jSONObject) {
        super.ba(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        akI();
    }

    private void akI() {
        if (this.cDv != null) {
            try {
                this.textColor = Color.parseColor(this.cDv.optString("color"));
                this.cDo = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.cDo = false;
            }
            this.fontSize = this.cDv.optDouble("fontSize", 0.0d);
            this.lineSpace = ah.N((float) this.cDv.optDouble("lineSpace", 0.0d));
            this.textAlign = this.cDv.optString("textAlign");
            this.fontWeight = this.cDv.optString("fontWeight");
            this.cDp = this.cDv.optString("whiteSpace");
            this.cDq = this.cDv.optString("lineBreak");
        }
    }

    public void mj(String str) {
        this.text = str;
    }
}
