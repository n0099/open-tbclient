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
    public String bPE;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a bPJ;
    private String bPK;
    public String bPF = "";
    public String bPG = "";
    public String bPH = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean bPI = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.bPE = "unknown";
        this.bPK = "id";
        if (!TextUtils.isEmpty(str)) {
            this.bPE = str;
        } else {
            com.baidu.swan.apps.component.e.a.aS("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.bPK = str2;
        } else {
            com.baidu.swan.apps.component.e.a.aS("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bPJ != null) {
            bVar.bPJ = (com.baidu.swan.apps.model.a.a.a) this.bPJ.clone();
        } else {
            bVar.bPJ = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bPF = jSONObject.optString(this.bPK);
            if (TextUtils.isEmpty(this.bPF)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bPE + " component componentId is empty");
            }
            this.bPG = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.bPG)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bPE + " component slaveId is empty");
            }
            this.bPH = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.bPI = TextUtils.equals(jSONObject.optString("gesture"), "1");
            at(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.bPF = jSONObject.optString(this.bPK, bVar.bPF);
            if (TextUtils.isEmpty(this.bPF)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bPE + " component componentId is empty");
            }
            this.bPG = jSONObject.optString("slaveId", bVar.bPG);
            if (TextUtils.isEmpty(this.bPG)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bPE + " component slaveId is empty");
            }
            this.bPH = jSONObject.optString("parentId", bVar.bPH);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.bPI = TextUtils.equals(jSONObject.optString("gesture", bVar.bPI ? "1" : "0"), "1");
            this.bPJ = bVar.bPJ;
            if (this.bPJ == null) {
                this.bPJ = new com.baidu.swan.apps.model.a.a.a();
            }
            at(jSONObject);
        }
    }

    public void ar(JSONObject jSONObject) {
        this.bPF = jSONObject.optString(this.bPK, this.bPF);
        if (TextUtils.isEmpty(this.bPF)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bPE + " component componentId is empty");
        }
        this.bPG = jSONObject.optString("slaveId", this.bPG);
        if (TextUtils.isEmpty(this.bPG)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bPE + " component slaveId is empty");
        }
        this.bPH = jSONObject.optString("parentId", this.bPH);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.bPI = TextUtils.equals(jSONObject.optString("gesture", this.bPI ? "1" : "0"), "1");
        at(jSONObject);
    }

    private void at(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.bPJ = new com.baidu.swan.apps.model.a.a.a();
            this.bPJ.fW(ag.B(getFloat(optJSONObject, "left", 0.0f)));
            this.bPJ.fX(ag.B(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.bPJ.setWidth(ag.B(getFloat(optJSONObject, "width", 0.0f)));
            this.bPJ.setHeight(ag.B(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bPF) || TextUtils.isEmpty(this.bPG) || this.bPJ == null || !this.bPJ.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.bPE + "', componentId='" + this.bPF + "', slaveId='" + this.bPG + "', parentId='" + this.bPH + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.bPI + ", position=" + this.bPJ + ", mComponentIdKey='" + this.bPK + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.bPE + "#" + (TextUtils.isEmpty(this.bPF) ? "" : this.bPF) + "】";
    }

    public final FrameLayout.LayoutParams Vp() {
        int width = this.bPJ != null ? this.bPJ.getWidth() : -1;
        int height = this.bPJ != null ? this.bPJ.getHeight() : -1;
        int left = this.bPJ != null ? this.bPJ.getLeft() : 0;
        int top2 = this.bPJ != null ? this.bPJ.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top2, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
