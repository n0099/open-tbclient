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
/* loaded from: classes7.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String cBZ;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a cCe;
    private String cCf;
    public String cCa = "";
    public String cCb = "";
    public String cCc = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean cCd = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.cBZ = "unknown";
        this.cCf = "id";
        if (!TextUtils.isEmpty(str)) {
            this.cBZ = str;
        } else {
            com.baidu.swan.apps.component.e.a.bl("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.cCf = str2;
        } else {
            com.baidu.swan.apps.component.e.a.bl("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cCe != null) {
            bVar.cCe = (com.baidu.swan.apps.model.a.a.a) this.cCe.clone();
        } else {
            bVar.cCe = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cCa = jSONObject.optString(this.cCf);
            if (TextUtils.isEmpty(this.cCa)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cBZ + " component componentId is empty");
            }
            this.cCb = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.cCb)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cBZ + " component slaveId is empty");
            }
            this.cCc = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.cCd = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK), "1");
            aW(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.cCa = jSONObject.optString(this.cCf, bVar.cCa);
            if (TextUtils.isEmpty(this.cCa)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cBZ + " component componentId is empty");
            }
            this.cCb = jSONObject.optString("slaveId", bVar.cCb);
            if (TextUtils.isEmpty(this.cCb)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cBZ + " component slaveId is empty");
            }
            this.cCc = jSONObject.optString("parentId", bVar.cCc);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.cCd = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, bVar.cCd ? "1" : "0"), "1");
            this.cCe = bVar.cCe;
            if (this.cCe == null) {
                this.cCe = new com.baidu.swan.apps.model.a.a.a();
            }
            aW(jSONObject);
        }
    }

    public void aU(JSONObject jSONObject) {
        this.cCa = jSONObject.optString(this.cCf, this.cCa);
        if (TextUtils.isEmpty(this.cCa)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cBZ + " component componentId is empty");
        }
        this.cCb = jSONObject.optString("slaveId", this.cCb);
        if (TextUtils.isEmpty(this.cCb)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cBZ + " component slaveId is empty");
        }
        this.cCc = jSONObject.optString("parentId", this.cCc);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.cCd = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, this.cCd ? "1" : "0"), "1");
        aW(jSONObject);
    }

    private void aW(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.cCe = new com.baidu.swan.apps.model.a.a.a();
            this.cCe.jw(ah.M(getFloat(optJSONObject, "left", 0.0f)));
            this.cCe.jx(ah.M(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.cCe.setWidth(ah.M(getFloat(optJSONObject, "width", 0.0f)));
            this.cCe.setHeight(ah.M(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cCa) || TextUtils.isEmpty(this.cCb) || this.cCe == null || !this.cCe.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.cBZ + "', componentId='" + this.cCa + "', slaveId='" + this.cCb + "', parentId='" + this.cCc + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.cCd + ", position=" + this.cCe + ", mComponentIdKey='" + this.cCf + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.cBZ + "#" + (TextUtils.isEmpty(this.cCa) ? "" : this.cCa) + "】";
    }

    public final FrameLayout.LayoutParams ako() {
        int width = this.cCe != null ? this.cCe.getWidth() : -1;
        int height = this.cCe != null ? this.cCe.getHeight() : -1;
        int left = this.cCe != null ? this.cCe.getLeft() : 0;
        int top = this.cCe != null ? this.cCe.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
