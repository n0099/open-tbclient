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
/* loaded from: classes8.dex */
public abstract class b implements com.baidu.swan.apps.component.b.a.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    public String cJb;
    @Nullable
    public com.baidu.swan.apps.model.a.a.a cJg;
    private String cJh;
    public String cJc = "";
    public String cJd = "";
    public String cJe = "";
    public String callback = "";
    public boolean hidden = false;
    public boolean cJf = false;

    public b(@NonNull String str, @NonNull String str2) {
        this.cJb = "unknown";
        this.cJh = "id";
        if (!TextUtils.isEmpty(str)) {
            this.cJb = str;
        } else {
            com.baidu.swan.apps.component.e.a.bq("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.cJh = str2;
        } else {
            com.baidu.swan.apps.component.e.a.bq("Component-Model-Base", "component id key is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.cJg != null) {
            bVar.cJg = (com.baidu.swan.apps.model.a.a.a) this.cJg.clone();
        } else {
            bVar.cJg = null;
        }
        return bVar;
    }

    @Override // com.baidu.swan.apps.model.a
    @CallSuper
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cJc = jSONObject.optString(this.cJh);
            if (TextUtils.isEmpty(this.cJc)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cJb + " component componentId is empty");
            }
            this.cJd = jSONObject.optString("slaveId");
            if (TextUtils.isEmpty(this.cJd)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cJb + " component slaveId is empty");
            }
            this.cJe = jSONObject.optString("parentId");
            this.callback = jSONObject.optString("cb");
            this.hidden = jSONObject.optBoolean("hide", false);
            this.cJf = TextUtils.equals(jSONObject.optString("gesture"), "1");
            bg(jSONObject);
        }
    }

    public final void a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject != null) {
            this.cJc = jSONObject.optString(this.cJh, bVar.cJc);
            if (TextUtils.isEmpty(this.cJc)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cJb + " component componentId is empty");
            }
            this.cJd = jSONObject.optString("slaveId", bVar.cJd);
            if (TextUtils.isEmpty(this.cJd)) {
                com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cJb + " component slaveId is empty");
            }
            this.cJe = jSONObject.optString("parentId", bVar.cJe);
            this.callback = jSONObject.optString("cb", bVar.callback);
            this.hidden = jSONObject.optBoolean("hide", bVar.hidden);
            this.cJf = TextUtils.equals(jSONObject.optString("gesture", bVar.cJf ? "1" : "0"), "1");
            this.cJg = bVar.cJg;
            if (this.cJg == null) {
                this.cJg = new com.baidu.swan.apps.model.a.a.a();
            }
            bg(jSONObject);
        }
    }

    public void be(JSONObject jSONObject) {
        this.cJc = jSONObject.optString(this.cJh, this.cJc);
        if (TextUtils.isEmpty(this.cJc)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cJb + " component componentId is empty");
        }
        this.cJd = jSONObject.optString("slaveId", this.cJd);
        if (TextUtils.isEmpty(this.cJd)) {
            com.baidu.swan.apps.console.c.e("Component-Model-Base", this.cJb + " component slaveId is empty");
        }
        this.cJe = jSONObject.optString("parentId", this.cJe);
        this.callback = jSONObject.optString("cb", this.callback);
        this.hidden = jSONObject.optBoolean("hide", this.hidden);
        this.cJf = TextUtils.equals(jSONObject.optString("gesture", this.cJf ? "1" : "0"), "1");
        bg(jSONObject);
    }

    private void bg(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            this.cJg = new com.baidu.swan.apps.model.a.a.a();
            this.cJg.ij(ah.O(getFloat(optJSONObject, "left", 0.0f)));
            this.cJg.ik(ah.O(getFloat(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
            this.cJg.setWidth(ah.O(getFloat(optJSONObject, "width", 0.0f)));
            this.cJg.setHeight(ah.O(getFloat(optJSONObject, "height", 0.0f)));
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cJc) || TextUtils.isEmpty(this.cJd) || this.cJg == null || !this.cJg.isValid()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.cJb + "', componentId='" + this.cJc + "', slaveId='" + this.cJd + "', parentId='" + this.cJe + "', callback='" + this.callback + "', hidden=" + this.hidden + ", gesture=" + this.cJf + ", position=" + this.cJg + ", mComponentIdKey='" + this.cJh + "'}";
    }

    @NonNull
    public final String getName() {
        return "【" + this.cJb + "#" + (TextUtils.isEmpty(this.cJc) ? "" : this.cJc) + "】";
    }

    public final FrameLayout.LayoutParams akM() {
        int width = this.cJg != null ? this.cJg.getWidth() : -1;
        int height = this.cJg != null ? this.cJg.getHeight() : -1;
        int left = this.cJg != null ? this.cJg.getLeft() : 0;
        int aCg = this.cJg != null ? this.cJg.aCg() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, aCg, 0, 0);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
