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
/* loaded from: classes3.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String ccY;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a cdd;
    private String cde;
    public String ccZ = "";
    public String cda = "";
    public String cdb = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean cdc = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.ccY = "unknown";
        this.cde = "id";
        if (!TextUtils.isEmpty(str)) {
            this.ccY = str;
        } else {
            com.baidu.swan.apps.component.e.a.ba("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.cde = str2;
        } else {
            com.baidu.swan.apps.component.e.a.ba("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cdd != null) {
            bVar.cdd = (com.baidu.swan.apps.model.a.a.a) this.cdd.clone();
        } else {
            bVar.cdd = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ccZ = jSONObject.optString(this.cde);
            if (TextUtils.isEmpty(this.ccZ)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.ccY + " component componentId is empty");
            }
            this.cda = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.cda)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.ccY + " component slaveId is empty");
            }
            this.cdb = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.cdc = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK), "1");
            aM(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.ccZ = jSONObject.optString(this.cde, bVar.ccZ);
            if (TextUtils.isEmpty(this.ccZ)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.ccY + " component componentId is empty");
            }
            this.cda = jSONObject.optString("slaveId", bVar.cda);
            if (TextUtils.isEmpty(this.cda)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.ccY + " component slaveId is empty");
            }
            this.cdb = jSONObject.optString("parentId", bVar.cdb);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.cdc = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, bVar.cdc ? "1" : "0"), "1");
            this.cdd = bVar.cdd;
            if (this.cdd == null) {
                this.cdd = new com.baidu.swan.apps.model.a.a.a();
            }
            aM(jSONObject);
        }
    }

    public void aK(JSONObject jSONObject) {
        this.ccZ = jSONObject.optString(this.cde, this.ccZ);
        if (TextUtils.isEmpty(this.ccZ)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.ccY + " component componentId is empty");
        }
        this.cda = jSONObject.optString("slaveId", this.cda);
        if (TextUtils.isEmpty(this.cda)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.ccY + " component slaveId is empty");
        }
        this.cdb = jSONObject.optString("parentId", this.cdb);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.cdc = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, this.cdc ? "1" : "0"), "1");
        aM(jSONObject);
    }

    private void aM(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.cdd = new com.baidu.swan.apps.model.a.a.a();
            this.cdd.iI(ah.H(getFloat(optJSONObject, "left", 0.0f)));
            this.cdd.iJ(ah.H(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.cdd.setWidth(ah.H(getFloat(optJSONObject, "width", 0.0f)));
            this.cdd.setHeight(ah.H(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.ccZ) || TextUtils.isEmpty(this.cda) || this.cdd == null || !this.cdd.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.ccY + "', componentId='" + this.ccZ + "', slaveId='" + this.cda + "', parentId='" + this.cdb + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.cdc + ", position=" + this.cdd + ", mComponentIdKey='" + this.cde + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.ccY + "#" + (TextUtils.isEmpty(this.ccZ) ? "" : this.ccZ) + "】";
    }

    public final FrameLayout.LayoutParams adR() {
        int width = this.cdd != null ? this.cdd.getWidth() : -1;
        int height = this.cdd != null ? this.cdd.getHeight() : -1;
        int left = this.cdd != null ? this.cdd.getLeft() : 0;
        int top = this.cdd != null ? this.cdd.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
