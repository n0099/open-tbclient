package com.baidu.swan.apps.component.a.c;

import android.graphics.Color;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public boolean bTX;
    public String bTY;
    public String bTZ;
    public double fontSize;
    public String fontWeight;
    public int lineSpace;
    public String text;
    public String textAlign;
    public int textColor;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.text = "";
        this.bTX = false;
        this.textAlign = "";
        this.fontWeight = "";
        this.bTY = "";
        this.bTZ = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("text");
            Wh();
        }
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void ay(JSONObject jSONObject) {
        super.ay(jSONObject);
        this.text = jSONObject.optString("text", this.text);
        Wh();
    }

    private void Wh() {
        if (this.bUe != null) {
            try {
                this.textColor = Color.parseColor(this.bUe.optString("color"));
                this.bTX = true;
            } catch (Exception e) {
                c.w("Component-Model-TextView", "text color occurs exception");
                this.bTX = false;
            }
            this.fontSize = this.bUe.optDouble("fontSize", 0.0d);
            this.lineSpace = ag.D((float) this.bUe.optDouble("lineSpace", 0.0d));
            this.textAlign = this.bUe.optString("textAlign");
            this.fontWeight = this.bUe.optString("fontWeight");
            this.bTY = this.bUe.optString("whiteSpace");
            this.bTZ = this.bUe.optString("lineBreak");
        }
    }

    public void iL(String str) {
        this.text = str;
    }
}
