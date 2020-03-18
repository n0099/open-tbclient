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
    @Nullable
    public com.baidu.swan.apps.model.a.a.a biE;
    private String biF;
    @NonNull
    public String biz;
    public String biA = "";
    public String biB = "";
    public String biC = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean biD = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.biz = "unknown";
        this.biF = "id";
        if (!TextUtils.isEmpty(str)) {
            this.biz = str;
        } else {
            com.baidu.swan.apps.component.e.a.at("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.biF = str2;
        } else {
            com.baidu.swan.apps.component.e.a.at("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.biE != null) {
            bVar.biE = (com.baidu.swan.apps.model.a.a.a) this.biE.clone();
        } else {
            bVar.biE = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.biA = jSONObject.optString(this.biF);
            if (TextUtils.isEmpty(this.biA)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.biz + " component componentId is empty");
            }
            this.biB = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.biB)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.biz + " component slaveId is empty");
            }
            this.biC = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.biD = TextUtils.equals(jSONObject.optString("gesture"), "1");
            aa(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.biA = jSONObject.optString(this.biF, bVar.biA);
            if (TextUtils.isEmpty(this.biA)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.biz + " component componentId is empty");
            }
            this.biB = jSONObject.optString("slaveId", bVar.biB);
            if (TextUtils.isEmpty(this.biB)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.biz + " component slaveId is empty");
            }
            this.biC = jSONObject.optString("parentId", bVar.biC);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.biD = TextUtils.equals(jSONObject.optString("gesture", bVar.biD ? "1" : "0"), "1");
            this.biE = bVar.biE;
            if (this.biE == null) {
                this.biE = new com.baidu.swan.apps.model.a.a.a();
            }
            aa(jSONObject);
        }
    }

    public void Y(JSONObject jSONObject) {
        this.biA = jSONObject.optString(this.biF, this.biA);
        if (TextUtils.isEmpty(this.biA)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.biz + " component componentId is empty");
        }
        this.biB = jSONObject.optString("slaveId", this.biB);
        if (TextUtils.isEmpty(this.biB)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.biz + " component slaveId is empty");
        }
        this.biC = jSONObject.optString("parentId", this.biC);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.biD = TextUtils.equals(jSONObject.optString("gesture", this.biD ? "1" : "0"), "1");
        aa(jSONObject);
    }

    private void aa(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.biE = new com.baidu.swan.apps.model.a.a.a();
            this.biE.fy(af.S(getFloat(optJSONObject, "left", 0.0f)));
            this.biE.fz(af.S(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.biE.setWidth(af.S(getFloat(optJSONObject, "width", 0.0f)));
            this.biE.setHeight(af.S(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.biA) || TextUtils.isEmpty(this.biB) || this.biE == null || !this.biE.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.biz + "', componentId='" + this.biA + "', slaveId='" + this.biB + "', parentId='" + this.biC + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.biD + ", position=" + this.biE + ", mComponentIdKey='" + this.biF + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.biz + "#" + (TextUtils.isEmpty(this.biA) ? "" : this.biA) + "】";
    }

    public final FrameLayout.LayoutParams KR() {
        int width = this.biE != null ? this.biE.getWidth() : -1;
        int height = this.biE != null ? this.biE.getHeight() : -1;
        int left = this.biE != null ? this.biE.getLeft() : 0;
        int top2 = this.biE != null ? this.biE.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top2, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
