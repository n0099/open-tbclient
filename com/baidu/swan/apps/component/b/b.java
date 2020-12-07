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
/* loaded from: classes25.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String cIU;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a cIZ;
    private String cJa;
    public String cIV = "";
    public String cIW = "";
    public String cIX = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean cIY = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.cIU = "unknown";
        this.cJa = "id";
        if (!TextUtils.isEmpty(str)) {
            this.cIU = str;
        } else {
            com.baidu.swan.apps.component.e.a.bs("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.cJa = str2;
        } else {
            com.baidu.swan.apps.component.e.a.bs("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cIZ != null) {
            bVar.cIZ = (com.baidu.swan.apps.model.a.a.a) this.cIZ.clone();
        } else {
            bVar.cIZ = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cIV = jSONObject.optString(this.cJa);
            if (TextUtils.isEmpty(this.cIV)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cIU + " component componentId is empty");
            }
            this.cIW = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.cIW)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cIU + " component slaveId is empty");
            }
            this.cIX = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.cIY = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK), "1");
            aY(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.cIV = jSONObject.optString(this.cJa, bVar.cIV);
            if (TextUtils.isEmpty(this.cIV)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cIU + " component componentId is empty");
            }
            this.cIW = jSONObject.optString("slaveId", bVar.cIW);
            if (TextUtils.isEmpty(this.cIW)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cIU + " component slaveId is empty");
            }
            this.cIX = jSONObject.optString("parentId", bVar.cIX);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.cIY = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, bVar.cIY ? "1" : "0"), "1");
            this.cIZ = bVar.cIZ;
            if (this.cIZ == null) {
                this.cIZ = new com.baidu.swan.apps.model.a.a.a();
            }
            aY(jSONObject);
        }
    }

    public void aW(JSONObject jSONObject) {
        this.cIV = jSONObject.optString(this.cJa, this.cIV);
        if (TextUtils.isEmpty(this.cIV)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cIU + " component componentId is empty");
        }
        this.cIW = jSONObject.optString("slaveId", this.cIW);
        if (TextUtils.isEmpty(this.cIW)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cIU + " component slaveId is empty");
        }
        this.cIX = jSONObject.optString("parentId", this.cIX);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.cIY = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, this.cIY ? "1" : "0"), "1");
        aY(jSONObject);
    }

    private void aY(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.cIZ = new com.baidu.swan.apps.model.a.a.a();
            this.cIZ.jU(ah.M(getFloat(optJSONObject, "left", 0.0f)));
            this.cIZ.jV(ah.M(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.cIZ.setWidth(ah.M(getFloat(optJSONObject, "width", 0.0f)));
            this.cIZ.setHeight(ah.M(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cIV) || TextUtils.isEmpty(this.cIW) || this.cIZ == null || !this.cIZ.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.cIU + "', componentId='" + this.cIV + "', slaveId='" + this.cIW + "', parentId='" + this.cIX + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.cIY + ", position=" + this.cIZ + ", mComponentIdKey='" + this.cJa + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.cIU + "#" + (TextUtils.isEmpty(this.cIV) ? "" : this.cIV) + "】";
    }

    public final FrameLayout.LayoutParams anw() {
        int width = this.cIZ != null ? this.cIZ.getWidth() : -1;
        int height = this.cIZ != null ? this.cIZ.getHeight() : -1;
        int left = this.cIZ != null ? this.cIZ.getLeft() : 0;
        int top = this.cIZ != null ? this.cIZ.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
