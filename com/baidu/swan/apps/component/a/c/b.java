package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean bUP;
    public String bUQ;
    public String bUR;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.bUP = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.bUQ = "";
        this.bUR = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            WO();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aB(JSONObject jSONObject) {
        super.aB(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        WO();
    }

    private void WO() {
        if (this.bUW != null) {
            try {
                this.textColor = Color.parseColor(this.bUW.optString("color"));
                this.bUP = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.bUP = false;
            }
            this.fontSize = this.bUW.optDouble("fontSize", 0.0d);
            this.lineSpace = ai.D((float) this.bUW.optDouble("lineSpace", 0.0d));
            this.textAlign = this.bUW.optString("textAlign");
            this.fontWeight = this.bUW.optString("fontWeight");
            this.bUQ = this.bUW.optString("whiteSpace");
            this.bUR = this.bUW.optString("lineBreak");
        }
    }

    public void iV(String str) {
        this.text = str;
    }
}
