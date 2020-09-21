package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean ccD;
    public String ccE;
    public String ccF;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.ccD = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.ccE = "";
        this.ccF = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            adD();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aK(JSONObject jSONObject) {
        super.aK(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        adD();
    }

    private void adD() {
        if (this.ccK != null) {
            try {
                this.textColor = Color.parseColor(this.ccK.optString("color"));
                this.ccD = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.ccD = false;
            }
            this.fontSize = this.ccK.optDouble("fontSize", 0.0d);
            this.lineSpace = ah.H((float) this.ccK.optDouble("lineSpace", 0.0d));
            this.textAlign = this.ccK.optString("textAlign");
            this.fontWeight = this.ccK.optString("fontWeight");
            this.ccE = this.ccK.optString("whiteSpace");
            this.ccF = this.ccK.optString("lineBreak");
        }
    }

    public void kP(String str) {
        this.text = str;
    }
}
