package com.baidu.swan.apps.component.b;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.appframework.AppFrameworkConstants;
import com.baidu.swan.apps.ap.ah;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String cDJ;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a cDO;
    private String cDP;
    public String cDK = "";
    public String cDL = "";
    public String cDM = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean cDN = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.cDJ = "unknown";
        this.cDP = "id";
        if (!TextUtils.isEmpty(str)) {
            this.cDJ = str;
        } else {
            com.baidu.swan.apps.component.e.a.bm("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.cDP = str2;
        } else {
            com.baidu.swan.apps.component.e.a.bm("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cDO != null) {
            bVar.cDO = (com.baidu.swan.apps.model.a.a.a) this.cDO.clone();
        } else {
            bVar.cDO = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cDK = jSONObject.optString(this.cDP);
            if (TextUtils.isEmpty(this.cDK)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cDJ + " component componentId is empty");
            }
            this.cDL = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.cDL)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cDJ + " component slaveId is empty");
            }
            this.cDM = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.cDN = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK), "1");
            bc(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.cDK = jSONObject.optString(this.cDP, bVar.cDK);
            if (TextUtils.isEmpty(this.cDK)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cDJ + " component componentId is empty");
            }
            this.cDL = jSONObject.optString("slaveId", bVar.cDL);
            if (TextUtils.isEmpty(this.cDL)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cDJ + " component slaveId is empty");
            }
            this.cDM = jSONObject.optString("parentId", bVar.cDM);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.cDN = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, bVar.cDN ? "1" : "0"), "1");
            this.cDO = bVar.cDO;
            if (this.cDO == null) {
                this.cDO = new com.baidu.swan.apps.model.a.a.a();
            }
            bc(jSONObject);
        }
    }

    public void ba(JSONObject jSONObject) {
        this.cDK = jSONObject.optString(this.cDP, this.cDK);
        if (TextUtils.isEmpty(this.cDK)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cDJ + " component componentId is empty");
        }
        this.cDL = jSONObject.optString("slaveId", this.cDL);
        if (TextUtils.isEmpty(this.cDL)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cDJ + " component slaveId is empty");
        }
        this.cDM = jSONObject.optString("parentId", this.cDM);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.cDN = TextUtils.equals(jSONObject.optString(AppFrameworkConstants.VALUE_GESTURE_BACK, this.cDN ? "1" : "0"), "1");
        bc(jSONObject);
    }

    private void bc(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.cDO = new com.baidu.swan.apps.model.a.a.a();
            this.cDO.jA(ah.N(getFloat(optJSONObject, "left", 0.0f)));
            this.cDO.jB(ah.N(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.cDO.setWidth(ah.N(getFloat(optJSONObject, "width", 0.0f)));
            this.cDO.setHeight(ah.N(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cDK) || TextUtils.isEmpty(this.cDL) || this.cDO == null || !this.cDO.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.cDJ + "', componentId='" + this.cDK + "', slaveId='" + this.cDL + "', parentId='" + this.cDM + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.cDN + ", position=" + this.cDO + ", mComponentIdKey='" + this.cDP + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.cDJ + "#" + (TextUtils.isEmpty(this.cDK) ? "" : this.cDK) + "】";
    }

    public final FrameLayout.LayoutParams akW() {
        int width = this.cDO != null ? this.cDO.getWidth() : -1;
        int height = this.cDO != null ? this.cDO.getHeight() : -1;
        int left = this.cDO != null ? this.cDO.getLeft() : 0;
        int top = this.cDO != null ? this.cDO.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
