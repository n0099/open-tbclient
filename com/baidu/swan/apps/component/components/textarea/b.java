package com.baidu.swan.apps.component.components.textarea;

import com.baidu.swan.apps.as.af;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    public int bjh;
    public String bji;
    public String bjj;
    public boolean bjk;
    public boolean bjl;
    public boolean bjm;
    public boolean bjn;
    public boolean bjo;
    public int bjp;
    public boolean bjq;
    public String hint;
    public int maxHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.bji = "";
        this.bjj = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString("placeholder");
            ad(jSONObject);
            this.bjk = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.bjl = jSONObject.optBoolean("autoHeight", false);
            if (this.bjl && this.biq != null) {
                this.biq.setHeight(-2);
                this.biq.dc(true);
            }
            this.bjm = jSONObject.optBoolean("fixed");
            if (this.biq != null) {
                this.biq.dd(this.bjm);
            }
            this.bjn = jSONObject.optBoolean("showConfirmBar", true);
            this.bjo = jSONObject.optBoolean("adjustPosition", true);
            this.bjq = jSONObject.optBoolean("disabled", false);
            KA();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        this.bjq = jSONObject.optBoolean("disabled", this.bjq);
        this.hint = jSONObject.optString("placeholder", this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.bjk = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.bjk);
        this.bjn = jSONObject.optBoolean("showConfirmBar", this.bjn);
        this.bjo = jSONObject.optBoolean("adjustPosition", this.bjo);
        ac(jSONObject);
        ab(jSONObject);
        ad(jSONObject);
        KA();
    }

    private void ab(JSONObject jSONObject) {
        this.bjm = jSONObject.optBoolean("fixed", this.bjm);
        if (this.biq != null) {
            this.biq.dd(this.bjm);
        }
    }

    private void ac(JSONObject jSONObject) {
        this.bjl = jSONObject.optBoolean("autoHeight", this.bjl);
        if (this.biq != null) {
            if (this.bjl) {
                this.biq.setHeight(-2);
                this.biq.dc(true);
                return;
            }
            int height = this.biq.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.biq.setHeight(height);
            this.biq.dc(false);
        }
    }

    private void KA() {
        if (this.bhU != null) {
            int S = af.S(getFloat(this.bhU, "minHeight", 0.0f));
            if (S < 0) {
                S = 0;
            }
            this.bjp = S;
            int S2 = af.S(getFloat(this.bhU, "maxHeight", 2.1474836E9f));
            if (S2 < 0) {
                S2 = Integer.MAX_VALUE;
            }
            this.maxHeight = S2;
        }
    }

    private void ad(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.bjh = optJSONObject.optInt("fontSize");
            this.bji = optJSONObject.optString("fontWeight");
            this.bjj = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ce(boolean z) {
        this.bjk = z;
    }
}
