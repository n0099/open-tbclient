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
    public int aDi;
    public String aDj;
    private String aDk;
    public String aDl;
    public String aDm;
    public String aDn;
    public b aDo;
    public boolean aDp = false;
    public JSONObject akx;
    public String callback;
    public boolean hidden;
    public String id;

    public a(String str, String str2) {
        this.aDk = "id";
        this.aDl = "unknown";
        if (!TextUtils.isEmpty(str)) {
            this.aDk = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.aDl = str2;
        }
    }

    public a GI() {
        a aVar = new a(this.aDk, this.aDl);
        aVar.aDk = this.aDk;
        aVar.aDl = this.aDl;
        aVar.aDm = this.aDm;
        aVar.id = this.id;
        aVar.aDn = this.aDn;
        aVar.hidden = this.hidden;
        aVar.aDp = this.aDp;
        aVar.callback = this.callback;
        if (this.aDo != null) {
            aVar.aDo = new b(this.aDo);
        }
        aVar.akx = this.akx;
        aVar.aDi = this.aDi;
        aVar.aDj = this.aDj;
        return aVar;
    }

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aDk);
            this.aDm = jSONObject.optString("slaveId");
            this.aDn = jSONObject.optString("parentId");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.aDp = TextUtils.equals(jSONObject.optString("gesture"), "1");
            this.callback = jSONObject.optString("cb");
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aDo = new b();
                this.aDo.setLeft(z.ad(a(optJSONObject, CustomDialogData.POS_LEFT, 0.0f)));
                this.aDo.setTop(z.ad(a(optJSONObject, "top", 0.0f)));
                this.aDo.setWidth(z.ad(a(optJSONObject, "width", 0.0f)));
                this.aDo.setHeight(z.ad(a(optJSONObject, "height", 0.0f)));
            }
            this.akx = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            this.aDi = jSONObject.optInt("scrollTop");
            if (this.akx != null) {
                this.aDj = this.akx.optString("overflowY");
            }
        }
    }

    public void a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.aDk, aVar.id);
            this.aDm = jSONObject.optString("slaveId", aVar.aDm);
            this.aDn = jSONObject.optString("parentId", aVar.aDn);
            this.hidden = jSONObject.optBoolean("hide", aVar.hidden);
            this.callback = jSONObject.optString("cb", aVar.callback);
            this.aDp = TextUtils.equals(jSONObject.optString("gesture", aVar.aDp ? "1" : "0"), "1");
            this.aDo = aVar.aDo;
            if (this.aDo == null) {
                this.aDo = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.aDo.setLeft(z.ad(a(optJSONObject, CustomDialogData.POS_LEFT, this.aDo.left)));
                this.aDo.setTop(z.ad(a(optJSONObject, "top", this.aDo.top)));
                this.aDo.setWidth(z.ad(a(optJSONObject, "width", this.aDo.width)));
                this.aDo.setHeight(z.ad(a(optJSONObject, "height", this.aDo.height)));
            }
            this.akx = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (this.akx == null) {
                this.akx = aVar.akx;
            }
            this.aDi = jSONObject.optInt("scrollTop", aVar.aDi);
            if (this.akx != null) {
                this.aDj = this.akx.optString("overflowY", aVar.aDj);
            }
        }
    }

    public FrameLayout.LayoutParams GJ() {
        int width = this.aDo != null ? this.aDo.getWidth() : -1;
        int height = this.aDo != null ? this.aDo.getHeight() : -1;
        int left = this.aDo != null ? this.aDo.getLeft() : 0;
        int top = this.aDo != null ? this.aDo.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    public void a(b bVar) {
        this.aDo = bVar;
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.eI(63);
                return;
            }
            if (this.aDo != null && !this.aDo.equals(aVar.aDo)) {
                aVar2.eI(1);
            }
            if (aVar.hidden != this.hidden) {
                aVar2.eI(8);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aDm) || TextUtils.isEmpty(this.id) || this.aDo == null || !this.aDo.isValid()) ? false : true;
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
