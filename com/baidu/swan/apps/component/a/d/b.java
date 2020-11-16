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
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public float alpha;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;
    @Nullable
    public JSONObject cBL;
    public int cBM;
    public JSONArray cBN;
    @Nullable
    public JSONObject cBO;
    public String cBP;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.cBP = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cBL != null) {
            try {
                bVar.cBL = new JSONObject(this.cBL.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.cBN != null) {
            try {
                bVar.cBN = new JSONArray(this.cBN.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.cBO != null) {
            try {
                bVar.cBO = new JSONObject(this.cBO.toString());
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
            this.cBL = jSONObject.optJSONObject("style");
            this.cBO = jSONObject.optJSONObject("transition");
            aka();
            ake();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void aU(JSONObject jSONObject) {
        super.aU(jSONObject);
        aka();
        ake();
    }

    private void aka() {
        if (this.cBL != null) {
            try {
                this.backgroundColor = Color.parseColor(this.cBL.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.cBL.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.cBL.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.cBM = ah.M(this.cBL.optInt("borderRadius"));
            this.alpha = v.getFloat(this.cBL, "opacity", -1.0f);
            this.cBN = this.cBL.optJSONArray("padding");
        }
    }

    private void ake() {
        if (this.cBO != null) {
            try {
                this.duration = Long.parseLong(this.cBO.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.cBP = this.cBO.optString("easing");
        }
    }
}
