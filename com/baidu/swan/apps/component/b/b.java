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
    public String bik;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a biq;
    private String bir;
    public String bil = "";
    public String bim = "";
    public String bin = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean bip = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.bik = "unknown";
        this.bir = "id";
        if (!TextUtils.isEmpty(str)) {
            this.bik = str;
        } else {
            com.baidu.swan.apps.component.e.a.au("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.bir = str2;
        } else {
            com.baidu.swan.apps.component.e.a.au("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.biq != null) {
            bVar.biq = (com.baidu.swan.apps.model.a.a.a) this.biq.clone();
        } else {
            bVar.biq = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bil = jSONObject.optString(this.bir);
            if (TextUtils.isEmpty(this.bil)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bik + " component componentId is empty");
            }
            this.bim = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.bim)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bik + " component slaveId is empty");
            }
            this.bin = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.bip = TextUtils.equals(jSONObject.optString("gesture"), "1");
            aa(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.bil = jSONObject.optString(this.bir, bVar.bil);
            if (TextUtils.isEmpty(this.bil)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bik + " component componentId is empty");
            }
            this.bim = jSONObject.optString("slaveId", bVar.bim);
            if (TextUtils.isEmpty(this.bim)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bik + " component slaveId is empty");
            }
            this.bin = jSONObject.optString("parentId", bVar.bin);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.bip = TextUtils.equals(jSONObject.optString("gesture", bVar.bip ? "1" : "0"), "1");
            this.biq = bVar.biq;
            if (this.biq == null) {
                this.biq = new com.baidu.swan.apps.model.a.a.a();
            }
            aa(jSONObject);
        }
    }

    public void Y(JSONObject jSONObject) {
        this.bil = jSONObject.optString(this.bir, this.bil);
        if (TextUtils.isEmpty(this.bil)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bik + " component componentId is empty");
        }
        this.bim = jSONObject.optString("slaveId", this.bim);
        if (TextUtils.isEmpty(this.bim)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bik + " component slaveId is empty");
        }
        this.bin = jSONObject.optString("parentId", this.bin);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.bip = TextUtils.equals(jSONObject.optString("gesture", this.bip ? "1" : "0"), "1");
        aa(jSONObject);
    }

    private void aa(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.biq = new com.baidu.swan.apps.model.a.a.a();
            this.biq.fy(af.S(getFloat(optJSONObject, "left", 0.0f)));
            this.biq.fz(af.S(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.biq.setWidth(af.S(getFloat(optJSONObject, "width", 0.0f)));
            this.biq.setHeight(af.S(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bil) || TextUtils.isEmpty(this.bim) || this.biq == null || !this.biq.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.bik + "', componentId='" + this.bil + "', slaveId='" + this.bim + "', parentId='" + this.bin + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.bip + ", position=" + this.biq + ", mComponentIdKey='" + this.bir + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.bik + "#" + (TextUtils.isEmpty(this.bil) ? "" : this.bil) + "】";
    }

    public final FrameLayout.LayoutParams KO() {
        int width = this.biq != null ? this.biq.getWidth() : -1;
        int height = this.biq != null ? this.biq.getHeight() : -1;
        int left = this.biq != null ? this.biq.getLeft() : 0;
        int top2 = this.biq != null ? this.biq.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top2, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
