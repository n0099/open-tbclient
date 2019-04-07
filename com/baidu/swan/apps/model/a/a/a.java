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
    public int aBC;
    public String aBD;
    private String aBE;
    public String aBF;
    public String aBG;
    public String aBH;
    public b aBI;
    public boolean aBJ = false;
    public JSONObject akk;
    public String callback;
    public boolean hidden;
    public String id;

    public a(String str, String str2) {
        this.aBE = "id";
        this.aBF = "unknown";
        if (!TextUtils.isEmpty(str)) {
            this.aBE = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.aBF = str2;
        }
    }

    public a EK() {
        a aVar = new a(this.aBE, this.aBF);
        aVar.aBE = this.aBE;
        aVar.aBF = this.aBF;
        aVar.aBG = this.aBG;
        aVar.id = this.id;
        aVar.aBH = this.aBH;
        aVar.hidden = this.hidden;
        aVar.aBJ = this.aBJ;
        aVar.callback = this.callback;
        if (this.aBI != null) {
            aVar.aBI = new b(this.aBI);
        }
        aVar.akk = this.akk;
        aVar.aBC = this.aBC;
        aVar.aBD = this.aBD;
        return aVar;
    }

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aBE);
            this.aBG = jSONObject.optString("slaveId");
            this.aBH = jSONObject.optString("parentId");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.aBJ = TextUtils.equals(jSONObject.optString("gesture"), "1");
            this.callback = jSONObject.optString("cb");
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aBI = new b();
                this.aBI.setLeft(x.ad(a(optJSONObject, CustomDialogData.POS_LEFT, 0.0f)));
                this.aBI.setTop(x.ad(a(optJSONObject, "top", 0.0f)));
                this.aBI.setWidth(x.ad(a(optJSONObject, "width", 0.0f)));
                this.aBI.setHeight(x.ad(a(optJSONObject, "height", 0.0f)));
            }
            this.akk = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            this.aBC = jSONObject.optInt("scrollTop");
            if (this.akk != null) {
                this.aBD = this.akk.optString("overflowY");
            }
        }
    }

    public void a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aBE, aVar.id);
            this.aBG = jSONObject.optString("slaveId", aVar.aBG);
            this.aBH = jSONObject.optString("parentId", aVar.aBH);
            this.hidden = jSONObject.optBoolean("hide", aVar.hidden);
            this.callback = jSONObject.optString("cb", aVar.callback);
            this.aBJ = TextUtils.equals(jSONObject.optString("gesture", aVar.aBJ ? "1" : "0"), "1");
            this.aBI = aVar.aBI;
            if (this.aBI == null) {
                this.aBI = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aBI.setLeft(x.ad(a(optJSONObject, CustomDialogData.POS_LEFT, this.aBI.left)));
                this.aBI.setTop(x.ad(a(optJSONObject, "top", this.aBI.top)));
                this.aBI.setWidth(x.ad(a(optJSONObject, "width", this.aBI.width)));
                this.aBI.setHeight(x.ad(a(optJSONObject, "height", this.aBI.height)));
            }
            this.akk = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (this.akk == null) {
                this.akk = aVar.akk;
            }
            this.aBC = jSONObject.optInt("scrollTop", aVar.aBC);
            if (this.akk != null) {
                this.aBD = this.akk.optString("overflowY", aVar.aBD);
            }
        }
    }

    public FrameLayout.LayoutParams EL() {
        int width = this.aBI != null ? this.aBI.getWidth() : -1;
        int height = this.aBI != null ? this.aBI.getHeight() : -1;
        int left = this.aBI != null ? this.aBI.getLeft() : 0;
        int top = this.aBI != null ? this.aBI.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    public void a(b bVar) {
        this.aBI = bVar;
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.ew(63);
                return;
            }
            if (this.aBI != null && !this.aBI.equals(aVar.aBI)) {
                aVar2.ew(1);
            }
            if (aVar.hidden != this.hidden) {
                aVar2.ew(8);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aBG) || TextUtils.isEmpty(this.id) || this.aBI == null || !this.aBI.isValid()) ? false : true;
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
