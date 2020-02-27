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
/* loaded from: classes11.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String bij;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a bip;
    private String biq;
    public String bik = "";
    public String bil = "";
    public String bim = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean bin = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.bij = "unknown";
        this.biq = "id";
        if (!TextUtils.isEmpty(str)) {
            this.bij = str;
        } else {
            com.baidu.swan.apps.component.e.a.au("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.biq = str2;
        } else {
            com.baidu.swan.apps.component.e.a.au("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bip != null) {
            bVar.bip = (com.baidu.swan.apps.model.a.a.a) this.bip.clone();
        } else {
            bVar.bip = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bik = jSONObject.optString(this.biq);
            if (TextUtils.isEmpty(this.bik)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bij + " component componentId is empty");
            }
            this.bil = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.bil)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bij + " component slaveId is empty");
            }
            this.bim = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.bin = TextUtils.equals(jSONObject.optString("gesture"), "1");
            aa(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.bik = jSONObject.optString(this.biq, bVar.bik);
            if (TextUtils.isEmpty(this.bik)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bij + " component componentId is empty");
            }
            this.bil = jSONObject.optString("slaveId", bVar.bil);
            if (TextUtils.isEmpty(this.bil)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bij + " component slaveId is empty");
            }
            this.bim = jSONObject.optString("parentId", bVar.bim);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.bin = TextUtils.equals(jSONObject.optString("gesture", bVar.bin ? "1" : "0"), "1");
            this.bip = bVar.bip;
            if (this.bip == null) {
                this.bip = new com.baidu.swan.apps.model.a.a.a();
            }
            aa(jSONObject);
        }
    }

    public void Y(JSONObject jSONObject) {
        this.bik = jSONObject.optString(this.biq, this.bik);
        if (TextUtils.isEmpty(this.bik)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bij + " component componentId is empty");
        }
        this.bil = jSONObject.optString("slaveId", this.bil);
        if (TextUtils.isEmpty(this.bil)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bij + " component slaveId is empty");
        }
        this.bim = jSONObject.optString("parentId", this.bim);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.bin = TextUtils.equals(jSONObject.optString("gesture", this.bin ? "1" : "0"), "1");
        aa(jSONObject);
    }

    private void aa(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.bip = new com.baidu.swan.apps.model.a.a.a();
            this.bip.fy(af.S(getFloat(optJSONObject, "left", 0.0f)));
            this.bip.fz(af.S(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.bip.setWidth(af.S(getFloat(optJSONObject, "width", 0.0f)));
            this.bip.setHeight(af.S(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bik) || TextUtils.isEmpty(this.bil) || this.bip == null || !this.bip.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.bij + "', componentId='" + this.bik + "', slaveId='" + this.bil + "', parentId='" + this.bim + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.bin + ", position=" + this.bip + ", mComponentIdKey='" + this.biq + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.bij + "#" + (TextUtils.isEmpty(this.bik) ? "" : this.bik) + "】";
    }

    public final FrameLayout.LayoutParams KM() {
        int width = this.bip != null ? this.bip.getWidth() : -1;
        int height = this.bip != null ? this.bip.getHeight() : -1;
        int left = this.bip != null ? this.bip.getLeft() : 0;
        int top2 = this.bip != null ? this.bip.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top2, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
