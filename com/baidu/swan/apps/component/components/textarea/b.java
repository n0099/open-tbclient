package com.baidu.swan.apps.component.components.textarea;

import com.baidu.swan.apps.ao.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean cMb;
    public int cMn;
    public String cMo;
    public String cMp;
    public boolean cMq;
    public boolean cMr;
    public boolean cMs;
    public boolean cMt;
    public boolean cMu;
    public boolean cMv;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cMo = "";
        this.cMp = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString("placeholder");
            bg(jSONObject);
            this.cMq = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cMr = jSONObject.optBoolean("autoHeight", false);
            if (this.cMr && this.cLu != null) {
                this.cLu.setHeight(-2);
                this.cLu.gk(true);
            }
            this.cMs = jSONObject.optBoolean("fixed");
            if (this.cLu != null) {
                this.cLu.gl(this.cMs);
            }
            this.cMt = jSONObject.optBoolean("showConfirmBar", true);
            this.cMu = jSONObject.optBoolean("adjustPosition", true);
            this.cMv = jSONObject.optBoolean("disabled", false);
            this.cMb = jSONObject.optInt("confirmHold") == 1;
            akW();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void bb(JSONObject jSONObject) {
        super.bb(jSONObject);
        this.cMv = jSONObject.optBoolean("disabled", this.cMv);
        this.hint = jSONObject.optString("placeholder", this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cMq = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cMq);
        this.cMt = jSONObject.optBoolean("showConfirmBar", this.cMt);
        this.cMu = jSONObject.optBoolean("adjustPosition", this.cMu);
        bf(jSONObject);
        be(jSONObject);
        bg(jSONObject);
        akW();
    }

    private void be(JSONObject jSONObject) {
        this.cMs = jSONObject.optBoolean("fixed", this.cMs);
        if (this.cLu != null) {
            this.cLu.gl(this.cMs);
        }
    }

    private void bf(JSONObject jSONObject) {
        this.cMr = jSONObject.optBoolean("autoHeight", this.cMr);
        if (this.cLu != null) {
            if (this.cMr) {
                this.cLu.setHeight(-2);
                this.cLu.gk(true);
                return;
            }
            int height = this.cLu.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.cLu.setHeight(height);
            this.cLu.gk(false);
        }
    }

    private void akW() {
        if (this.cLb != null) {
            int P = ah.P(getFloat(this.cLb, "minHeight", 0.0f));
            if (P < 0) {
                P = 0;
            }
            this.minHeight = P;
            int P2 = ah.P(getFloat(this.cLb, "maxHeight", 2.1474836E9f));
            if (P2 < 0) {
                P2 = Integer.MAX_VALUE;
            }
            this.maxHeight = P2;
        }
    }

    private void bg(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cMn = optJSONObject.optInt("fontSize");
            this.cMo = optJSONObject.optString("fontWeight");
            this.cMp = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eV(boolean z) {
        this.cMq = z;
    }
}
