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
    public JSONObject bhU;
    public int bhV;
    public JSONArray bhW;
    @Nullable
    public JSONObject bhX;
    public String bhY;
    public int borderColor;
    public int borderWidth;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.bhY = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bhU != null) {
            try {
                bVar.bhU = new JSONObject(this.bhU.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.bhW != null) {
            try {
                bVar.bhW = new JSONArray(this.bhW.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.bhX != null) {
            try {
                bVar.bhX = new JSONObject(this.bhX.toString());
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
            this.bhU = jSONObject.optJSONObject("style");
            this.bhX = jSONObject.optJSONObject("transition");
            KA();
            KE();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        KA();
        KE();
    }

    private void KA() {
        if (this.bhU != null) {
            try {
                this.backgroundColor = Color.parseColor(this.bhU.optString("bgColor"));
            } catch (Exception e) {
                c.w("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.bhU.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.bhU.optString("borderColor"));
            } catch (Exception e2) {
                c.w("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.bhV = af.S(this.bhU.optInt("borderRadius"));
            this.alpha = s.getFloat(this.bhU, "opacity", -1.0f);
            this.bhW = this.bhU.optJSONArray("padding");
        }
    }

    private void KE() {
        if (this.bhX != null) {
            try {
                this.duration = Long.parseLong(this.bhX.optString("duration"));
            } catch (Exception e) {
                c.e("Component-Model-View", "duration occurs exception", e);
                this.duration = 0L;
            }
            this.bhY = this.bhX.optString("easing");
        }
    }
}
