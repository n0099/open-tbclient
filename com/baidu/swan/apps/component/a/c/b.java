package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean bhO;
    public String bhP;
    public String bhQ;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.bhO = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.bhP = "";
        this.bhQ = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            KA();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        KA();
    }

    private void KA() {
        if (this.bhV != null) {
            try {
                this.textColor = Color.parseColor(this.bhV.optString("color"));
                this.bhO = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.bhO = false;
            }
            this.fontSize = this.bhV.optDouble("fontSize", 0.0d);
            this.lineSpace = af.S((float) this.bhV.optDouble("lineSpace", 0.0d));
            this.textAlign = this.bhV.optString("textAlign");
            this.fontWeight = this.bhV.optString("fontWeight");
            this.bhP = this.bhV.optString("whiteSpace");
            this.bhQ = this.bhV.optString("lineBreak");
        }
    }

    public void gq(String str) {
        this.text = str;
    }
}
