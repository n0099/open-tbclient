package com.baidu.swan.apps.component.b;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.appframework.AppFrameworkConstants;
import com.baidu.swan.apps.ap.ah;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String cpo;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a cpt;
    private String cpv;
    public String cpp = "";
    public String cpq = "";
    public String cpr = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean cps = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.cpo = "unknown";
        this.cpv = "id";
        if (!TextUtils.isEmpty(str)) {
            this.cpo = str;
        } else {
            com.baidu.swan.apps.component.e.a.bf("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.cpv = str2;
        } else {
            com.baidu.swan.apps.component.e.a.bf("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cpt != null) {
            bVar.cpt = (com.baidu.swan.apps.model.a.a.a) this.cpt.clone();
        } else {
            bVar.cpt = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cpp = jSONObject.optString(this.cpv);
            if (TextUtils.isEmpty(this.cpp)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cpo + " component componentId is empty");
            }
            this.cpq = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.cpq)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cpo + " component slaveId is empty");
            }
            this.cpr = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.cps = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK), "1");
            aT(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.cpp = jSONObject.optString(this.cpv, bVar.cpp);
            if (TextUtils.isEmpty(this.cpp)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cpo + " component componentId is empty");
            }
            this.cpq = jSONObject.optString("slaveId", bVar.cpq);
            if (TextUtils.isEmpty(this.cpq)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cpo + " component slaveId is empty");
            }
            this.cpr = jSONObject.optString("parentId", bVar.cpr);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.cps = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, bVar.cps ? "1" : "0"), "1");
            this.cpt = bVar.cpt;
            if (this.cpt == null) {
                this.cpt = new com.baidu.swan.apps.model.a.a.a();
            }
            aT(jSONObject);
        }
    }

    public void aR(JSONObject jSONObject) {
        this.cpp = jSONObject.optString(this.cpv, this.cpp);
        if (TextUtils.isEmpty(this.cpp)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cpo + " component componentId is empty");
        }
        this.cpq = jSONObject.optString("slaveId", this.cpq);
        if (TextUtils.isEmpty(this.cpq)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cpo + " component slaveId is empty");
        }
        this.cpr = jSONObject.optString("parentId", this.cpr);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.cps = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, this.cps ? "1" : "0"), "1");
        aT(jSONObject);
    }

    private void aT(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.cpt = new com.baidu.swan.apps.model.a.a.a();
            this.cpt.jf(ah.J(getFloat(optJSONObject, "left", 0.0f)));
            this.cpt.jg(ah.J(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.cpt.setWidth(ah.J(getFloat(optJSONObject, "width", 0.0f)));
            this.cpt.setHeight(ah.J(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cpp) || TextUtils.isEmpty(this.cpq) || this.cpt == null || !this.cpt.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.cpo + "', componentId='" + this.cpp + "', slaveId='" + this.cpq + "', parentId='" + this.cpr + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.cps + ", position=" + this.cpt + ", mComponentIdKey='" + this.cpv + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.cpo + "#" + (TextUtils.isEmpty(this.cpp) ? "" : this.cpp) + "】";
    }

    public final FrameLayout.LayoutParams agC() {
        int width = this.cpt != null ? this.cpt.getWidth() : -1;
        int height = this.cpt != null ? this.cpt.getHeight() : -1;
        int left = this.cpt != null ? this.cpt.getLeft() : 0;
        int top = this.cpt != null ? this.cpt.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
