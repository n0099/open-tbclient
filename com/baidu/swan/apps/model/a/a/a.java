package com.baidu.swan.apps.model.a.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.an.z;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.model.a {
    public int aEo;
    public String aEp;
    private String aEq;
    public String aEr;
    public String aEs;
    public String aEt;
    public b aEu;
    public boolean aEv = false;
    public JSONObject aly;
    public String callback;
    public boolean hidden;
    public String id;

    public a(String str, String str2) {
        this.aEq = "id";
        this.aEr = "unknown";
        if (!TextUtils.isEmpty(str)) {
            this.aEq = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.aEr = str2;
        }
    }

    public a Hw() {
        a aVar = new a(this.aEq, this.aEr);
        aVar.aEq = this.aEq;
        aVar.aEr = this.aEr;
        aVar.aEs = this.aEs;
        aVar.id = this.id;
        aVar.aEt = this.aEt;
        aVar.hidden = this.hidden;
        aVar.aEv = this.aEv;
        aVar.callback = this.callback;
        if (this.aEu != null) {
            aVar.aEu = new b(this.aEu);
        }
        aVar.aly = this.aly;
        aVar.aEo = this.aEo;
        aVar.aEp = this.aEp;
        return aVar;
    }

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aEq);
            this.aEs = jSONObject.optString("slaveId");
            this.aEt = jSONObject.optString("parentId");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.aEv = TextUtils.equals(jSONObject.optString("gesture"), "1");
            this.callback = jSONObject.optString("cb");
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aEu = new b();
                this.aEu.cN(z.ad(a(optJSONObject, CustomDialogData.POS_LEFT, 0.0f)));
                this.aEu.cO(z.ad(a(optJSONObject, "top", 0.0f)));
                this.aEu.setWidth(z.ad(a(optJSONObject, "width", 0.0f)));
                this.aEu.setHeight(z.ad(a(optJSONObject, "height", 0.0f)));
            }
            this.aly = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            this.aEo = jSONObject.optInt("scrollTop");
            if (this.aly != null) {
                this.aEp = this.aly.optString("overflowY");
            }
        }
    }

    public void a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aEq, aVar.id);
            this.aEs = jSONObject.optString("slaveId", aVar.aEs);
            this.aEt = jSONObject.optString("parentId", aVar.aEt);
            this.hidden = jSONObject.optBoolean("hide", aVar.hidden);
            this.callback = jSONObject.optString("cb", aVar.callback);
            this.aEv = TextUtils.equals(jSONObject.optString("gesture", aVar.aEv ? "1" : "0"), "1");
            this.aEu = aVar.aEu;
            if (this.aEu == null) {
                this.aEu = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aEu.cN(z.ad(a(optJSONObject, CustomDialogData.POS_LEFT, this.aEu.left)));
                this.aEu.cO(z.ad(a(optJSONObject, "top", this.aEu.top)));
                this.aEu.setWidth(z.ad(a(optJSONObject, "width", this.aEu.width)));
                this.aEu.setHeight(z.ad(a(optJSONObject, "height", this.aEu.height)));
            }
            this.aly = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (this.aly == null) {
                this.aly = aVar.aly;
            }
            this.aEo = jSONObject.optInt("scrollTop", aVar.aEo);
            if (this.aly != null) {
                this.aEp = this.aly.optString("overflowY", aVar.aEp);
            }
        }
    }

    public FrameLayout.LayoutParams Hx() {
        int width = this.aEu != null ? this.aEu.getWidth() : -1;
        int height = this.aEu != null ? this.aEu.getHeight() : -1;
        int left = this.aEu != null ? this.aEu.getLeft() : 0;
        int Hz = this.aEu != null ? this.aEu.Hz() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, Hz, 0, 0);
        return layoutParams;
    }

    public void a(b bVar) {
        this.aEu = bVar;
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.eM(63);
                return;
            }
            if (this.aEu != null && !this.aEu.equals(aVar.aEu)) {
                aVar2.eM(1);
            }
            if (aVar.hidden != this.hidden) {
                aVar2.eM(8);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aEs) || TextUtils.isEmpty(this.id) || this.aEu == null || !this.aEu.isValid()) ? false : true;
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
