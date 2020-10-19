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
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public float alpha;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;
    @Nullable
    public JSONObject cpa;
    public int cpb;
    public JSONArray cpc;
    @Nullable
    public JSONObject cpd;
    public String cpe;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.cpe = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cpa != null) {
            try {
                bVar.cpa = new JSONObject(this.cpa.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.cpc != null) {
            try {
                bVar.cpc = new JSONArray(this.cpc.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.cpd != null) {
            try {
                bVar.cpd = new JSONObject(this.cpd.toString());
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
            this.cpa = jSONObject.optJSONObject("style");
            this.cpd = jSONObject.optJSONObject("transition");
            ago();
            ags();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void aR(JSONObject jSONObject) {
        super.aR(jSONObject);
        ago();
        ags();
    }

    private void ago() {
        if (this.cpa != null) {
            try {
                this.backgroundColor = Color.parseColor(this.cpa.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.cpa.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.cpa.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.cpb = ah.J(this.cpa.optInt("borderRadius"));
            this.alpha = v.getFloat(this.cpa, "opacity", -1.0f);
            this.cpc = this.cpa.optJSONArray("padding");
        }
    }

    private void ags() {
        if (this.cpd != null) {
            try {
                this.duration = Long.parseLong(this.cpd.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.cpe = this.cpd.optString("easing");
        }
    }
}
