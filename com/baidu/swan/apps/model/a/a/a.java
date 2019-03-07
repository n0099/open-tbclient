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
    private String aBA;
    public String aBB;
    public String aBC;
    public String aBD;
    public b aBE;
    public boolean aBF = false;
    public int aBy;
    public String aBz;
    public JSONObject akf;
    public String callback;
    public boolean hidden;
    public String id;

    public a(String str, String str2) {
        this.aBA = "id";
        this.aBB = "unknown";
        if (!TextUtils.isEmpty(str)) {
            this.aBA = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.aBB = str2;
        }
    }

    public a EM() {
        a aVar = new a(this.aBA, this.aBB);
        aVar.aBA = this.aBA;
        aVar.aBB = this.aBB;
        aVar.aBC = this.aBC;
        aVar.id = this.id;
        aVar.aBD = this.aBD;
        aVar.hidden = this.hidden;
        aVar.aBF = this.aBF;
        aVar.callback = this.callback;
        if (this.aBE != null) {
            aVar.aBE = new b(this.aBE);
        }
        aVar.akf = this.akf;
        aVar.aBy = this.aBy;
        aVar.aBz = this.aBz;
        return aVar;
    }

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aBA);
            this.aBC = jSONObject.optString("slaveId");
            this.aBD = jSONObject.optString("parentId");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.aBF = TextUtils.equals(jSONObject.optString("gesture"), "1");
            this.callback = jSONObject.optString("cb");
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aBE = new b();
                this.aBE.setLeft(x.ad(a(optJSONObject, CustomDialogData.POS_LEFT, 0.0f)));
                this.aBE.setTop(x.ad(a(optJSONObject, "top", 0.0f)));
                this.aBE.setWidth(x.ad(a(optJSONObject, "width", 0.0f)));
                this.aBE.setHeight(x.ad(a(optJSONObject, "height", 0.0f)));
            }
            this.akf = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            this.aBy = jSONObject.optInt("scrollTop");
            if (this.akf != null) {
                this.aBz = this.akf.optString("overflowY");
            }
        }
    }

    public void a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aBA, aVar.id);
            this.aBC = jSONObject.optString("slaveId", aVar.aBC);
            this.aBD = jSONObject.optString("parentId", aVar.aBD);
            this.hidden = jSONObject.optBoolean("hide", aVar.hidden);
            this.callback = jSONObject.optString("cb", aVar.callback);
            this.aBF = TextUtils.equals(jSONObject.optString("gesture", aVar.aBF ? "1" : "0"), "1");
            this.aBE = aVar.aBE;
            if (this.aBE == null) {
                this.aBE = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aBE.setLeft(x.ad(a(optJSONObject, CustomDialogData.POS_LEFT, this.aBE.left)));
                this.aBE.setTop(x.ad(a(optJSONObject, "top", this.aBE.top)));
                this.aBE.setWidth(x.ad(a(optJSONObject, "width", this.aBE.width)));
                this.aBE.setHeight(x.ad(a(optJSONObject, "height", this.aBE.height)));
            }
            this.akf = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (this.akf == null) {
                this.akf = aVar.akf;
            }
            this.aBy = jSONObject.optInt("scrollTop", aVar.aBy);
            if (this.akf != null) {
                this.aBz = this.akf.optString("overflowY", aVar.aBz);
            }
        }
    }

    public FrameLayout.LayoutParams EN() {
        int width = this.aBE != null ? this.aBE.getWidth() : -1;
        int height = this.aBE != null ? this.aBE.getHeight() : -1;
        int left = this.aBE != null ? this.aBE.getLeft() : 0;
        int top = this.aBE != null ? this.aBE.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    public void a(b bVar) {
        this.aBE = bVar;
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.ex(63);
                return;
            }
            if (this.aBE != null && !this.aBE.equals(aVar.aBE)) {
                aVar2.ex(1);
            }
            if (aVar.hidden != this.hidden) {
                aVar2.ex(8);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aBC) || TextUtils.isEmpty(this.id) || this.aBE == null || !this.aBE.isValid()) ? false : true;
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
