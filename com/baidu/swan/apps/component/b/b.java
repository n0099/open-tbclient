package com.baidu.swan.apps.component.b;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.swan.apps.ao.ah;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String cNN;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a cNS;
    private String cNT;
    public String cNO = "";
    public String cNP = "";
    public String cNQ = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean cNR = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.cNN = "unknown";
        this.cNT = "id";
        if (!TextUtils.isEmpty(str)) {
            this.cNN = str;
        } else {
            com.baidu.swan.apps.component.e.a.br("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.cNT = str2;
        } else {
            com.baidu.swan.apps.component.e.a.br("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cNS != null) {
            bVar.cNS = (com.baidu.swan.apps.model.a.a.a) this.cNS.clone();
        } else {
            bVar.cNS = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cNO = jSONObject.optString(this.cNT);
            if (TextUtils.isEmpty(this.cNO)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cNN + " component componentId is empty");
            }
            this.cNP = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.cNP)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cNN + " component slaveId is empty");
            }
            this.cNQ = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.cNR = TextUtils.equals(jSONObject.optString("gesture"), "1");
            bg(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.cNO = jSONObject.optString(this.cNT, bVar.cNO);
            if (TextUtils.isEmpty(this.cNO)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cNN + " component componentId is empty");
            }
            this.cNP = jSONObject.optString("slaveId", bVar.cNP);
            if (TextUtils.isEmpty(this.cNP)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cNN + " component slaveId is empty");
            }
            this.cNQ = jSONObject.optString("parentId", bVar.cNQ);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.cNR = TextUtils.equals(jSONObject.optString("gesture", bVar.cNR ? "1" : "0"), "1");
            this.cNS = bVar.cNS;
            if (this.cNS == null) {
                this.cNS = new com.baidu.swan.apps.model.a.a.a();
            }
            bg(jSONObject);
        }
    }

    public void be(JSONObject jSONObject) {
        this.cNO = jSONObject.optString(this.cNT, this.cNO);
        if (TextUtils.isEmpty(this.cNO)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cNN + " component componentId is empty");
        }
        this.cNP = jSONObject.optString("slaveId", this.cNP);
        if (TextUtils.isEmpty(this.cNP)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cNN + " component slaveId is empty");
        }
        this.cNQ = jSONObject.optString("parentId", this.cNQ);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.cNR = TextUtils.equals(jSONObject.optString("gesture", this.cNR ? "1" : "0"), "1");
        bg(jSONObject);
    }

    private void bg(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.cNS = new com.baidu.swan.apps.model.a.a.a();
            this.cNS.jP(ah.O(getFloat(optJSONObject, "left", 0.0f)));
            this.cNS.jQ(ah.O(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.cNS.setWidth(ah.O(getFloat(optJSONObject, "width", 0.0f)));
            this.cNS.setHeight(ah.O(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cNO) || TextUtils.isEmpty(this.cNP) || this.cNS == null || !this.cNS.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.cNN + "', componentId='" + this.cNO + "', slaveId='" + this.cNP + "', parentId='" + this.cNQ + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.cNR + ", position=" + this.cNS + ", mComponentIdKey='" + this.cNT + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.cNN + "#" + (TextUtils.isEmpty(this.cNO) ? "" : this.cNO) + "】";
    }

    public final FrameLayout.LayoutParams aoG() {
        int width = this.cNS != null ? this.cNS.getWidth() : -1;
        int height = this.cNS != null ? this.cNS.getHeight() : -1;
        int left = this.cNS != null ? this.cNS.getLeft() : 0;
        int aGa = this.cNS != null ? this.cNS.aGa() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, aGa, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
