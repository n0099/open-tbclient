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
    public JSONArray bGA;
    @Nullable
    public JSONObject bGB;
    public String bGC;
    @Nullable
    public JSONObject bGy;
    public int bGz;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.bGC = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bGy != null) {
            try {
                bVar.bGy = new JSONObject(this.bGy.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.bGA != null) {
            try {
                bVar.bGA = new JSONArray(this.bGA.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.bGB != null) {
            try {
                bVar.bGB = new JSONObject(this.bGB.toString());
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
            this.bGy = jSONObject.optJSONObject("style");
            this.bGB = jSONObject.optJSONObject("transition");
            Sq();
            Su();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void aj(JSONObject jSONObject) {
        super.aj(jSONObject);
        Sq();
        Su();
    }

    private void Sq() {
        if (this.bGy != null) {
            try {
                this.backgroundColor = Color.parseColor(this.bGy.optString("bgColor"));
            } catch (Exception e) {
                c.w("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.bGy.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.bGy.optString("borderColor"));
            } catch (Exception e2) {
                c.w("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.bGz = af.C(this.bGy.optInt("borderRadius"));
            this.alpha = s.getFloat(this.bGy, "opacity", -1.0f);
            this.bGA = this.bGy.optJSONArray("padding");
        }
    }

    private void Su() {
        if (this.bGB != null) {
            try {
                this.duration = Long.parseLong(this.bGB.optString("duration"));
            } catch (Exception e) {
                c.e("Component-Model-View", "duration occurs exception", e);
                this.duration = 0L;
            }
            this.bGC = this.bGB.optString("easing");
        }
    }
}
