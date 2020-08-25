package com.baidu.swan.apps.component.a.d;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.console.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public float alpha;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;
    @Nullable
    public JSONObject caE;
    public int caF;
    public JSONArray caG;
    @Nullable
    public JSONObject caH;
    public String caI;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.caI = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.caE != null) {
            try {
                bVar.caE = new JSONObject(this.caE.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.caG != null) {
            try {
                bVar.caG = new JSONArray(this.caG.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.caH != null) {
            try {
                bVar.caH = new JSONObject(this.caH.toString());
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
            this.caE = jSONObject.optJSONObject("style");
            this.caH = jSONObject.optJSONObject("transition");
            acU();
            acY();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void aH(JSONObject jSONObject) {
        super.aH(jSONObject);
        acU();
        acY();
    }

    private void acU() {
        if (this.caE != null) {
            try {
                this.backgroundColor = Color.parseColor(this.caE.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.caE.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.caE.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.caF = ah.H(this.caE.optInt("borderRadius"));
            this.alpha = v.getFloat(this.caE, "opacity", -1.0f);
            this.caG = this.caE.optJSONArray("padding");
        }
    }

    private void acY() {
        if (this.caH != null) {
            try {
                this.duration = Long.parseLong(this.caH.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.caI = this.caH.optString("easing");
        }
    }
}
