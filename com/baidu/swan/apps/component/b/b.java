package com.baidu.swan.apps.component.b;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.swan.apps.ao.ah;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String cMP;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a cMU;
    private String cMV;
    public String cMQ = "";
    public String cMR = "";
    public String cMS = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean cMT = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.cMP = "unknown";
        this.cMV = "id";
        if (!TextUtils.isEmpty(str)) {
            this.cMP = str;
        } else {
            com.baidu.swan.apps.component.e.a.bk("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.cMV = str2;
        } else {
            com.baidu.swan.apps.component.e.a.bk("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cMU != null) {
            bVar.cMU = (com.baidu.swan.apps.model.a.a.a) this.cMU.clone();
        } else {
            bVar.cMU = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cMQ = jSONObject.optString(this.cMV);
            if (TextUtils.isEmpty(this.cMQ)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cMP + " component componentId is empty");
            }
            this.cMR = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.cMR)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cMP + " component slaveId is empty");
            }
            this.cMS = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.cMT = TextUtils.equals(jSONObject.optString("gesture"), "1");
            bf(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.cMQ = jSONObject.optString(this.cMV, bVar.cMQ);
            if (TextUtils.isEmpty(this.cMQ)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cMP + " component componentId is empty");
            }
            this.cMR = jSONObject.optString("slaveId", bVar.cMR);
            if (TextUtils.isEmpty(this.cMR)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cMP + " component slaveId is empty");
            }
            this.cMS = jSONObject.optString("parentId", bVar.cMS);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.cMT = TextUtils.equals(jSONObject.optString("gesture", bVar.cMT ? "1" : "0"), "1");
            this.cMU = bVar.cMU;
            if (this.cMU == null) {
                this.cMU = new com.baidu.swan.apps.model.a.a.a();
            }
            bf(jSONObject);
        }
    }

    public void bd(JSONObject jSONObject) {
        this.cMQ = jSONObject.optString(this.cMV, this.cMQ);
        if (TextUtils.isEmpty(this.cMQ)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cMP + " component componentId is empty");
        }
        this.cMR = jSONObject.optString("slaveId", this.cMR);
        if (TextUtils.isEmpty(this.cMR)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cMP + " component slaveId is empty");
        }
        this.cMS = jSONObject.optString("parentId", this.cMS);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.cMT = TextUtils.equals(jSONObject.optString("gesture", this.cMT ? "1" : "0"), "1");
        bf(jSONObject);
    }

    private void bf(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.cMU = new com.baidu.swan.apps.model.a.a.a();
            this.cMU.in(ah.T(getFloat(optJSONObject, "left", 0.0f)));
            this.cMU.io(ah.T(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.cMU.setWidth(ah.T(getFloat(optJSONObject, "width", 0.0f)));
            this.cMU.setHeight(ah.T(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cMQ) || TextUtils.isEmpty(this.cMR) || this.cMU == null || !this.cMU.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.cMP + "', componentId='" + this.cMQ + "', slaveId='" + this.cMR + "', parentId='" + this.cMS + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.cMT + ", position=" + this.cMU + ", mComponentIdKey='" + this.cMV + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.cMP + "#" + (TextUtils.isEmpty(this.cMQ) ? "" : this.cMQ) + "】";
    }

    public final FrameLayout.LayoutParams aln() {
        int width = this.cMU != null ? this.cMU.getWidth() : -1;
        int height = this.cMU != null ? this.cMU.getHeight() : -1;
        int left = this.cMU != null ? this.cMU.getLeft() : 0;
        int top = this.cMU != null ? this.cMU.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
