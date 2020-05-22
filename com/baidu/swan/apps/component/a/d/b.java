package com.baidu.swan.apps.component.a.d;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.t;
import com.baidu.swan.apps.console.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public float alpha;
    @Nullable
    public JSONObject bPq;
    public int bPr;
    public JSONArray bPs;
    @Nullable
    public JSONObject bPt;
    public String bPu;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.bPu = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bPq != null) {
            try {
                bVar.bPq = new JSONObject(this.bPq.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.bPs != null) {
            try {
                bVar.bPs = new JSONArray(this.bPs.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.bPt != null) {
            try {
                bVar.bPt = new JSONObject(this.bPt.toString());
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
            this.bPq = jSONObject.optJSONObject("style");
            this.bPt = jSONObject.optJSONObject("transition");
            Vb();
            Vf();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void ar(JSONObject jSONObject) {
        super.ar(jSONObject);
        Vb();
        Vf();
    }

    private void Vb() {
        if (this.bPq != null) {
            try {
                this.backgroundColor = Color.parseColor(this.bPq.optString("bgColor"));
            } catch (Exception e) {
                c.w("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.bPq.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.bPq.optString("borderColor"));
            } catch (Exception e2) {
                c.w("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.bPr = ag.B(this.bPq.optInt("borderRadius"));
            this.alpha = t.getFloat(this.bPq, "opacity", -1.0f);
            this.bPs = this.bPq.optJSONArray("padding");
        }
    }

    private void Vf() {
        if (this.bPt != null) {
            try {
                this.duration = Long.parseLong(this.bPt.optString("duration"));
            } catch (Exception e) {
                c.e("Component-Model-View", "duration occurs exception", e);
                this.duration = 0L;
            }
            this.bPu = this.bPt.optString("easing");
        }
    }
}
