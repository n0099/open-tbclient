package com.baidu.swan.apps.component.a.d;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.console.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public float alpha;
    @Nullable
    public JSONObject bGt;
    public int bGu;
    public JSONArray bGv;
    @Nullable
    public JSONObject bGw;
    public String bGx;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.bGx = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bGt != null) {
            try {
                bVar.bGt = new JSONObject(this.bGt.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.bGv != null) {
            try {
                bVar.bGv = new JSONArray(this.bGv.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.bGw != null) {
            try {
                bVar.bGw = new JSONObject(this.bGw.toString());
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
            this.bGt = jSONObject.optJSONObject("style");
            this.bGw = jSONObject.optJSONObject("transition");
            Sr();
            Sv();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void aj(JSONObject jSONObject) {
        super.aj(jSONObject);
        Sr();
        Sv();
    }

    private void Sr() {
        if (this.bGt != null) {
            try {
                this.backgroundColor = Color.parseColor(this.bGt.optString("bgColor"));
            } catch (Exception e) {
                c.w("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.bGt.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.bGt.optString("borderColor"));
            } catch (Exception e2) {
                c.w("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.bGu = af.C(this.bGt.optInt("borderRadius"));
            this.alpha = s.getFloat(this.bGt, "opacity", -1.0f);
            this.bGv = this.bGt.optJSONArray("padding");
        }
    }

    private void Sv() {
        if (this.bGw != null) {
            try {
                this.duration = Long.parseLong(this.bGw.optString("duration"));
            } catch (Exception e) {
                c.e("Component-Model-View", "duration occurs exception", e);
                this.duration = 0L;
            }
            this.bGx = this.bGw.optString("easing");
        }
    }
}
