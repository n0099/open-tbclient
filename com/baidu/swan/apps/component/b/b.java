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
    public String bGM;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a bGR;
    private String bGS;
    public String bGN = "";
    public String bGO = "";
    public String bGP = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean bGQ = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.bGM = "unknown";
        this.bGS = "id";
        if (!TextUtils.isEmpty(str)) {
            this.bGM = str;
        } else {
            com.baidu.swan.apps.component.e.a.aC("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.bGS = str2;
        } else {
            com.baidu.swan.apps.component.e.a.aC("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bGR != null) {
            bVar.bGR = (com.baidu.swan.apps.model.a.a.a) this.bGR.clone();
        } else {
            bVar.bGR = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bGN = jSONObject.optString(this.bGS);
            if (TextUtils.isEmpty(this.bGN)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGM + " component componentId is empty");
            }
            this.bGO = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.bGO)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGM + " component slaveId is empty");
            }
            this.bGP = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.bGQ = TextUtils.equals(jSONObject.optString("gesture"), "1");
            al(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.bGN = jSONObject.optString(this.bGS, bVar.bGN);
            if (TextUtils.isEmpty(this.bGN)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGM + " component componentId is empty");
            }
            this.bGO = jSONObject.optString("slaveId", bVar.bGO);
            if (TextUtils.isEmpty(this.bGO)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGM + " component slaveId is empty");
            }
            this.bGP = jSONObject.optString("parentId", bVar.bGP);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.bGQ = TextUtils.equals(jSONObject.optString("gesture", bVar.bGQ ? "1" : "0"), "1");
            this.bGR = bVar.bGR;
            if (this.bGR == null) {
                this.bGR = new com.baidu.swan.apps.model.a.a.a();
            }
            al(jSONObject);
        }
    }

    public void aj(JSONObject jSONObject) {
        this.bGN = jSONObject.optString(this.bGS, this.bGN);
        if (TextUtils.isEmpty(this.bGN)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGM + " component componentId is empty");
        }
        this.bGO = jSONObject.optString("slaveId", this.bGO);
        if (TextUtils.isEmpty(this.bGO)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGM + " component slaveId is empty");
        }
        this.bGP = jSONObject.optString("parentId", this.bGP);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.bGQ = TextUtils.equals(jSONObject.optString("gesture", this.bGQ ? "1" : "0"), "1");
        al(jSONObject);
    }

    private void al(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.bGR = new com.baidu.swan.apps.model.a.a.a();
            this.bGR.fF(af.C(getFloat(optJSONObject, "left", 0.0f)));
            this.bGR.fG(af.C(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.bGR.setWidth(af.C(getFloat(optJSONObject, "width", 0.0f)));
            this.bGR.setHeight(af.C(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bGN) || TextUtils.isEmpty(this.bGO) || this.bGR == null || !this.bGR.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.bGM + "', componentId='" + this.bGN + "', slaveId='" + this.bGO + "', parentId='" + this.bGP + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.bGQ + ", position=" + this.bGR + ", mComponentIdKey='" + this.bGS + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.bGM + "#" + (TextUtils.isEmpty(this.bGN) ? "" : this.bGN) + "】";
    }

    public final FrameLayout.LayoutParams SE() {
        int width = this.bGR != null ? this.bGR.getWidth() : -1;
        int height = this.bGR != null ? this.bGR.getHeight() : -1;
        int left = this.bGR != null ? this.bGR.getLeft() : 0;
        int top2 = this.bGR != null ? this.bGR.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top2, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
