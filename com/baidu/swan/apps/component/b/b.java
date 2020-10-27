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
    public String cxQ;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a cxV;
    private String cxW;
    public String cxR = "";
    public String cxS = "";
    public String cxT = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean cxU = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.cxQ = "unknown";
        this.cxW = "id";
        if (!TextUtils.isEmpty(str)) {
            this.cxQ = str;
        } else {
            com.baidu.swan.apps.component.e.a.bm("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.cxW = str2;
        } else {
            com.baidu.swan.apps.component.e.a.bm("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cxV != null) {
            bVar.cxV = (com.baidu.swan.apps.model.a.a.a) this.cxV.clone();
        } else {
            bVar.cxV = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cxR = jSONObject.optString(this.cxW);
            if (TextUtils.isEmpty(this.cxR)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cxQ + " component componentId is empty");
            }
            this.cxS = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.cxS)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cxQ + " component slaveId is empty");
            }
            this.cxT = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.cxU = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK), "1");
            aW(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.cxR = jSONObject.optString(this.cxW, bVar.cxR);
            if (TextUtils.isEmpty(this.cxR)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cxQ + " component componentId is empty");
            }
            this.cxS = jSONObject.optString("slaveId", bVar.cxS);
            if (TextUtils.isEmpty(this.cxS)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cxQ + " component slaveId is empty");
            }
            this.cxT = jSONObject.optString("parentId", bVar.cxT);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.cxU = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, bVar.cxU ? "1" : "0"), "1");
            this.cxV = bVar.cxV;
            if (this.cxV == null) {
                this.cxV = new com.baidu.swan.apps.model.a.a.a();
            }
            aW(jSONObject);
        }
    }

    public void aU(JSONObject jSONObject) {
        this.cxR = jSONObject.optString(this.cxW, this.cxR);
        if (TextUtils.isEmpty(this.cxR)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cxQ + " component componentId is empty");
        }
        this.cxS = jSONObject.optString("slaveId", this.cxS);
        if (TextUtils.isEmpty(this.cxS)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cxQ + " component slaveId is empty");
        }
        this.cxT = jSONObject.optString("parentId", this.cxT);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.cxU = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, this.cxU ? "1" : "0"), "1");
        aW(jSONObject);
    }

    private void aW(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.cxV = new com.baidu.swan.apps.model.a.a.a();
            this.cxV.jq(ah.L(getFloat(optJSONObject, "left", 0.0f)));
            this.cxV.jr(ah.L(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.cxV.setWidth(ah.L(getFloat(optJSONObject, "width", 0.0f)));
            this.cxV.setHeight(ah.L(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cxR) || TextUtils.isEmpty(this.cxS) || this.cxV == null || !this.cxV.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.cxQ + "', componentId='" + this.cxR + "', slaveId='" + this.cxS + "', parentId='" + this.cxT + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.cxU + ", position=" + this.cxV + ", mComponentIdKey='" + this.cxW + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.cxQ + "#" + (TextUtils.isEmpty(this.cxR) ? "" : this.cxR) + "】";
    }

    public final FrameLayout.LayoutParams aiw() {
        int width = this.cxV != null ? this.cxV.getWidth() : -1;
        int height = this.cxV != null ? this.cxV.getHeight() : -1;
        int left = this.cxV != null ? this.cxV.getLeft() : 0;
        int top = this.cxV != null ? this.cxV.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
