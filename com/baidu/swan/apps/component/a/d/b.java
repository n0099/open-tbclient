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
    public float aZx;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;
    @Nullable
    public JSONObject cIN;
    public int cIO;
    public JSONArray cIP;
    @Nullable
    public JSONObject cIQ;
    public String cIR;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.aZx = -1.0f;
        this.cIR = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cIN != null) {
            try {
                bVar.cIN = new JSONObject(this.cIN.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.cIP != null) {
            try {
                bVar.cIP = new JSONArray(this.cIP.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.cIQ != null) {
            try {
                bVar.cIQ = new JSONObject(this.cIQ.toString());
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
            this.cIN = jSONObject.optJSONObject("style");
            this.cIQ = jSONObject.optJSONObject("transition");
            aky();
            akC();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void be(JSONObject jSONObject) {
        super.be(jSONObject);
        aky();
        akC();
    }

    private void aky() {
        if (this.cIN != null) {
            try {
                this.backgroundColor = Color.parseColor(this.cIN.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.cIN.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.cIN.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.cIO = ah.O(this.cIN.optInt("borderRadius"));
            this.aZx = v.getFloat(this.cIN, "opacity", -1.0f);
            this.cIP = this.cIN.optJSONArray("padding");
        }
    }

    private void akC() {
        if (this.cIQ != null) {
            try {
                this.duration = Long.parseLong(this.cIQ.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.cIR = this.cIQ.optString("easing");
        }
    }
}
