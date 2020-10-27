package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean cxv;
    public String cxw;
    public String cxx;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.cxv = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.cxw = "";
        this.cxx = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            aii();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aU(JSONObject jSONObject) {
        super.aU(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        aii();
    }

    private void aii() {
        if (this.cxC != null) {
            try {
                this.textColor = Color.parseColor(this.cxC.optString("color"));
                this.cxv = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.cxv = false;
            }
            this.fontSize = this.cxC.optDouble("fontSize", 0.0d);
            this.lineSpace = ah.L((float) this.cxC.optDouble("lineSpace", 0.0d));
            this.textAlign = this.cxC.optString("textAlign");
            this.fontWeight = this.cxC.optString("fontWeight");
            this.cxw = this.cxC.optString("whiteSpace");
            this.cxx = this.cxC.optString("lineBreak");
        }
    }

    public void lU(String str) {
        this.text = str;
    }
}
