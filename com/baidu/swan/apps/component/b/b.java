package com.baidu.swan.apps.component.b;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.swan.apps.ap.ah;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String caW;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a cbb;
    private String cbc;
    public String caX = "";
    public String caY = "";
    public String caZ = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean cba = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.caW = "unknown";
        this.cbc = "id";
        if (!TextUtils.isEmpty(str)) {
            this.caW = str;
        } else {
            com.baidu.swan.apps.component.e.a.ba("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.cbc = str2;
        } else {
            com.baidu.swan.apps.component.e.a.ba("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cbb != null) {
            bVar.cbb = (com.baidu.swan.apps.model.a.a.a) this.cbb.clone();
        } else {
            bVar.cbb = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.caX = jSONObject.optString(this.cbc);
            if (TextUtils.isEmpty(this.caX)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caW + " component componentId is empty");
            }
            this.caY = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.caY)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caW + " component slaveId is empty");
            }
            this.caZ = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.cba = TextUtils.equals(jSONObject.optString("gesture"), "1");
            aJ(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.caX = jSONObject.optString(this.cbc, bVar.caX);
            if (TextUtils.isEmpty(this.caX)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caW + " component componentId is empty");
            }
            this.caY = jSONObject.optString("slaveId", bVar.caY);
            if (TextUtils.isEmpty(this.caY)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caW + " component slaveId is empty");
            }
            this.caZ = jSONObject.optString("parentId", bVar.caZ);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.cba = TextUtils.equals(jSONObject.optString("gesture", bVar.cba ? "1" : "0"), "1");
            this.cbb = bVar.cbb;
            if (this.cbb == null) {
                this.cbb = new com.baidu.swan.apps.model.a.a.a();
            }
            aJ(jSONObject);
        }
    }

    public void aH(JSONObject jSONObject) {
        this.caX = jSONObject.optString(this.cbc, this.caX);
        if (TextUtils.isEmpty(this.caX)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caW + " component componentId is empty");
        }
        this.caY = jSONObject.optString("slaveId", this.caY);
        if (TextUtils.isEmpty(this.caY)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caW + " component slaveId is empty");
        }
        this.caZ = jSONObject.optString("parentId", this.caZ);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.cba = TextUtils.equals(jSONObject.optString("gesture", this.cba ? "1" : "0"), "1");
        aJ(jSONObject);
    }

    private void aJ(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.cbb = new com.baidu.swan.apps.model.a.a.a();
            this.cbb.iy(ah.H(getFloat(optJSONObject, "left", 0.0f)));
            this.cbb.iz(ah.H(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.cbb.setWidth(ah.H(getFloat(optJSONObject, "width", 0.0f)));
            this.cbb.setHeight(ah.H(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.caX) || TextUtils.isEmpty(this.caY) || this.cbb == null || !this.cbb.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.caW + "', componentId='" + this.caX + "', slaveId='" + this.caY + "', parentId='" + this.caZ + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.cba + ", position=" + this.cbb + ", mComponentIdKey='" + this.cbc + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.caW + "#" + (TextUtils.isEmpty(this.caX) ? "" : this.caX) + "】";
    }

    public final FrameLayout.LayoutParams adi() {
        int width = this.cbb != null ? this.cbb.getWidth() : -1;
        int height = this.cbb != null ? this.cbb.getHeight() : -1;
        int left = this.cbb != null ? this.cbb.getLeft() : 0;
        int top = this.cbb != null ? this.cbb.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
