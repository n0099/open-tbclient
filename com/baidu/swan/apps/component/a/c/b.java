package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean bPj;
    public String bPk;
    public String bPl;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.bPj = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.bPk = "";
        this.bPl = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            Vb();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void ar(JSONObject jSONObject) {
        super.ar(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        Vb();
    }

    private void Vb() {
        if (this.bPq != null) {
            try {
                this.textColor = Color.parseColor(this.bPq.optString("color"));
                this.bPj = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.bPj = false;
            }
            this.fontSize = this.bPq.optDouble("fontSize", 0.0d);
            this.lineSpace = ag.B((float) this.bPq.optDouble("lineSpace", 0.0d));
            this.textAlign = this.bPq.optString("textAlign");
            this.fontWeight = this.bPq.optString("fontWeight");
            this.bPk = this.bPq.optString("whiteSpace");
            this.bPl = this.bPq.optString("lineBreak");
        }
    }

    public void iD(String str) {
        this.text = str;
    }
}
