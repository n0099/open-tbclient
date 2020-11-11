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
    public JSONObject cDv;
    public int cDw;
    public JSONArray cDx;
    @Nullable
    public JSONObject cDy;
    public String cDz;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.cDz = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cDv != null) {
            try {
                bVar.cDv = new JSONObject(this.cDv.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.cDx != null) {
            try {
                bVar.cDx = new JSONArray(this.cDx.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.cDy != null) {
            try {
                bVar.cDy = new JSONObject(this.cDy.toString());
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
            this.cDv = jSONObject.optJSONObject("style");
            this.cDy = jSONObject.optJSONObject("transition");
            akI();
            akM();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void ba(JSONObject jSONObject) {
        super.ba(jSONObject);
        akI();
        akM();
    }

    private void akI() {
        if (this.cDv != null) {
            try {
                this.backgroundColor = Color.parseColor(this.cDv.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.cDv.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.cDv.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.cDw = ah.N(this.cDv.optInt("borderRadius"));
            this.alpha = v.getFloat(this.cDv, "opacity", -1.0f);
            this.cDx = this.cDv.optJSONArray("padding");
        }
    }

    private void akM() {
        if (this.cDy != null) {
            try {
                this.duration = Long.parseLong(this.cDy.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.cDz = this.cDy.optString("easing");
        }
    }
}
