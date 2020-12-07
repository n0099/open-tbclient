package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean cJE;
    public int cJQ;
    public String cJR;
    public String cJS;
    public boolean cJT;
    public boolean cJU;
    public boolean cJV;
    public boolean cJW;
    public boolean cJX;
    public boolean cJY;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cJR = "";
        this.cJS = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            bb(jSONObject);
            this.cJT = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cJU = jSONObject.optBoolean("autoHeight", false);
            if (this.cJU && this.cIZ != null) {
                this.cIZ.setHeight(-2);
                this.cIZ.gd(true);
            }
            this.cJV = jSONObject.optBoolean("fixed");
            if (this.cIZ != null) {
                this.cIZ.ge(this.cJV);
            }
            this.cJW = jSONObject.optBoolean("showConfirmBar", true);
            this.cJX = jSONObject.optBoolean("adjustPosition", true);
            this.cJY = jSONObject.optBoolean("disabled", false);
            this.cJE = jSONObject.optInt("confirmHold") == 1;
            ani();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aW(JSONObject jSONObject) {
        super.aW(jSONObject);
        this.cJY = jSONObject.optBoolean("disabled", this.cJY);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cJT = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cJT);
        this.cJW = jSONObject.optBoolean("showConfirmBar", this.cJW);
        this.cJX = jSONObject.optBoolean("adjustPosition", this.cJX);
        ba(jSONObject);
        aZ(jSONObject);
        bb(jSONObject);
        ani();
    }

    private void aZ(JSONObject jSONObject) {
        this.cJV = jSONObject.optBoolean("fixed", this.cJV);
        if (this.cIZ != null) {
            this.cIZ.ge(this.cJV);
        }
    }

    private void ba(JSONObject jSONObject) {
        this.cJU = jSONObject.optBoolean("autoHeight", this.cJU);
        if (this.cIZ != null) {
            if (this.cJU) {
                this.cIZ.setHeight(-2);
                this.cIZ.gd(true);
                return;
            }
            int height = this.cIZ.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.cIZ.setHeight(height);
            this.cIZ.gd(false);
        }
    }

    private void ani() {
        if (this.cIG != null) {
            int M = ah.M(getFloat(this.cIG, "minHeight", 0.0f));
            if (M < 0) {
                M = 0;
            }
            this.minHeight = M;
            int M2 = ah.M(getFloat(this.cIG, "maxHeight", 2.1474836E9f));
            if (M2 < 0) {
                M2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = M2;
        }
    }

    private void bb(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cJQ = optJSONObject.optInt("fontSize");
            this.cJR = optJSONObject.optString("fontWeight");
            this.cJS = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eO(boolean z) {
        this.cJT = z;
    }
}
