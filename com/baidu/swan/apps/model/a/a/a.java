package com.baidu.swan.apps.model.a.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.swan.apps.an.z;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.model.a {
    public JSONObject aEB;
    public int aXl;
    public String aXm;
    private String aXn;
    public String aXo;
    public String aXp;
    public String aXq;
    public b aXr;
    public boolean aXs = false;
    public String callback;
    public boolean hidden;
    public String id;

    public a(String str, String str2) {
        this.aXn = "id";
        this.aXo = "unknown";
        if (!TextUtils.isEmpty(str)) {
            this.aXn = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.aXo = str2;
        }
    }

    public a Mr() {
        a aVar = new a(this.aXn, this.aXo);
        aVar.aXn = this.aXn;
        aVar.aXo = this.aXo;
        aVar.aXp = this.aXp;
        aVar.id = this.id;
        aVar.aXq = this.aXq;
        aVar.hidden = this.hidden;
        aVar.aXs = this.aXs;
        aVar.callback = this.callback;
        if (this.aXr != null) {
            aVar.aXr = new b(this.aXr);
        }
        aVar.aEB = this.aEB;
        aVar.aXl = this.aXl;
        aVar.aXm = this.aXm;
        return aVar;
    }

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aXn);
            this.aXp = jSONObject.optString("slaveId");
            this.aXq = jSONObject.optString("parentId");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.aXs = TextUtils.equals(jSONObject.optString("gesture"), "1");
            this.callback = jSONObject.optString("cb");
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aXr = new b();
                this.aXr.dI(z.S(a(optJSONObject, "left", 0.0f)));
                this.aXr.dJ(z.S(a(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
                this.aXr.setWidth(z.S(a(optJSONObject, "width", 0.0f)));
                this.aXr.setHeight(z.S(a(optJSONObject, "height", 0.0f)));
            }
            this.aEB = jSONObject.optJSONObject("style");
            this.aXl = jSONObject.optInt("scrollTop");
            if (this.aEB != null) {
                this.aXm = this.aEB.optString("overflowY");
            }
        }
    }

    public void a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aXn, aVar.id);
            this.aXp = jSONObject.optString("slaveId", aVar.aXp);
            this.aXq = jSONObject.optString("parentId", aVar.aXq);
            this.hidden = jSONObject.optBoolean("hide", aVar.hidden);
            this.callback = jSONObject.optString("cb", aVar.callback);
            this.aXs = TextUtils.equals(jSONObject.optString("gesture", aVar.aXs ? "1" : "0"), "1");
            this.aXr = aVar.aXr;
            if (this.aXr == null) {
                this.aXr = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aXr.dI(z.S(a(optJSONObject, "left", this.aXr.left)));
                this.aXr.dJ(z.S(a(optJSONObject, VerticalTranslateLayout.TOP, this.aXr.top)));
                this.aXr.setWidth(z.S(a(optJSONObject, "width", this.aXr.width)));
                this.aXr.setHeight(z.S(a(optJSONObject, "height", this.aXr.height)));
            }
            this.aEB = jSONObject.optJSONObject("style");
            if (this.aEB == null) {
                this.aEB = aVar.aEB;
            }
            this.aXl = jSONObject.optInt("scrollTop", aVar.aXl);
            if (this.aEB != null) {
                this.aXm = this.aEB.optString("overflowY", aVar.aXm);
            }
        }
    }

    public FrameLayout.LayoutParams Ms() {
        int width = this.aXr != null ? this.aXr.getWidth() : -1;
        int height = this.aXr != null ? this.aXr.getHeight() : -1;
        int left = this.aXr != null ? this.aXr.getLeft() : 0;
        int Mu = this.aXr != null ? this.aXr.Mu() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, Mu, 0, 0);
        return layoutParams;
    }

    public void a(b bVar) {
        this.aXr = bVar;
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.fG(63);
                return;
            }
            if (this.aXr != null && !this.aXr.equals(aVar.aXr)) {
                aVar2.fG(1);
            }
            if (aVar.hidden != this.hidden) {
                aVar2.fG(8);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aXp) || TextUtils.isEmpty(this.id) || this.aXr == null || !this.aXr.isValid()) ? false : true;
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
