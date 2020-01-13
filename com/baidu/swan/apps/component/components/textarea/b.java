package com.baidu.swan.apps.component.components.textarea;

import com.baidu.swan.apps.as.af;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    public int beS;
    public String beT;
    public String beU;
    public boolean beV;
    public boolean beW;
    public boolean beX;
    public boolean beY;
    public int beZ;
    public boolean bfa;
    public boolean fixed;
    public String hint;
    public int maxHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.beT = "";
        this.beU = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString("placeholder");
            ad(jSONObject);
            this.beV = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.beW = jSONObject.optBoolean("autoHeight", false);
            if (this.beW && this.bdZ != null) {
                this.bdZ.setHeight(-2);
                this.bdZ.cV(true);
            }
            this.fixed = jSONObject.optBoolean("fixed");
            if (this.bdZ != null) {
                this.bdZ.cW(this.fixed);
            }
            this.beX = jSONObject.optBoolean("showConfirmBar", true);
            this.beY = jSONObject.optBoolean("adjustPosition", true);
            this.bfa = jSONObject.optBoolean("disabled", false);
            Ij();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        this.bfa = jSONObject.optBoolean("disabled", this.bfa);
        this.hint = jSONObject.optString("placeholder", this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.beV = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.beV);
        this.beX = jSONObject.optBoolean("showConfirmBar", this.beX);
        this.beY = jSONObject.optBoolean("adjustPosition", this.beY);
        ac(jSONObject);
        ab(jSONObject);
        ad(jSONObject);
        Ij();
    }

    private void ab(JSONObject jSONObject) {
        this.fixed = jSONObject.optBoolean("fixed", this.fixed);
        if (this.bdZ != null) {
            this.bdZ.cW(this.fixed);
        }
    }

    private void ac(JSONObject jSONObject) {
        this.beW = jSONObject.optBoolean("autoHeight", this.beW);
        if (this.bdZ != null) {
            if (this.beW) {
                this.bdZ.setHeight(-2);
                this.bdZ.cV(true);
                return;
            }
            int height = this.bdZ.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.bdZ.setHeight(height);
            this.bdZ.cV(false);
        }
    }

    private void Ij() {
        if (this.bdG != null) {
            int S = af.S(getFloat(this.bdG, "minHeight", 0.0f));
            if (S < 0) {
                S = 0;
            }
            this.beZ = S;
            int S2 = af.S(getFloat(this.bdG, "maxHeight", 2.1474836E9f));
            if (S2 < 0) {
                S2 = Integer.MAX_VALUE;
            }
            this.maxHeight = S2;
        }
    }

    private void ad(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.beS = optJSONObject.optInt("fontSize");
            this.beT = optJSONObject.optString("fontWeight");
            this.beU = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bW(boolean z) {
        this.beV = z;
    }
}
