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
    public int backgroundColor;
    @Nullable
    public JSONObject bik;
    public int bil;
    public JSONArray bim;
    @Nullable
    public JSONObject bin;
    public String bip;
    public int borderColor;
    public int borderWidth;
    public long duration;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
        this.alpha = -1.0f;
        this.bip = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bik != null) {
            try {
                bVar.bik = new JSONObject(this.bik.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.bim != null) {
            try {
                bVar.bim = new JSONArray(this.bim.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.bin != null) {
            try {
                bVar.bin = new JSONObject(this.bin.toString());
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
            this.bik = jSONObject.optJSONObject("style");
            this.bin = jSONObject.optJSONObject("transition");
            KD();
            KH();
        }
    }

    @Override // com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        KD();
        KH();
    }

    private void KD() {
        if (this.bik != null) {
            try {
                this.backgroundColor = Color.parseColor(this.bik.optString("bgColor"));
            } catch (Exception e) {
                c.w("Component-Model-View", "backgroundColor occurs exception");
                this.backgroundColor = 0;
            }
            this.borderWidth = this.bik.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.bik.optString("borderColor"));
            } catch (Exception e2) {
                c.w("Component-Model-View", "borderColor occurs exception");
                this.borderColor = 0;
            }
            this.bil = af.S(this.bik.optInt("borderRadius"));
            this.alpha = s.getFloat(this.bik, "opacity", -1.0f);
            this.bim = this.bik.optJSONArray("padding");
        }
    }

    private void KH() {
        if (this.bin != null) {
            try {
                this.duration = Long.parseLong(this.bin.optString("duration"));
            } catch (Exception e) {
                c.e("Component-Model-View", "duration occurs exception", e);
                this.duration = 0L;
            }
            this.bip = this.bin.optString("easing");
        }
    }
}
