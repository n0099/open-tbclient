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
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public int backgroundColor;
    public float bem;
    public int borderColor;
    public int borderWidth;
    public int cNA;
    public JSONArray cNB;
    @Nullable
    public JSONObject cNC;
    public String cND;
    @Nullable
    public JSONObject cNz;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.bem = -1.0f;
        this.cND = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cNz != null) {
            try {
                bVar.cNz = new JSONObject(this.cNz.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.cNB != null) {
            try {
                bVar.cNB = new JSONArray(this.cNB.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.cNC != null) {
            try {
                bVar.cNC = new JSONObject(this.cNC.toString());
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
            this.cNz = jSONObject.optJSONObject("style");
            this.cNC = jSONObject.optJSONObject("transition");
            aos();
            aow();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void be(JSONObject jSONObject) {
        super.be(jSONObject);
        aos();
        aow();
    }

    private void aos() {
        if (this.cNz != null) {
            try {
                this.backgroundColor = Color.parseColor(this.cNz.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.cNz.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.cNz.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.cNA = ah.O(this.cNz.optInt("borderRadius"));
            this.bem = v.getFloat(this.cNz, "opacity", -1.0f);
            this.cNB = this.cNz.optJSONArray("padding");
        }
    }

    private void aow() {
        if (this.cNC != null) {
            try {
                this.duration = Long.parseLong(this.cNC.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.cND = this.cNC.optString("easing");
        }
    }
}
