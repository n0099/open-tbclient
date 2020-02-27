package com.baidu.swan.apps.component.a.d;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.console.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public float alpha;
    public int backgroundColor;
    @Nullable
    public JSONObject bhT;
    public int bhU;
    public JSONArray bhV;
    @Nullable
    public JSONObject bhW;
    public String bhX;
    public int borderColor;
    public int borderWidth;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.bhX = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bhT != null) {
            try {
                bVar.bhT = new JSONObject(this.bhT.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.bhV != null) {
            try {
                bVar.bhV = new JSONArray(this.bhV.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.bhW != null) {
            try {
                bVar.bhW = new JSONObject(this.bhW.toString());
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
            this.bhT = jSONObject.optJSONObject("style");
            this.bhW = jSONObject.optJSONObject("transition");
            Ky();
            KC();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        Ky();
        KC();
    }

    private void Ky() {
        if (this.bhT != null) {
            try {
                this.backgroundColor = Color.parseColor(this.bhT.optString("bgColor"));
            } catch (Exception e) {
                c.w("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.bhT.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.bhT.optString("borderColor"));
            } catch (Exception e2) {
                c.w("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.bhU = af.S(this.bhT.optInt("borderRadius"));
            this.alpha = s.getFloat(this.bhT, "opacity", -1.0f);
            this.bhV = this.bhT.optJSONArray("padding");
        }
    }

    private void KC() {
        if (this.bhW != null) {
            try {
                this.duration = Long.parseLong(this.bhW.optString("duration"));
            } catch (Exception e) {
                c.e("Component-Model-View", "duration occurs exception", e);
                this.duration = 0L;
            }
            this.bhX = this.bhW.optString("easing");
        }
    }
}
