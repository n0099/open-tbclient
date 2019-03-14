package com.baidu.swan.apps.model.a.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.an.x;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.model.a {
    public String aBA;
    private String aBB;
    public String aBC;
    public String aBD;
    public String aBE;
    public b aBF;
    public boolean aBG = false;
    public int aBz;
    public JSONObject akg;
    public String callback;
    public boolean hidden;
    public String id;

    public a(String str, String str2) {
        this.aBB = "id";
        this.aBC = "unknown";
        if (!TextUtils.isEmpty(str)) {
            this.aBB = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.aBC = str2;
        }
    }

    public a EM() {
        a aVar = new a(this.aBB, this.aBC);
        aVar.aBB = this.aBB;
        aVar.aBC = this.aBC;
        aVar.aBD = this.aBD;
        aVar.id = this.id;
        aVar.aBE = this.aBE;
        aVar.hidden = this.hidden;
        aVar.aBG = this.aBG;
        aVar.callback = this.callback;
        if (this.aBF != null) {
            aVar.aBF = new b(this.aBF);
        }
        aVar.akg = this.akg;
        aVar.aBz = this.aBz;
        aVar.aBA = this.aBA;
        return aVar;
    }

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aBB);
            this.aBD = jSONObject.optString("slaveId");
            this.aBE = jSONObject.optString("parentId");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.aBG = TextUtils.equals(jSONObject.optString("gesture"), "1");
            this.callback = jSONObject.optString("cb");
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aBF = new b();
                this.aBF.setLeft(x.ad(a(optJSONObject, CustomDialogData.POS_LEFT, 0.0f)));
                this.aBF.setTop(x.ad(a(optJSONObject, "top", 0.0f)));
                this.aBF.setWidth(x.ad(a(optJSONObject, "width", 0.0f)));
                this.aBF.setHeight(x.ad(a(optJSONObject, "height", 0.0f)));
            }
            this.akg = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            this.aBz = jSONObject.optInt("scrollTop");
            if (this.akg != null) {
                this.aBA = this.akg.optString("overflowY");
            }
        }
    }

    public void a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aBB, aVar.id);
            this.aBD = jSONObject.optString("slaveId", aVar.aBD);
            this.aBE = jSONObject.optString("parentId", aVar.aBE);
            this.hidden = jSONObject.optBoolean("hide", aVar.hidden);
            this.callback = jSONObject.optString("cb", aVar.callback);
            this.aBG = TextUtils.equals(jSONObject.optString("gesture", aVar.aBG ? "1" : "0"), "1");
            this.aBF = aVar.aBF;
            if (this.aBF == null) {
                this.aBF = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aBF.setLeft(x.ad(a(optJSONObject, CustomDialogData.POS_LEFT, this.aBF.left)));
                this.aBF.setTop(x.ad(a(optJSONObject, "top", this.aBF.top)));
                this.aBF.setWidth(x.ad(a(optJSONObject, "width", this.aBF.width)));
                this.aBF.setHeight(x.ad(a(optJSONObject, "height", this.aBF.height)));
            }
            this.akg = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (this.akg == null) {
                this.akg = aVar.akg;
            }
            this.aBz = jSONObject.optInt("scrollTop", aVar.aBz);
            if (this.akg != null) {
                this.aBA = this.akg.optString("overflowY", aVar.aBA);
            }
        }
    }

    public FrameLayout.LayoutParams EN() {
        int width = this.aBF != null ? this.aBF.getWidth() : -1;
        int height = this.aBF != null ? this.aBF.getHeight() : -1;
        int left = this.aBF != null ? this.aBF.getLeft() : 0;
        int top = this.aBF != null ? this.aBF.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    public void a(b bVar) {
        this.aBF = bVar;
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.ex(63);
                return;
            }
            if (this.aBF != null && !this.aBF.equals(aVar.aBF)) {
                aVar2.ex(1);
            }
            if (aVar.hidden != this.hidden) {
                aVar2.ex(8);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aBD) || TextUtils.isEmpty(this.id) || this.aBF == null || !this.aBF.isValid()) ? false : true;
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
