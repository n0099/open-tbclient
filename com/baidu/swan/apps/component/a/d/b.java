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
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public int backgroundColor;
    @Nullable
    public JSONObject bcR;
    public int bcS;
    public JSONArray bcT;
    public float bcU;
    @Nullable
    public JSONObject bcV;
    public String bcW;
    public int borderColor;
    public int borderWidth;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.bcU = -1.0f;
        this.bcW = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bcR != null) {
            try {
                bVar.bcR = new JSONObject(this.bcR.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.bcT != null) {
            try {
                bVar.bcT = new JSONArray(this.bcT.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.bcV != null) {
            try {
                bVar.bcV = new JSONObject(this.bcV.toString());
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
            this.bcR = jSONObject.optJSONObject("style");
            this.bcV = jSONObject.optJSONObject("transition");
            HN();
            HR();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        HN();
        HR();
    }

    private void HN() {
        if (this.bcR != null) {
            try {
                this.backgroundColor = Color.parseColor(this.bcR.optString("bgColor"));
            } catch (Exception e) {
                c.w("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.bcR.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.bcR.optString("borderColor"));
            } catch (Exception e2) {
                c.w("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.bcS = af.T(this.bcR.optInt("borderRadius"));
            this.bcU = s.getFloat(this.bcR, "opacity", -1.0f);
            this.bcT = this.bcR.optJSONArray("padding");
        }
    }

    private void HR() {
        if (this.bcV != null) {
            try {
                this.duration = Long.parseLong(this.bcV.optString("duration"));
            } catch (Exception e) {
                c.e("Component-Model-View", "duration occurs exception", e);
                this.duration = 0L;
            }
            this.bcW = this.bcV.optString("easing");
        }
    }
}
