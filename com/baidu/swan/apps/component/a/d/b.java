package com.baidu.swan.apps.component.a.d;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.v;
import com.baidu.swan.apps.console.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public float alpha;
    @Nullable
    public JSONObject bUW;
    public int bUX;
    public JSONArray bUY;
    @Nullable
    public JSONObject bUZ;
    public String bVa;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.bVa = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bUW != null) {
            try {
                bVar.bUW = new JSONObject(this.bUW.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.bUY != null) {
            try {
                bVar.bUY = new JSONArray(this.bUY.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.bUZ != null) {
            try {
                bVar.bUZ = new JSONObject(this.bUZ.toString());
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
            this.bUW = jSONObject.optJSONObject("style");
            this.bUZ = jSONObject.optJSONObject("transition");
            WO();
            WS();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void aB(JSONObject jSONObject) {
        super.aB(jSONObject);
        WO();
        WS();
    }

    private void WO() {
        if (this.bUW != null) {
            try {
                this.backgroundColor = Color.parseColor(this.bUW.optString("bgColor"));
            } catch (Exception e) {
                c.d("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.bUW.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.bUW.optString("borderColor"));
            } catch (Exception e2) {
                c.d("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.bUX = ai.D(this.bUW.optInt("borderRadius"));
            this.alpha = v.getFloat(this.bUW, "opacity", -1.0f);
            this.bUY = this.bUW.optJSONArray("padding");
        }
    }

    private void WS() {
        if (this.bUZ != null) {
            try {
                this.duration = Long.parseLong(this.bUZ.optString("duration"));
            } catch (Exception e) {
                c.d("Component-Model-View", "duration occurs exception");
                this.duration = 0L;
            }
            this.bVa = this.bUZ.optString("easing");
        }
    }
}
