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
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public float alpha;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;
    @Nullable
    public JSONObject ccK;
    public int ccL;
    public JSONArray ccM;
    @Nullable
    public JSONObject ccN;
    public String ccO;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.ccO = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.ccK != null) {
            try {
                bVar.ccK = new JSONObject(this.ccK.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.ccM != null) {
            try {
                bVar.ccM = new JSONArray(this.ccM.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.ccN != null) {
            try {
                bVar.ccN = new JSONObject(this.ccN.toString());
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
            this.ccK = jSONObject.optJSONObject("style");
            this.ccN = jSONObject.optJSONObject("transition");
            adD();
            adH();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void aK(JSONObject jSONObject) {
        super.aK(jSONObject);
        adD();
        adH();
    }

    private void adD() {
        if (this.ccK != null) {
            try {
                this.backgroundColor = Color.parseColor(this.ccK.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.ccK.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.ccK.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.ccL = ah.H(this.ccK.optInt("borderRadius"));
            this.alpha = v.getFloat(this.ccK, "opacity", -1.0f);
            this.ccM = this.ccK.optJSONArray("padding");
        }
    }

    private void adH() {
        if (this.ccN != null) {
            try {
                this.duration = Long.parseLong(this.ccN.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.ccO = this.ccN.optString("easing");
        }
    }
}
