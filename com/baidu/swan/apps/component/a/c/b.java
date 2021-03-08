package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean cMt;
    public int cMu;
    public String cMv;
    public String cMw;
    public double fontSize;
    public String fontWeight;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.cMt = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.cMv = "";
        this.cMw = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            akZ();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void bd(JSONObject jSONObject) {
        super.bd(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        akZ();
    }

    private void akZ() {
        if (this.cMB != null) {
            try {
                this.textColor = Color.parseColor(this.cMB.optString("color"));
                this.cMt = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.cMt = false;
            }
            this.fontSize = this.cMB.optDouble("fontSize", 0.0d);
            this.cMu = ah.T((float) this.cMB.optDouble("lineSpace", 0.0d));
            this.textAlign = this.cMB.optString("textAlign");
            this.fontWeight = this.cMB.optString("fontWeight");
            this.cMv = this.cMB.optString("whiteSpace");
            this.cMw = this.cMB.optString("lineBreak");
        }
    }

    public void lR(String str) {
        this.text = str;
    }
}
