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
/* loaded from: classes9.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String cLp;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a cLu;
    private String cLv;
    public String cLq = "";
    public String cLr = "";
    public String cLs = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean cLt = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.cLp = "unknown";
        this.cLv = "id";
        if (!TextUtils.isEmpty(str)) {
            this.cLp = str;
        } else {
            com.baidu.swan.apps.component.e.a.bk("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.cLv = str2;
        } else {
            com.baidu.swan.apps.component.e.a.bk("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cLu != null) {
            bVar.cLu = (com.baidu.swan.apps.model.a.a.a) this.cLu.clone();
        } else {
            bVar.cLu = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cLq = jSONObject.optString(this.cLv);
            if (TextUtils.isEmpty(this.cLq)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cLp + " component componentId is empty");
            }
            this.cLr = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.cLr)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cLp + " component slaveId is empty");
            }
            this.cLs = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.cLt = TextUtils.equals(jSONObject.optString("gesture"), "1");
            bd(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.cLq = jSONObject.optString(this.cLv, bVar.cLq);
            if (TextUtils.isEmpty(this.cLq)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cLp + " component componentId is empty");
            }
            this.cLr = jSONObject.optString("slaveId", bVar.cLr);
            if (TextUtils.isEmpty(this.cLr)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cLp + " component slaveId is empty");
            }
            this.cLs = jSONObject.optString("parentId", bVar.cLs);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.cLt = TextUtils.equals(jSONObject.optString("gesture", bVar.cLt ? "1" : "0"), "1");
            this.cLu = bVar.cLu;
            if (this.cLu == null) {
                this.cLu = new com.baidu.swan.apps.model.a.a.a();
            }
            bd(jSONObject);
        }
    }

    public void bb(JSONObject jSONObject) {
        this.cLq = jSONObject.optString(this.cLv, this.cLq);
        if (TextUtils.isEmpty(this.cLq)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cLp + " component componentId is empty");
        }
        this.cLr = jSONObject.optString("slaveId", this.cLr);
        if (TextUtils.isEmpty(this.cLr)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cLp + " component slaveId is empty");
        }
        this.cLs = jSONObject.optString("parentId", this.cLs);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.cLt = TextUtils.equals(jSONObject.optString("gesture", this.cLt ? "1" : "0"), "1");
        bd(jSONObject);
    }

    private void bd(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.cLu = new com.baidu.swan.apps.model.a.a.a();
            this.cLu.im(ah.P(getFloat(optJSONObject, "left", 0.0f)));
            this.cLu.in(ah.P(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.cLu.setWidth(ah.P(getFloat(optJSONObject, "width", 0.0f)));
            this.cLu.setHeight(ah.P(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cLq) || TextUtils.isEmpty(this.cLr) || this.cLu == null || !this.cLu.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.cLp + "', componentId='" + this.cLq + "', slaveId='" + this.cLr + "', parentId='" + this.cLs + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.cLt + ", position=" + this.cLu + ", mComponentIdKey='" + this.cLv + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.cLp + "#" + (TextUtils.isEmpty(this.cLq) ? "" : this.cLq) + "】";
    }

    public final FrameLayout.LayoutParams alk() {
        int width = this.cLu != null ? this.cLu.getWidth() : -1;
        int height = this.cLu != null ? this.cLu.getHeight() : -1;
        int left = this.cLu != null ? this.cLu.getLeft() : 0;
        int top = this.cLu != null ? this.cLu.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
