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
    public JSONObject bUe;
    public int bUf;
    public JSONArray bUg;
    @Nullable
    public JSONObject bUh;
    public String bUi;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.bUi = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bUe != null) {
            try {
                bVar.bUe = new JSONObject(this.bUe.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.bUg != null) {
            try {
                bVar.bUg = new JSONArray(this.bUg.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.bUh != null) {
            try {
                bVar.bUh = new JSONObject(this.bUh.toString());
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
            this.bUe = jSONObject.optJSONObject("style");
            this.bUh = jSONObject.optJSONObject("transition");
            Wh();
            Wl();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void ay(JSONObject jSONObject) {
        super.ay(jSONObject);
        Wh();
        Wl();
    }

    private void Wh() {
        if (this.bUe != null) {
            try {
                this.backgroundColor = Color.parseColor(this.bUe.optString("bgColor"));
            } catch (Exception e) {
                c.w("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.bUe.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.bUe.optString("borderColor"));
            } catch (Exception e2) {
                c.w("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.bUf = ag.D(this.bUe.optInt("borderRadius"));
            this.alpha = t.getFloat(this.bUe, "opacity", -1.0f);
            this.bUg = this.bUe.optJSONArray("padding");
        }
    }

    private void Wl() {
        if (this.bUh != null) {
            try {
                this.duration = Long.parseLong(this.bUh.optString("duration"));
            } catch (Exception e) {
                c.e("Component-Model-View", "duration occurs exception", e);
                this.duration = 0L;
            }
            this.bUi = this.bUh.optString("easing");
        }
    }
}
