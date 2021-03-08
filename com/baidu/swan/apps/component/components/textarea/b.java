package com.baidu.swan.apps.component.components.textarea;

import com.baidu.swan.apps.ao.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean cNB;
    public int cNN;
    public String cNO;
    public String cNP;
    public boolean cNQ;
    public boolean cNR;
    public boolean cNS;
    public boolean cNT;
    public boolean cNU;
    public boolean cNV;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cNO = "";
        this.cNP = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString("placeholder");
            bi(jSONObject);
            this.cNQ = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cNR = jSONObject.optBoolean("autoHeight", false);
            if (this.cNR && this.cMU != null) {
                this.cMU.setHeight(-2);
                this.cMU.gk(true);
            }
            this.cNS = jSONObject.optBoolean("fixed");
            if (this.cMU != null) {
                this.cMU.gl(this.cNS);
            }
            this.cNT = jSONObject.optBoolean("showConfirmBar", true);
            this.cNU = jSONObject.optBoolean("adjustPosition", true);
            this.cNV = jSONObject.optBoolean("disabled", false);
            this.cNB = jSONObject.optInt("confirmHold") == 1;
            akZ();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void bd(JSONObject jSONObject) {
        super.bd(jSONObject);
        this.cNV = jSONObject.optBoolean("disabled", this.cNV);
        this.hint = jSONObject.optString("placeholder", this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cNQ = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cNQ);
        this.cNT = jSONObject.optBoolean("showConfirmBar", this.cNT);
        this.cNU = jSONObject.optBoolean("adjustPosition", this.cNU);
        bh(jSONObject);
        bg(jSONObject);
        bi(jSONObject);
        akZ();
    }

    private void bg(JSONObject jSONObject) {
        this.cNS = jSONObject.optBoolean("fixed", this.cNS);
        if (this.cMU != null) {
            this.cMU.gl(this.cNS);
        }
    }

    private void bh(JSONObject jSONObject) {
        this.cNR = jSONObject.optBoolean("autoHeight", this.cNR);
        if (this.cMU != null) {
            if (this.cNR) {
                this.cMU.setHeight(-2);
                this.cMU.gk(true);
                return;
            }
            int height = this.cMU.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.cMU.setHeight(height);
            this.cMU.gk(false);
        }
    }

    private void akZ() {
        if (this.cMB != null) {
            int T = ah.T(getFloat(this.cMB, "minHeight", 0.0f));
            if (T < 0) {
                T = 0;
            }
            this.minHeight = T;
            int T2 = ah.T(getFloat(this.cMB, "maxHeight", 2.1474836E9f));
            if (T2 < 0) {
                T2 = Integer.MAX_VALUE;
            }
            this.maxHeight = T2;
        }
    }

    private void bi(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cNN = optJSONObject.optInt("fontSize");
            this.cNO = optJSONObject.optString("fontWeight");
            this.cNP = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eV(boolean z) {
        this.cNQ = z;
    }
}
