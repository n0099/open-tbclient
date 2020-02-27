package com.baidu.swan.apps.component.components.textarea;

import com.baidu.swan.apps.as.af;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    public int bjg;
    public String bjh;
    public String bji;
    public boolean bjj;
    public boolean bjk;
    public boolean bjl;
    public boolean bjm;
    public boolean bjn;
    public int bjo;
    public boolean bjp;
    public String hint;
    public int maxHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.bjh = "";
        this.bji = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString("placeholder");
            ad(jSONObject);
            this.bjj = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.bjk = jSONObject.optBoolean("autoHeight", false);
            if (this.bjk && this.bip != null) {
                this.bip.setHeight(-2);
                this.bip.dc(true);
            }
            this.bjl = jSONObject.optBoolean("fixed");
            if (this.bip != null) {
                this.bip.dd(this.bjl);
            }
            this.bjm = jSONObject.optBoolean("showConfirmBar", true);
            this.bjn = jSONObject.optBoolean("adjustPosition", true);
            this.bjp = jSONObject.optBoolean("disabled", false);
            Ky();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        this.bjp = jSONObject.optBoolean("disabled", this.bjp);
        this.hint = jSONObject.optString("placeholder", this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.bjj = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.bjj);
        this.bjm = jSONObject.optBoolean("showConfirmBar", this.bjm);
        this.bjn = jSONObject.optBoolean("adjustPosition", this.bjn);
        ac(jSONObject);
        ab(jSONObject);
        ad(jSONObject);
        Ky();
    }

    private void ab(JSONObject jSONObject) {
        this.bjl = jSONObject.optBoolean("fixed", this.bjl);
        if (this.bip != null) {
            this.bip.dd(this.bjl);
        }
    }

    private void ac(JSONObject jSONObject) {
        this.bjk = jSONObject.optBoolean("autoHeight", this.bjk);
        if (this.bip != null) {
            if (this.bjk) {
                this.bip.setHeight(-2);
                this.bip.dc(true);
                return;
            }
            int height = this.bip.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.bip.setHeight(height);
            this.bip.dc(false);
        }
    }

    private void Ky() {
        if (this.bhT != null) {
            int S = af.S(getFloat(this.bhT, "minHeight", 0.0f));
            if (S < 0) {
                S = 0;
            }
            this.bjo = S;
            int S2 = af.S(getFloat(this.bhT, "maxHeight", 2.1474836E9f));
            if (S2 < 0) {
                S2 = Integer.MAX_VALUE;
            }
            this.maxHeight = S2;
        }
    }

    private void ad(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.bjg = optJSONObject.optInt("fontSize");
            this.bjh = optJSONObject.optString("fontWeight");
            this.bji = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ce(boolean z) {
        this.bjj = z;
    }
}
