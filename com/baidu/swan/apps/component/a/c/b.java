package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public String bdA;
    public String bdB;
    public boolean bdz;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.bdz = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.bdA = "";
        this.bdB = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            Ij();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        Ij();
    }

    private void Ij() {
        if (this.bdG != null) {
            try {
                this.textColor = Color.parseColor(this.bdG.optString("color"));
                this.bdz = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.bdz = false;
            }
            this.fontSize = this.bdG.optDouble("fontSize", 0.0d);
            this.lineSpace = af.S((float) this.bdG.optDouble("lineSpace", 0.0d));
            this.textAlign = this.bdG.optString("textAlign");
            this.fontWeight = this.bdG.optString("fontWeight");
            this.bdA = this.bdG.optString("whiteSpace");
            this.bdB = this.bdG.optString("lineBreak");
        }
    }

    public void gb(String str) {
        this.text = str;
    }
}
