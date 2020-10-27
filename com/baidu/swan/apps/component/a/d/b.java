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
    public JSONObject cxC;
    public int cxD;
    public JSONArray cxE;
    @Nullable
    public JSONObject cxF;
    public String cxG;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.cxG = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cxC != null) {
            try {
                bVar.cxC = new JSONObject(this.cxC.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.cxE != null) {
            try {
                bVar.cxE = new JSONArray(this.cxE.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.cxF != null) {
            try {
                bVar.cxF = new JSONObject(this.cxF.toString());
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
            this.cxC = jSONObject.optJSONObject("style");
            this.cxF = jSONObject.optJSONObject("transition");
            aii();
            aim();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void aU(JSONObject jSONObject) {
        super.aU(jSONObject);
        aii();
        aim();
    }

    private void aii() {
        if (this.cxC != null) {
            try {
                this.backgroundColor = Color.parseColor(this.cxC.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.cxC.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.cxC.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.cxD = ah.L(this.cxC.optInt("borderRadius"));
            this.alpha = v.getFloat(this.cxC, "opacity", -1.0f);
            this.cxE = this.cxC.optJSONArray("padding");
        }
    }

    private void aim() {
        if (this.cxF != null) {
            try {
                this.duration = Long.parseLong(this.cxF.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.cxG = this.cxF.optString("easing");
        }
    }
}
