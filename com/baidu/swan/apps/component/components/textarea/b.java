package com.baidu.swan.apps.component.components.textarea;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.swan.apps.ao.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean cJN;
    public int cJZ;
    public String cKa;
    public String cKb;
    public boolean cKc;
    public boolean cKd;
    public boolean cKe;
    public boolean cKf;
    public boolean cKg;
    public boolean cKh;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cKa = "";
        this.cKb = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString("placeholder");
            bj(jSONObject);
            this.cKc = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cKd = jSONObject.optBoolean("autoHeight", false);
            if (this.cKd && this.cJg != null) {
                this.cJg.setHeight(-2);
                this.cJg.gi(true);
            }
            this.cKe = jSONObject.optBoolean("fixed");
            if (this.cJg != null) {
                this.cJg.gj(this.cKe);
            }
            this.cKf = jSONObject.optBoolean("showConfirmBar", true);
            this.cKg = jSONObject.optBoolean("adjustPosition", true);
            this.cKh = jSONObject.optBoolean("disabled", false);
            this.cJN = jSONObject.optInt("confirmHold") == 1;
            aky();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void be(JSONObject jSONObject) {
        super.be(jSONObject);
        this.cKh = jSONObject.optBoolean("disabled", this.cKh);
        this.hint = jSONObject.optString("placeholder", this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cKc = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cKc);
        this.cKf = jSONObject.optBoolean("showConfirmBar", this.cKf);
        this.cKg = jSONObject.optBoolean("adjustPosition", this.cKg);
        bi(jSONObject);
        bh(jSONObject);
        bj(jSONObject);
        aky();
    }

    private void bh(JSONObject jSONObject) {
        this.cKe = jSONObject.optBoolean("fixed", this.cKe);
        if (this.cJg != null) {
            this.cJg.gj(this.cKe);
        }
    }

    private void bi(JSONObject jSONObject) {
        this.cKd = jSONObject.optBoolean("autoHeight", this.cKd);
        if (this.cJg != null) {
            if (this.cKd) {
                this.cJg.setHeight(-2);
                this.cJg.gi(true);
                return;
            }
            int height = this.cJg.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.cJg.setHeight(height);
            this.cJg.gi(false);
        }
    }

    private void aky() {
        if (this.cIN != null) {
            int O = ah.O(getFloat(this.cIN, "minHeight", 0.0f));
            if (O < 0) {
                O = 0;
            }
            this.minHeight = O;
            int O2 = ah.O(getFloat(this.cIN, "maxHeight", 2.1474836E9f));
            if (O2 < 0) {
                O2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = O2;
        }
    }

    private void bj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cJZ = optJSONObject.optInt("fontSize");
            this.cKa = optJSONObject.optString("fontWeight");
            this.cKb = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eT(boolean z) {
        this.cKc = z;
    }
}
