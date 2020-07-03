package com.baidu.swan.apps.component.b;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.swan.apps.aq.ag;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String bUs;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a bUx;
    private String bUy;
    public String bUt = "";
    public String bUu = "";
    public String bUv = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean bUw = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.bUs = "unknown";
        this.bUy = "id";
        if (!TextUtils.isEmpty(str)) {
            this.bUs = str;
        } else {
            com.baidu.swan.apps.component.e.a.aU("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.bUy = str2;
        } else {
            com.baidu.swan.apps.component.e.a.aU("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bUx != null) {
            bVar.bUx = (com.baidu.swan.apps.model.a.a.a) this.bUx.clone();
        } else {
            bVar.bUx = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bUt = jSONObject.optString(this.bUy);
            if (TextUtils.isEmpty(this.bUt)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bUs + " component componentId is empty");
            }
            this.bUu = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.bUu)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bUs + " component slaveId is empty");
            }
            this.bUv = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.bUw = TextUtils.equals(jSONObject.optString("gesture"), "1");
            aA(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.bUt = jSONObject.optString(this.bUy, bVar.bUt);
            if (TextUtils.isEmpty(this.bUt)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bUs + " component componentId is empty");
            }
            this.bUu = jSONObject.optString("slaveId", bVar.bUu);
            if (TextUtils.isEmpty(this.bUu)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bUs + " component slaveId is empty");
            }
            this.bUv = jSONObject.optString("parentId", bVar.bUv);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.bUw = TextUtils.equals(jSONObject.optString("gesture", bVar.bUw ? "1" : "0"), "1");
            this.bUx = bVar.bUx;
            if (this.bUx == null) {
                this.bUx = new com.baidu.swan.apps.model.a.a.a();
            }
            aA(jSONObject);
        }
    }

    public void ay(JSONObject jSONObject) {
        this.bUt = jSONObject.optString(this.bUy, this.bUt);
        if (TextUtils.isEmpty(this.bUt)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bUs + " component componentId is empty");
        }
        this.bUu = jSONObject.optString("slaveId", this.bUu);
        if (TextUtils.isEmpty(this.bUu)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bUs + " component slaveId is empty");
        }
        this.bUv = jSONObject.optString("parentId", this.bUv);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.bUw = TextUtils.equals(jSONObject.optString("gesture", this.bUw ? "1" : "0"), "1");
        aA(jSONObject);
    }

    private void aA(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.bUx = new com.baidu.swan.apps.model.a.a.a();
            this.bUx.gh(ag.D(getFloat(optJSONObject, "left", 0.0f)));
            this.bUx.gi(ag.D(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.bUx.setWidth(ag.D(getFloat(optJSONObject, "width", 0.0f)));
            this.bUx.setHeight(ag.D(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bUt) || TextUtils.isEmpty(this.bUu) || this.bUx == null || !this.bUx.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.bUs + "', componentId='" + this.bUt + "', slaveId='" + this.bUu + "', parentId='" + this.bUv + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.bUw + ", position=" + this.bUx + ", mComponentIdKey='" + this.bUy + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.bUs + "#" + (TextUtils.isEmpty(this.bUt) ? "" : this.bUt) + "】";
    }

    public final FrameLayout.LayoutParams Wv() {
        int width = this.bUx != null ? this.bUx.getWidth() : -1;
        int height = this.bUx != null ? this.bUx.getHeight() : -1;
        int left = this.bUx != null ? this.bUx.getLeft() : 0;
        int top2 = this.bUx != null ? this.bUx.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top2, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
