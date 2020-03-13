package com.baidu.swan.apps.component.components.textarea;

import com.baidu.swan.apps.as.af;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    public int bji;
    public String bjj;
    public String bjk;
    public boolean bjl;
    public boolean bjm;
    public boolean bjn;
    public boolean bjo;
    public boolean bjp;
    public int bjq;
    public boolean bjr;
    public String hint;
    public int maxHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.bjj = "";
        this.bjk = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString("placeholder");
            ad(jSONObject);
            this.bjl = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.bjm = jSONObject.optBoolean("autoHeight", false);
            if (this.bjm && this.bir != null) {
                this.bir.setHeight(-2);
                this.bir.dc(true);
            }
            this.bjn = jSONObject.optBoolean("fixed");
            if (this.bir != null) {
                this.bir.dd(this.bjn);
            }
            this.bjo = jSONObject.optBoolean("showConfirmBar", true);
            this.bjp = jSONObject.optBoolean("adjustPosition", true);
            this.bjr = jSONObject.optBoolean("disabled", false);
            KA();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        this.bjr = jSONObject.optBoolean("disabled", this.bjr);
        this.hint = jSONObject.optString("placeholder", this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.bjl = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.bjl);
        this.bjo = jSONObject.optBoolean("showConfirmBar", this.bjo);
        this.bjp = jSONObject.optBoolean("adjustPosition", this.bjp);
        ac(jSONObject);
        ab(jSONObject);
        ad(jSONObject);
        KA();
    }

    private void ab(JSONObject jSONObject) {
        this.bjn = jSONObject.optBoolean("fixed", this.bjn);
        if (this.bir != null) {
            this.bir.dd(this.bjn);
        }
    }

    private void ac(JSONObject jSONObject) {
        this.bjm = jSONObject.optBoolean("autoHeight", this.bjm);
        if (this.bir != null) {
            if (this.bjm) {
                this.bir.setHeight(-2);
                this.bir.dc(true);
                return;
            }
            int height = this.bir.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.bir.setHeight(height);
            this.bir.dc(false);
        }
    }

    private void KA() {
        if (this.bhV != null) {
            int S = af.S(getFloat(this.bhV, "minHeight", 0.0f));
            if (S < 0) {
                S = 0;
            }
            this.bjq = S;
            int S2 = af.S(getFloat(this.bhV, "maxHeight", 2.1474836E9f));
            if (S2 < 0) {
                S2 = Integer.MAX_VALUE;
            }
            this.maxHeight = S2;
        }
    }

    private void ad(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.bji = optJSONObject.optInt("fontSize");
            this.bjj = optJSONObject.optString("fontWeight");
            this.bjk = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ce(boolean z) {
        this.bjl = z;
    }
}
