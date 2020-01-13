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
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.component.b.b {
    public float alpha;
    public int backgroundColor;
    @Nullable
    public JSONObject bdG;
    public int bdH;
    public JSONArray bdI;
    @Nullable
    public JSONObject bdJ;
    public String bdK;
    public int borderColor;
    public int borderWidth;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.bdK = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bdG != null) {
            try {
                bVar.bdG = new JSONObject(this.bdG.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.bdI != null) {
            try {
                bVar.bdI = new JSONArray(this.bdI.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.bdJ != null) {
            try {
                bVar.bdJ = new JSONObject(this.bdJ.toString());
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
            this.bdG = jSONObject.optJSONObject("style");
            this.bdJ = jSONObject.optJSONObject("transition");
            Ij();
            In();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        Ij();
        In();
    }

    private void Ij() {
        if (this.bdG != null) {
            try {
                this.backgroundColor = Color.parseColor(this.bdG.optString("bgColor"));
            } catch (Exception e) {
                c.w("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.bdG.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.bdG.optString("borderColor"));
            } catch (Exception e2) {
                c.w("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.bdH = af.S(this.bdG.optInt("borderRadius"));
            this.alpha = s.getFloat(this.bdG, "opacity", -1.0f);
            this.bdI = this.bdG.optJSONArray("padding");
        }
    }

    private void In() {
        if (this.bdJ != null) {
            try {
                this.duration = Long.parseLong(this.bdJ.optString("duration"));
            } catch (Exception e) {
                c.e("Component-Model-View", "duration occurs exception", e);
                this.duration = 0L;
            }
            this.bdK = this.bdJ.optString("easing");
        }
    }
}
