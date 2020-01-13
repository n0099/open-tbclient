package com.baidu.swan.apps.component.b;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.swan.apps.as.af;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String bdU;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a bdZ;
    private String bea;
    public String bdV = "";
    public String bdW = "";
    public String bdX = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean bdY = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.bdU = "unknown";
        this.bea = "id";
        if (!TextUtils.isEmpty(str)) {
            this.bdU = str;
        } else {
            com.baidu.swan.apps.component.e.a.ak("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.bea = str2;
        } else {
            com.baidu.swan.apps.component.e.a.ak("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bdZ != null) {
            bVar.bdZ = (com.baidu.swan.apps.model.a.a.a) this.bdZ.clone();
        } else {
            bVar.bdZ = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bdV = jSONObject.optString(this.bea);
            if (TextUtils.isEmpty(this.bdV)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdU + " component componentId is empty");
            }
            this.bdW = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.bdW)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdU + " component slaveId is empty");
            }
            this.bdX = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.bdY = TextUtils.equals(jSONObject.optString("gesture"), "1");
            aa(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.bdV = jSONObject.optString(this.bea, bVar.bdV);
            if (TextUtils.isEmpty(this.bdV)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdU + " component componentId is empty");
            }
            this.bdW = jSONObject.optString("slaveId", bVar.bdW);
            if (TextUtils.isEmpty(this.bdW)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdU + " component slaveId is empty");
            }
            this.bdX = jSONObject.optString("parentId", bVar.bdX);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.bdY = TextUtils.equals(jSONObject.optString("gesture", bVar.bdY ? "1" : "0"), "1");
            this.bdZ = bVar.bdZ;
            if (this.bdZ == null) {
                this.bdZ = new com.baidu.swan.apps.model.a.a.a();
            }
            aa(jSONObject);
        }
    }

    public void Y(JSONObject jSONObject) {
        this.bdV = jSONObject.optString(this.bea, this.bdV);
        if (TextUtils.isEmpty(this.bdV)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdU + " component componentId is empty");
        }
        this.bdW = jSONObject.optString("slaveId", this.bdW);
        if (TextUtils.isEmpty(this.bdW)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdU + " component slaveId is empty");
        }
        this.bdX = jSONObject.optString("parentId", this.bdX);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.bdY = TextUtils.equals(jSONObject.optString("gesture", this.bdY ? "1" : "0"), "1");
        aa(jSONObject);
    }

    private void aa(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.bdZ = new com.baidu.swan.apps.model.a.a.a();
            this.bdZ.fi(af.S(getFloat(optJSONObject, "left", 0.0f)));
            this.bdZ.fj(af.S(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.bdZ.setWidth(af.S(getFloat(optJSONObject, "width", 0.0f)));
            this.bdZ.setHeight(af.S(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bdV) || TextUtils.isEmpty(this.bdW) || this.bdZ == null || !this.bdZ.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.bdU + "', componentId='" + this.bdV + "', slaveId='" + this.bdW + "', parentId='" + this.bdX + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.bdY + ", position=" + this.bdZ + ", mComponentIdKey='" + this.bea + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.bdU + "#" + (TextUtils.isEmpty(this.bdV) ? "" : this.bdV) + "】";
    }

    public final FrameLayout.LayoutParams Ix() {
        int width = this.bdZ != null ? this.bdZ.getWidth() : -1;
        int height = this.bdZ != null ? this.bdZ.getHeight() : -1;
        int left = this.bdZ != null ? this.bdZ.getLeft() : 0;
        int top = this.bdZ != null ? this.bdZ.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
