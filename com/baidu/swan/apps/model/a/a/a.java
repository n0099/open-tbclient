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
    public JSONObject aET;
    public int aXD;
    public String aXE;
    private String aXF;
    public String aXG;
    public String aXH;
    public String aXI;
    public b aXJ;
    public boolean aXK = false;
    public String callback;
    public boolean hidden;
    public String id;

    public a(String str, String str2) {
        this.aXF = "id";
        this.aXG = "unknown";
        if (!TextUtils.isEmpty(str)) {
            this.aXF = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.aXG = str2;
        }
    }

    public a Mq() {
        a aVar = new a(this.aXF, this.aXG);
        aVar.aXF = this.aXF;
        aVar.aXG = this.aXG;
        aVar.aXH = this.aXH;
        aVar.id = this.id;
        aVar.aXI = this.aXI;
        aVar.hidden = this.hidden;
        aVar.aXK = this.aXK;
        aVar.callback = this.callback;
        if (this.aXJ != null) {
            aVar.aXJ = new b(this.aXJ);
        }
        aVar.aET = this.aET;
        aVar.aXD = this.aXD;
        aVar.aXE = this.aXE;
        return aVar;
    }

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aXF);
            this.aXH = jSONObject.optString("slaveId");
            this.aXI = jSONObject.optString("parentId");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.aXK = TextUtils.equals(jSONObject.optString("gesture"), "1");
            this.callback = jSONObject.optString("cb");
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aXJ = new b();
                this.aXJ.dI(z.S(a(optJSONObject, "left", 0.0f)));
                this.aXJ.dJ(z.S(a(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
                this.aXJ.setWidth(z.S(a(optJSONObject, "width", 0.0f)));
                this.aXJ.setHeight(z.S(a(optJSONObject, "height", 0.0f)));
            }
            this.aET = jSONObject.optJSONObject("style");
            this.aXD = jSONObject.optInt("scrollTop");
            if (this.aET != null) {
                this.aXE = this.aET.optString("overflowY");
            }
        }
    }

    public void a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aXF, aVar.id);
            this.aXH = jSONObject.optString("slaveId", aVar.aXH);
            this.aXI = jSONObject.optString("parentId", aVar.aXI);
            this.hidden = jSONObject.optBoolean("hide", aVar.hidden);
            this.callback = jSONObject.optString("cb", aVar.callback);
            this.aXK = TextUtils.equals(jSONObject.optString("gesture", aVar.aXK ? "1" : "0"), "1");
            this.aXJ = aVar.aXJ;
            if (this.aXJ == null) {
                this.aXJ = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aXJ.dI(z.S(a(optJSONObject, "left", this.aXJ.left)));
                this.aXJ.dJ(z.S(a(optJSONObject, VerticalTranslateLayout.TOP, this.aXJ.top)));
                this.aXJ.setWidth(z.S(a(optJSONObject, "width", this.aXJ.width)));
                this.aXJ.setHeight(z.S(a(optJSONObject, "height", this.aXJ.height)));
            }
            this.aET = jSONObject.optJSONObject("style");
            if (this.aET == null) {
                this.aET = aVar.aET;
            }
            this.aXD = jSONObject.optInt("scrollTop", aVar.aXD);
            if (this.aET != null) {
                this.aXE = this.aET.optString("overflowY", aVar.aXE);
            }
        }
    }

    public FrameLayout.LayoutParams Mr() {
        int width = this.aXJ != null ? this.aXJ.getWidth() : -1;
        int height = this.aXJ != null ? this.aXJ.getHeight() : -1;
        int left = this.aXJ != null ? this.aXJ.getLeft() : 0;
        int Mt = this.aXJ != null ? this.aXJ.Mt() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, Mt, 0, 0);
        return layoutParams;
    }

    public void a(b bVar) {
        this.aXJ = bVar;
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.fH(63);
                return;
            }
            if (this.aXJ != null && !this.aXJ.equals(aVar.aXJ)) {
                aVar2.fH(1);
            }
            if (aVar.hidden != this.hidden) {
                aVar2.fH(8);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aXH) || TextUtils.isEmpty(this.id) || this.aXJ == null || !this.aXJ.isValid()) ? false : true;
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
