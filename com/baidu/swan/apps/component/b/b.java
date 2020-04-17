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
    public String bGH;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a bGM;
    private String bGN;
    public String bGI = "";
    public String bGJ = "";
    public String bGK = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean bGL = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.bGH = "unknown";
        this.bGN = "id";
        if (!TextUtils.isEmpty(str)) {
            this.bGH = str;
        } else {
            com.baidu.swan.apps.component.e.a.aC("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.bGN = str2;
        } else {
            com.baidu.swan.apps.component.e.a.aC("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.bGM != null) {
            bVar.bGM = (com.baidu.swan.apps.model.a.a.a) this.bGM.clone();
        } else {
            bVar.bGM = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bGI = jSONObject.optString(this.bGN);
            if (TextUtils.isEmpty(this.bGI)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGH + " component componentId is empty");
            }
            this.bGJ = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.bGJ)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGH + " component slaveId is empty");
            }
            this.bGK = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.bGL = TextUtils.equals(jSONObject.optString("gesture"), "1");
            al(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.bGI = jSONObject.optString(this.bGN, bVar.bGI);
            if (TextUtils.isEmpty(this.bGI)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGH + " component componentId is empty");
            }
            this.bGJ = jSONObject.optString("slaveId", bVar.bGJ);
            if (TextUtils.isEmpty(this.bGJ)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGH + " component slaveId is empty");
            }
            this.bGK = jSONObject.optString("parentId", bVar.bGK);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.bGL = TextUtils.equals(jSONObject.optString("gesture", bVar.bGL ? "1" : "0"), "1");
            this.bGM = bVar.bGM;
            if (this.bGM == null) {
                this.bGM = new com.baidu.swan.apps.model.a.a.a();
            }
            al(jSONObject);
        }
    }

    public void aj(JSONObject jSONObject) {
        this.bGI = jSONObject.optString(this.bGN, this.bGI);
        if (TextUtils.isEmpty(this.bGI)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGH + " component componentId is empty");
        }
        this.bGJ = jSONObject.optString("slaveId", this.bGJ);
        if (TextUtils.isEmpty(this.bGJ)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.bGH + " component slaveId is empty");
        }
        this.bGK = jSONObject.optString("parentId", this.bGK);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.bGL = TextUtils.equals(jSONObject.optString("gesture", this.bGL ? "1" : "0"), "1");
        al(jSONObject);
    }

    private void al(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.bGM = new com.baidu.swan.apps.model.a.a.a();
            this.bGM.fF(af.C(getFloat(optJSONObject, "left", 0.0f)));
            this.bGM.fG(af.C(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.bGM.setWidth(af.C(getFloat(optJSONObject, "width", 0.0f)));
            this.bGM.setHeight(af.C(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bGI) || TextUtils.isEmpty(this.bGJ) || this.bGM == null || !this.bGM.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.bGH + "', componentId='" + this.bGI + "', slaveId='" + this.bGJ + "', parentId='" + this.bGK + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.bGL + ", position=" + this.bGM + ", mComponentIdKey='" + this.bGN + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.bGH + "#" + (TextUtils.isEmpty(this.bGI) ? "" : this.bGI) + "】";
    }

    public final FrameLayout.LayoutParams SF() {
        int width = this.bGM != null ? this.bGM.getWidth() : -1;
        int height = this.bGM != null ? this.bGM.getHeight() : -1;
        int left = this.bGM != null ? this.bGM.getLeft() : 0;
        int top2 = this.bGM != null ? this.bGM.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top2, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
