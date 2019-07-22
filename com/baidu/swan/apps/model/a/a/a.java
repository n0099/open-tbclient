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
    public int aDQ;
    public String aDR;
    private String aDS;
    public String aDT;
    public String aDU;
    public String aDV;
    public b aDW;
    public boolean aDX = false;
    public JSONObject akZ;
    public String callback;
    public boolean hidden;
    public String id;

    public a(String str, String str2) {
        this.aDS = "id";
        this.aDT = "unknown";
        if (!TextUtils.isEmpty(str)) {
            this.aDS = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.aDT = str2;
        }
    }

    public a Hs() {
        a aVar = new a(this.aDS, this.aDT);
        aVar.aDS = this.aDS;
        aVar.aDT = this.aDT;
        aVar.aDU = this.aDU;
        aVar.id = this.id;
        aVar.aDV = this.aDV;
        aVar.hidden = this.hidden;
        aVar.aDX = this.aDX;
        aVar.callback = this.callback;
        if (this.aDW != null) {
            aVar.aDW = new b(this.aDW);
        }
        aVar.akZ = this.akZ;
        aVar.aDQ = this.aDQ;
        aVar.aDR = this.aDR;
        return aVar;
    }

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aDS);
            this.aDU = jSONObject.optString("slaveId");
            this.aDV = jSONObject.optString("parentId");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.aDX = TextUtils.equals(jSONObject.optString("gesture"), "1");
            this.callback = jSONObject.optString("cb");
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aDW = new b();
                this.aDW.cM(z.ad(a(optJSONObject, CustomDialogData.POS_LEFT, 0.0f)));
                this.aDW.cN(z.ad(a(optJSONObject, "top", 0.0f)));
                this.aDW.setWidth(z.ad(a(optJSONObject, "width", 0.0f)));
                this.aDW.setHeight(z.ad(a(optJSONObject, "height", 0.0f)));
            }
            this.akZ = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            this.aDQ = jSONObject.optInt("scrollTop");
            if (this.akZ != null) {
                this.aDR = this.akZ.optString("overflowY");
            }
        }
    }

    public void a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aDS, aVar.id);
            this.aDU = jSONObject.optString("slaveId", aVar.aDU);
            this.aDV = jSONObject.optString("parentId", aVar.aDV);
            this.hidden = jSONObject.optBoolean("hide", aVar.hidden);
            this.callback = jSONObject.optString("cb", aVar.callback);
            this.aDX = TextUtils.equals(jSONObject.optString("gesture", aVar.aDX ? "1" : "0"), "1");
            this.aDW = aVar.aDW;
            if (this.aDW == null) {
                this.aDW = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aDW.cM(z.ad(a(optJSONObject, CustomDialogData.POS_LEFT, this.aDW.left)));
                this.aDW.cN(z.ad(a(optJSONObject, "top", this.aDW.top)));
                this.aDW.setWidth(z.ad(a(optJSONObject, "width", this.aDW.width)));
                this.aDW.setHeight(z.ad(a(optJSONObject, "height", this.aDW.height)));
            }
            this.akZ = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (this.akZ == null) {
                this.akZ = aVar.akZ;
            }
            this.aDQ = jSONObject.optInt("scrollTop", aVar.aDQ);
            if (this.akZ != null) {
                this.aDR = this.akZ.optString("overflowY", aVar.aDR);
            }
        }
    }

    public FrameLayout.LayoutParams Ht() {
        int width = this.aDW != null ? this.aDW.getWidth() : -1;
        int height = this.aDW != null ? this.aDW.getHeight() : -1;
        int left = this.aDW != null ? this.aDW.getLeft() : 0;
        int Hv = this.aDW != null ? this.aDW.Hv() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, Hv, 0, 0);
        return layoutParams;
    }

    public void a(b bVar) {
        this.aDW = bVar;
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.eL(63);
                return;
            }
            if (this.aDW != null && !this.aDW.equals(aVar.aDW)) {
                aVar2.eL(1);
            }
            if (aVar.hidden != this.hidden) {
                aVar2.eL(8);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aDU) || TextUtils.isEmpty(this.id) || this.aDW == null || !this.aDW.isValid()) ? false : true;
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
