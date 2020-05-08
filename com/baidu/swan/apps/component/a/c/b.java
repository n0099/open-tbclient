package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean bGr;
    public String bGs;
    public String bGt;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.bGr = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.bGs = "";
        this.bGt = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            Sq();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aj(JSONObject jSONObject) {
        super.aj(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        Sq();
    }

    private void Sq() {
        if (this.bGy != null) {
            try {
                this.textColor = Color.parseColor(this.bGy.optString("color"));
                this.bGr = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.bGr = false;
            }
            this.fontSize = this.bGy.optDouble("fontSize", 0.0d);
            this.lineSpace = af.C((float) this.bGy.optDouble("lineSpace", 0.0d));
            this.textAlign = this.bGy.optString("textAlign");
            this.fontWeight = this.bGy.optString("fontWeight");
            this.bGs = this.bGy.optString("whiteSpace");
            this.bGt = this.bGy.optString("lineBreak");
        }
    }

    public void hD(String str) {
        this.text = str;
    }
}
