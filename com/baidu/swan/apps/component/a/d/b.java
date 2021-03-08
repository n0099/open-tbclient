package com.baidu.swan.apps.component.a.d;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.v;
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
    public JSONObject cMB;
    public int cMC;
    public JSONArray cMD;
    @Nullable
    public JSONObject cME;
    public String cMF;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.cMF = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cMB != null) {
            try {
                bVar.cMB = new JSONObject(this.cMB.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.cMD != null) {
            try {
                bVar.cMD = new JSONArray(this.cMD.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.cME != null) {
            try {
                bVar.cME = new JSONObject(this.cME.toString());
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
            this.cMB = jSONObject.optJSONObject("style");
            this.cME = jSONObject.optJSONObject("transition");
            akZ();
            ald();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void bd(JSONObject jSONObject) {
        super.bd(jSONObject);
        akZ();
        ald();
    }

    private void akZ() {
        if (this.cMB != null) {
            try {
                this.backgroundColor = Color.parseColor(this.cMB.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.cMB.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.cMB.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.cMC = ah.T(this.cMB.optInt("borderRadius"));
            this.alpha = v.getFloat(this.cMB, "opacity", -1.0f);
            this.cMD = this.cMB.optJSONArray("padding");
        }
    }

    private void ald() {
        if (this.cME != null) {
            try {
                this.duration = Long.parseLong(this.cME.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.cMF = this.cME.optString("easing");
        }
    }
}
