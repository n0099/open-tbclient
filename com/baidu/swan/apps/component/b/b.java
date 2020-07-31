package com.baidu.swan.apps.component.b;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.swan.apps.aq.ai;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String bVk;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a bVp;
    private String bVq;
    public String bVl = "";
    public String bVm = "";
    public String bVn = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean bVo = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.bVk = "unknown";
        this.bVq = "id";
        if (!TextUtils.isEmpty(str)) {
            this.bVk = str;
        } else {
            com.baidu.swan.apps.component.e.a.aV("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.bVq = str2;
        } else {
            com.baidu.swan.apps.component.e.a.aV("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bVp != null) {
            bVar.bVp = (com.baidu.swan.apps.model.a.a.a) this.bVp.clone();
        } else {
            bVar.bVp = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bVl = jSONObject.optString(this.bVq);
            if (TextUtils.isEmpty(this.bVl)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bVk + " component componentId is empty");
            }
            this.bVm = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.bVm)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bVk + " component slaveId is empty");
            }
            this.bVn = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.bVo = TextUtils.equals(jSONObject.optString("gesture"), "1");
            aD(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.bVl = jSONObject.optString(this.bVq, bVar.bVl);
            if (TextUtils.isEmpty(this.bVl)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bVk + " component componentId is empty");
            }
            this.bVm = jSONObject.optString("slaveId", bVar.bVm);
            if (TextUtils.isEmpty(this.bVm)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bVk + " component slaveId is empty");
            }
            this.bVn = jSONObject.optString("parentId", bVar.bVn);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.bVo = TextUtils.equals(jSONObject.optString("gesture", bVar.bVo ? "1" : "0"), "1");
            this.bVp = bVar.bVp;
            if (this.bVp == null) {
                this.bVp = new com.baidu.swan.apps.model.a.a.a();
            }
            aD(jSONObject);
        }
    }

    public void aB(JSONObject jSONObject) {
        this.bVl = jSONObject.optString(this.bVq, this.bVl);
        if (TextUtils.isEmpty(this.bVl)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bVk + " component componentId is empty");
        }
        this.bVm = jSONObject.optString("slaveId", this.bVm);
        if (TextUtils.isEmpty(this.bVm)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bVk + " component slaveId is empty");
        }
        this.bVn = jSONObject.optString("parentId", this.bVn);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.bVo = TextUtils.equals(jSONObject.optString("gesture", this.bVo ? "1" : "0"), "1");
        aD(jSONObject);
    }

    private void aD(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.bVp = new com.baidu.swan.apps.model.a.a.a();
            this.bVp.gs(ai.D(getFloat(optJSONObject, "left", 0.0f)));
            this.bVp.gt(ai.D(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.bVp.setWidth(ai.D(getFloat(optJSONObject, "width", 0.0f)));
            this.bVp.setHeight(ai.D(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bVl) || TextUtils.isEmpty(this.bVm) || this.bVp == null || !this.bVp.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.bVk + "', componentId='" + this.bVl + "', slaveId='" + this.bVm + "', parentId='" + this.bVn + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.bVo + ", position=" + this.bVp + ", mComponentIdKey='" + this.bVq + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.bVk + "#" + (TextUtils.isEmpty(this.bVl) ? "" : this.bVl) + "】";
    }

    public final FrameLayout.LayoutParams Xc() {
        int width = this.bVp != null ? this.bVp.getWidth() : -1;
        int height = this.bVp != null ? this.bVp.getHeight() : -1;
        int left = this.bVp != null ? this.bVp.getLeft() : 0;
        int top = this.bVp != null ? this.bVp.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
