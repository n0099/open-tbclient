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
    public String bil;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a bir;
    private String bis;
    public String bim = "";
    public String bin = "";
    public String bip = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean biq = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.bil = "unknown";
        this.bis = "id";
        if (!TextUtils.isEmpty(str)) {
            this.bil = str;
        } else {
            com.baidu.swan.apps.component.e.a.au("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.bis = str2;
        } else {
            com.baidu.swan.apps.component.e.a.au("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bir != null) {
            bVar.bir = (com.baidu.swan.apps.model.a.a.a) this.bir.clone();
        } else {
            bVar.bir = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bim = jSONObject.optString(this.bis);
            if (TextUtils.isEmpty(this.bim)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bil + " component componentId is empty");
            }
            this.bin = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.bin)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bil + " component slaveId is empty");
            }
            this.bip = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.biq = TextUtils.equals(jSONObject.optString("gesture"), "1");
            aa(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.bim = jSONObject.optString(this.bis, bVar.bim);
            if (TextUtils.isEmpty(this.bim)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bil + " component componentId is empty");
            }
            this.bin = jSONObject.optString("slaveId", bVar.bin);
            if (TextUtils.isEmpty(this.bin)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bil + " component slaveId is empty");
            }
            this.bip = jSONObject.optString("parentId", bVar.bip);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.biq = TextUtils.equals(jSONObject.optString("gesture", bVar.biq ? "1" : "0"), "1");
            this.bir = bVar.bir;
            if (this.bir == null) {
                this.bir = new com.baidu.swan.apps.model.a.a.a();
            }
            aa(jSONObject);
        }
    }

    public void Y(JSONObject jSONObject) {
        this.bim = jSONObject.optString(this.bis, this.bim);
        if (TextUtils.isEmpty(this.bim)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bil + " component componentId is empty");
        }
        this.bin = jSONObject.optString("slaveId", this.bin);
        if (TextUtils.isEmpty(this.bin)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bil + " component slaveId is empty");
        }
        this.bip = jSONObject.optString("parentId", this.bip);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.biq = TextUtils.equals(jSONObject.optString("gesture", this.biq ? "1" : "0"), "1");
        aa(jSONObject);
    }

    private void aa(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.bir = new com.baidu.swan.apps.model.a.a.a();
            this.bir.fy(af.S(getFloat(optJSONObject, "left", 0.0f)));
            this.bir.fz(af.S(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.bir.setWidth(af.S(getFloat(optJSONObject, "width", 0.0f)));
            this.bir.setHeight(af.S(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bim) || TextUtils.isEmpty(this.bin) || this.bir == null || !this.bir.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.bil + "', componentId='" + this.bim + "', slaveId='" + this.bin + "', parentId='" + this.bip + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.biq + ", position=" + this.bir + ", mComponentIdKey='" + this.bis + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.bil + "#" + (TextUtils.isEmpty(this.bim) ? "" : this.bim) + "】";
    }

    public final FrameLayout.LayoutParams KO() {
        int width = this.bir != null ? this.bir.getWidth() : -1;
        int height = this.bir != null ? this.bir.getHeight() : -1;
        int left = this.bir != null ? this.bir.getLeft() : 0;
        int top2 = this.bir != null ? this.bir.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top2, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
