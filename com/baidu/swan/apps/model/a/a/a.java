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
    public int aBD;
    public String aBE;
    private String aBF;
    public String aBG;
    public String aBH;
    public String aBI;
    public b aBJ;
    public boolean aBK = false;
    public JSONObject akl;
    public String callback;
    public boolean hidden;
    public String id;

    public a(String str, String str2) {
        this.aBF = "id";
        this.aBG = "unknown";
        if (!TextUtils.isEmpty(str)) {
            this.aBF = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.aBG = str2;
        }
    }

    public a EK() {
        a aVar = new a(this.aBF, this.aBG);
        aVar.aBF = this.aBF;
        aVar.aBG = this.aBG;
        aVar.aBH = this.aBH;
        aVar.id = this.id;
        aVar.aBI = this.aBI;
        aVar.hidden = this.hidden;
        aVar.aBK = this.aBK;
        aVar.callback = this.callback;
        if (this.aBJ != null) {
            aVar.aBJ = new b(this.aBJ);
        }
        aVar.akl = this.akl;
        aVar.aBD = this.aBD;
        aVar.aBE = this.aBE;
        return aVar;
    }

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aBF);
            this.aBH = jSONObject.optString("slaveId");
            this.aBI = jSONObject.optString("parentId");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.aBK = TextUtils.equals(jSONObject.optString("gesture"), "1");
            this.callback = jSONObject.optString("cb");
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aBJ = new b();
                this.aBJ.setLeft(x.ad(a(optJSONObject, CustomDialogData.POS_LEFT, 0.0f)));
                this.aBJ.setTop(x.ad(a(optJSONObject, "top", 0.0f)));
                this.aBJ.setWidth(x.ad(a(optJSONObject, "width", 0.0f)));
                this.aBJ.setHeight(x.ad(a(optJSONObject, "height", 0.0f)));
            }
            this.akl = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            this.aBD = jSONObject.optInt("scrollTop");
            if (this.akl != null) {
                this.aBE = this.akl.optString("overflowY");
            }
        }
    }

    public void a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aBF, aVar.id);
            this.aBH = jSONObject.optString("slaveId", aVar.aBH);
            this.aBI = jSONObject.optString("parentId", aVar.aBI);
            this.hidden = jSONObject.optBoolean("hide", aVar.hidden);
            this.callback = jSONObject.optString("cb", aVar.callback);
            this.aBK = TextUtils.equals(jSONObject.optString("gesture", aVar.aBK ? "1" : "0"), "1");
            this.aBJ = aVar.aBJ;
            if (this.aBJ == null) {
                this.aBJ = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aBJ.setLeft(x.ad(a(optJSONObject, CustomDialogData.POS_LEFT, this.aBJ.left)));
                this.aBJ.setTop(x.ad(a(optJSONObject, "top", this.aBJ.top)));
                this.aBJ.setWidth(x.ad(a(optJSONObject, "width", this.aBJ.width)));
                this.aBJ.setHeight(x.ad(a(optJSONObject, "height", this.aBJ.height)));
            }
            this.akl = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (this.akl == null) {
                this.akl = aVar.akl;
            }
            this.aBD = jSONObject.optInt("scrollTop", aVar.aBD);
            if (this.akl != null) {
                this.aBE = this.akl.optString("overflowY", aVar.aBE);
            }
        }
    }

    public FrameLayout.LayoutParams EL() {
        int width = this.aBJ != null ? this.aBJ.getWidth() : -1;
        int height = this.aBJ != null ? this.aBJ.getHeight() : -1;
        int left = this.aBJ != null ? this.aBJ.getLeft() : 0;
        int top = this.aBJ != null ? this.aBJ.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    public void a(b bVar) {
        this.aBJ = bVar;
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.ew(63);
                return;
            }
            if (this.aBJ != null && !this.aBJ.equals(aVar.aBJ)) {
                aVar2.ew(1);
            }
            if (aVar.hidden != this.hidden) {
                aVar2.ew(8);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aBH) || TextUtils.isEmpty(this.id) || this.aBJ == null || !this.aBJ.isValid()) ? false : true;
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
