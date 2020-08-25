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
    public String caS;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a caX;
    private String caY;
    public String caT = "";
    public String caU = "";
    public String caV = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean caW = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.caS = "unknown";
        this.caY = "id";
        if (!TextUtils.isEmpty(str)) {
            this.caS = str;
        } else {
            com.baidu.swan.apps.component.e.a.ba("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.caY = str2;
        } else {
            com.baidu.swan.apps.component.e.a.ba("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.caX != null) {
            bVar.caX = (com.baidu.swan.apps.model.a.a.a) this.caX.clone();
        } else {
            bVar.caX = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.caT = jSONObject.optString(this.caY);
            if (TextUtils.isEmpty(this.caT)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caS + " component componentId is empty");
            }
            this.caU = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.caU)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caS + " component slaveId is empty");
            }
            this.caV = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.caW = TextUtils.equals(jSONObject.optString("gesture"), "1");
            aJ(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.caT = jSONObject.optString(this.caY, bVar.caT);
            if (TextUtils.isEmpty(this.caT)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caS + " component componentId is empty");
            }
            this.caU = jSONObject.optString("slaveId", bVar.caU);
            if (TextUtils.isEmpty(this.caU)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caS + " component slaveId is empty");
            }
            this.caV = jSONObject.optString("parentId", bVar.caV);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.caW = TextUtils.equals(jSONObject.optString("gesture", bVar.caW ? "1" : "0"), "1");
            this.caX = bVar.caX;
            if (this.caX == null) {
                this.caX = new com.baidu.swan.apps.model.a.a.a();
            }
            aJ(jSONObject);
        }
    }

    public void aH(JSONObject jSONObject) {
        this.caT = jSONObject.optString(this.caY, this.caT);
        if (TextUtils.isEmpty(this.caT)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caS + " component componentId is empty");
        }
        this.caU = jSONObject.optString("slaveId", this.caU);
        if (TextUtils.isEmpty(this.caU)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.caS + " component slaveId is empty");
        }
        this.caV = jSONObject.optString("parentId", this.caV);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.caW = TextUtils.equals(jSONObject.optString("gesture", this.caW ? "1" : "0"), "1");
        aJ(jSONObject);
    }

    private void aJ(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.caX = new com.baidu.swan.apps.model.a.a.a();
            this.caX.iy(ah.H(getFloat(optJSONObject, "left", 0.0f)));
            this.caX.iz(ah.H(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.caX.setWidth(ah.H(getFloat(optJSONObject, "width", 0.0f)));
            this.caX.setHeight(ah.H(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.caT) || TextUtils.isEmpty(this.caU) || this.caX == null || !this.caX.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.caS + "', componentId='" + this.caT + "', slaveId='" + this.caU + "', parentId='" + this.caV + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.caW + ", position=" + this.caX + ", mComponentIdKey='" + this.caY + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.caS + "#" + (TextUtils.isEmpty(this.caT) ? "" : this.caT) + "】";
    }

    public final FrameLayout.LayoutParams adi() {
        int width = this.caX != null ? this.caX.getWidth() : -1;
        int height = this.caX != null ? this.caX.getHeight() : -1;
        int left = this.caX != null ? this.caX.getLeft() : 0;
        int top = this.caX != null ? this.caX.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
