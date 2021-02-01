package com.baidu.swan.apps.component.a.d;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.console.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public float alpha;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;
    @Nullable
    public JSONObject cLb;
    public int cLc;
    public JSONArray cLd;
    @Nullable
    public JSONObject cLe;
    public String cLf;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.cLf = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cLb != null) {
            try {
                bVar.cLb = new JSONObject(this.cLb.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.cLd != null) {
            try {
                bVar.cLd = new JSONArray(this.cLd.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.cLe != null) {
            try {
                bVar.cLe = new JSONObject(this.cLe.toString());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cLb = jSONObject.optJSONObject("style");
            this.cLe = jSONObject.optJSONObject("transition");
            akW();
            ala();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void bb(JSONObject jSONObject) {
        super.bb(jSONObject);
        akW();
        ala();
    }

    private void akW() {
        if (this.cLb != null) {
            try {
                this.backgroundColor = Color.parseColor(this.cLb.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.cLb.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.cLb.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.cLc = ah.P(this.cLb.optInt("borderRadius"));
            this.alpha = v.getFloat(this.cLb, "opacity", -1.0f);
            this.cLd = this.cLb.optJSONArray("padding");
        }
    }

    private void ala() {
        if (this.cLe != null) {
            try {
                this.duration = Long.parseLong(this.cLe.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.cLf = this.cLe.optString("easing");
        }
    }
}
