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
    public JSONObject caI;
    public int caJ;
    public JSONArray caK;
    @Nullable
    public JSONObject caL;
    public String caM;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.caM = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.caI != null) {
            try {
                bVar.caI = new JSONObject(this.caI.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.caK != null) {
            try {
                bVar.caK = new JSONArray(this.caK.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.caL != null) {
            try {
                bVar.caL = new JSONObject(this.caL.toString());
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
            this.caI = jSONObject.optJSONObject("style");
            this.caL = jSONObject.optJSONObject("transition");
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
        if (this.caI != null) {
            try {
                this.backgroundColor = Color.parseColor(this.caI.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.caI.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.caI.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.caJ = ah.H(this.caI.optInt("borderRadius"));
            this.alpha = v.getFloat(this.caI, "opacity", -1.0f);
            this.caK = this.caI.optJSONArray("padding");
        }
    }

    private void acY() {
        if (this.caL != null) {
            try {
                this.duration = Long.parseLong(this.caL.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.caM = this.caL.optString("easing");
        }
    }
}
