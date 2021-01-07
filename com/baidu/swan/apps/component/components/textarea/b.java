package com.baidu.swan.apps.component.components.textarea;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.swan.apps.ao.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    public int cOL;
    public String cOM;
    public String cON;
    public boolean cOO;
    public boolean cOP;
    public boolean cOQ;
    public boolean cOR;
    public boolean cOS;
    public boolean cOT;
    boolean cOz;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cOM = "";
        this.cON = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString("placeholder");
            bj(jSONObject);
            this.cOO = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cOP = jSONObject.optBoolean("autoHeight", false);
            if (this.cOP && this.cNS != null) {
                this.cNS.setHeight(-2);
                this.cNS.gm(true);
            }
            this.cOQ = jSONObject.optBoolean("fixed");
            if (this.cNS != null) {
                this.cNS.gn(this.cOQ);
            }
            this.cOR = jSONObject.optBoolean("showConfirmBar", true);
            this.cOS = jSONObject.optBoolean("adjustPosition", true);
            this.cOT = jSONObject.optBoolean("disabled", false);
            this.cOz = jSONObject.optInt("confirmHold") == 1;
            aos();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void be(JSONObject jSONObject) {
        super.be(jSONObject);
        this.cOT = jSONObject.optBoolean("disabled", this.cOT);
        this.hint = jSONObject.optString("placeholder", this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cOO = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cOO);
        this.cOR = jSONObject.optBoolean("showConfirmBar", this.cOR);
        this.cOS = jSONObject.optBoolean("adjustPosition", this.cOS);
        bi(jSONObject);
        bh(jSONObject);
        bj(jSONObject);
        aos();
    }

    private void bh(JSONObject jSONObject) {
        this.cOQ = jSONObject.optBoolean("fixed", this.cOQ);
        if (this.cNS != null) {
            this.cNS.gn(this.cOQ);
        }
    }

    private void bi(JSONObject jSONObject) {
        this.cOP = jSONObject.optBoolean("autoHeight", this.cOP);
        if (this.cNS != null) {
            if (this.cOP) {
                this.cNS.setHeight(-2);
                this.cNS.gm(true);
                return;
            }
            int height = this.cNS.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.cNS.setHeight(height);
            this.cNS.gm(false);
        }
    }

    private void aos() {
        if (this.cNz != null) {
            int O = ah.O(getFloat(this.cNz, "minHeight", 0.0f));
            if (O < 0) {
                O = 0;
            }
            this.minHeight = O;
            int O2 = ah.O(getFloat(this.cNz, "maxHeight", 2.1474836E9f));
            if (O2 < 0) {
                O2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = O2;
        }
    }

    private void bj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cOL = optJSONObject.optInt("fontSize");
            this.cOM = optJSONObject.optString("fontWeight");
            this.cON = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eX(boolean z) {
        this.cOO = z;
    }
}
