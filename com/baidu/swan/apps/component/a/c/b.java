package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean bhN;
    public String bhO;
    public String bhP;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.bhN = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.bhO = "";
        this.bhP = "";
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
        if (this.bhU != null) {
            try {
                this.textColor = Color.parseColor(this.bhU.optString("color"));
                this.bhN = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.bhN = false;
            }
            this.fontSize = this.bhU.optDouble("fontSize", 0.0d);
            this.lineSpace = af.S((float) this.bhU.optDouble("lineSpace", 0.0d));
            this.textAlign = this.bhU.optString("textAlign");
            this.fontWeight = this.bhU.optString("fontWeight");
            this.bhO = this.bhU.optString("whiteSpace");
            this.bhP = this.bhU.optString("lineBreak");
        }
    }

    public void gq(String str) {
        this.text = str;
    }
}
