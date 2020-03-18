package com.baidu.swan.apps.component.components.textarea;

import com.baidu.swan.apps.as.af;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    public boolean bjA;
    public boolean bjB;
    public boolean bjC;
    public int bjD;
    public boolean bjE;
    public int bjv;
    public String bjw;
    public String bjx;
    public boolean bjy;
    public boolean bjz;
    public String hint;
    public int maxHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.bjw = "";
        this.bjx = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString("placeholder");
            ad(jSONObject);
            this.bjy = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.bjz = jSONObject.optBoolean("autoHeight", false);
            if (this.bjz && this.biE != null) {
                this.biE.setHeight(-2);
                this.biE.dd(true);
            }
            this.bjA = jSONObject.optBoolean("fixed");
            if (this.biE != null) {
                this.biE.de(this.bjA);
            }
            this.bjB = jSONObject.optBoolean("showConfirmBar", true);
            this.bjC = jSONObject.optBoolean("adjustPosition", true);
            this.bjE = jSONObject.optBoolean("disabled", false);
            KD();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        this.bjE = jSONObject.optBoolean("disabled", this.bjE);
        this.hint = jSONObject.optString("placeholder", this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.bjy = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.bjy);
        this.bjB = jSONObject.optBoolean("showConfirmBar", this.bjB);
        this.bjC = jSONObject.optBoolean("adjustPosition", this.bjC);
        ac(jSONObject);
        ab(jSONObject);
        ad(jSONObject);
        KD();
    }

    private void ab(JSONObject jSONObject) {
        this.bjA = jSONObject.optBoolean("fixed", this.bjA);
        if (this.biE != null) {
            this.biE.de(this.bjA);
        }
    }

    private void ac(JSONObject jSONObject) {
        this.bjz = jSONObject.optBoolean("autoHeight", this.bjz);
        if (this.biE != null) {
            if (this.bjz) {
                this.biE.setHeight(-2);
                this.biE.dd(true);
                return;
            }
            int height = this.biE.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.biE.setHeight(height);
            this.biE.dd(false);
        }
    }

    private void KD() {
        if (this.bik != null) {
            int S = af.S(getFloat(this.bik, "minHeight", 0.0f));
            if (S < 0) {
                S = 0;
            }
            this.bjD = S;
            int S2 = af.S(getFloat(this.bik, "maxHeight", 2.1474836E9f));
            if (S2 < 0) {
                S2 = Integer.MAX_VALUE;
            }
            this.maxHeight = S2;
        }
    }

    private void ad(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.bjv = optJSONObject.optInt("fontSize");
            this.bjw = optJSONObject.optString("fontWeight");
            this.bjx = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cf(boolean z) {
        this.bjy = z;
    }
}
