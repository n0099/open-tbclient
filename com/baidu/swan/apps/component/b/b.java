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
/* loaded from: classes9.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String bdg;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a bdl;
    private String bdm;
    public String bdh = "";
    public String bdi = "";
    public String bdj = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean bdk = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.bdg = "unknown";
        this.bdm = "id";
        if (!TextUtils.isEmpty(str)) {
            this.bdg = str;
        } else {
            com.baidu.swan.apps.component.e.a.aj("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.bdm = str2;
        } else {
            com.baidu.swan.apps.component.e.a.aj("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bdl != null) {
            bVar.bdl = (com.baidu.swan.apps.model.a.a.a) this.bdl.clone();
        } else {
            bVar.bdl = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bdh = jSONObject.optString(this.bdm);
            if (TextUtils.isEmpty(this.bdh)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdg + " component componentId is empty");
            }
            this.bdi = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.bdi)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdg + " component slaveId is empty");
            }
            this.bdj = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.bdk = TextUtils.equals(jSONObject.optString("gesture"), "1");
            aa(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.bdh = jSONObject.optString(this.bdm, bVar.bdh);
            if (TextUtils.isEmpty(this.bdh)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdg + " component componentId is empty");
            }
            this.bdi = jSONObject.optString("slaveId", bVar.bdi);
            if (TextUtils.isEmpty(this.bdi)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdg + " component slaveId is empty");
            }
            this.bdj = jSONObject.optString("parentId", bVar.bdj);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.bdk = TextUtils.equals(jSONObject.optString("gesture", bVar.bdk ? "1" : "0"), "1");
            this.bdl = bVar.bdl;
            if (this.bdl == null) {
                this.bdl = new com.baidu.swan.apps.model.a.a.a();
            }
            aa(jSONObject);
        }
    }

    public void Y(JSONObject jSONObject) {
        this.bdh = jSONObject.optString(this.bdm, this.bdh);
        if (TextUtils.isEmpty(this.bdh)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdg + " component componentId is empty");
        }
        this.bdi = jSONObject.optString("slaveId", this.bdi);
        if (TextUtils.isEmpty(this.bdi)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bdg + " component slaveId is empty");
        }
        this.bdj = jSONObject.optString("parentId", this.bdj);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.bdk = TextUtils.equals(jSONObject.optString("gesture", this.bdk ? "1" : "0"), "1");
        aa(jSONObject);
    }

    private void aa(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.bdl = new com.baidu.swan.apps.model.a.a.a();
            this.bdl.fh(af.T(getFloat(optJSONObject, "left", 0.0f)));
            this.bdl.fi(af.T(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.bdl.setWidth(af.T(getFloat(optJSONObject, "width", 0.0f)));
            this.bdl.setHeight(af.T(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bdh) || TextUtils.isEmpty(this.bdi) || this.bdl == null || !this.bdl.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.bdg + "', componentId='" + this.bdh + "', slaveId='" + this.bdi + "', parentId='" + this.bdj + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.bdk + ", position=" + this.bdl + ", mComponentIdKey='" + this.bdm + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.bdg + "#" + (TextUtils.isEmpty(this.bdh) ? "" : this.bdh) + "】";
    }

    public final FrameLayout.LayoutParams Ib() {
        int width = this.bdl != null ? this.bdl.getWidth() : -1;
        int height = this.bdl != null ? this.bdl.getHeight() : -1;
        int left = this.bdl != null ? this.bdl.getLeft() : 0;
        int top = this.bdl != null ? this.bdl.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
