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
/* loaded from: classes25.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public int backgroundColor;
    public float bcD;
    public int borderColor;
    public int borderWidth;
    @Nullable
    public JSONObject cIG;
    public int cIH;
    public JSONArray cII;
    @Nullable
    public JSONObject cIJ;
    public String cIK;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.bcD = -1.0f;
        this.cIK = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cIG != null) {
            try {
                bVar.cIG = new JSONObject(this.cIG.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.cII != null) {
            try {
                bVar.cII = new JSONArray(this.cII.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.cIJ != null) {
            try {
                bVar.cIJ = new JSONObject(this.cIJ.toString());
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
            this.cIG = jSONObject.optJSONObject("style");
            this.cIJ = jSONObject.optJSONObject("transition");
            ani();
            anm();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void aW(JSONObject jSONObject) {
        super.aW(jSONObject);
        ani();
        anm();
    }

    private void ani() {
        if (this.cIG != null) {
            try {
                this.backgroundColor = Color.parseColor(this.cIG.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.cIG.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.cIG.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.cIH = ah.M(this.cIG.optInt("borderRadius"));
            this.bcD = v.getFloat(this.cIG, "opacity", -1.0f);
            this.cII = this.cIG.optJSONArray("padding");
        }
    }

    private void anm() {
        if (this.cIJ != null) {
            try {
                this.duration = Long.parseLong(this.cIJ.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.cIK = this.cIJ.optString("easing");
        }
    }
}
