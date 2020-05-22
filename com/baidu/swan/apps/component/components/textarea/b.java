package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.aq.ag;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    public int bQA;
    public String bQB;
    public String bQC;
    public boolean bQD;
    public boolean bQE;
    public boolean bQF;
    public boolean bQG;
    public boolean bQH;
    public int bQI;
    public boolean bQJ;
    boolean bQo;
    public String hint;
    public int maxHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.bQB = "";
        this.bQC = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            aw(jSONObject);
            this.bQD = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.bQE = jSONObject.optBoolean("autoHeight", false);
            if (this.bQE && this.bPJ != null) {
                this.bPJ.setHeight(-2);
                this.bPJ.eq(true);
            }
            this.bQF = jSONObject.optBoolean("fixed");
            if (this.bPJ != null) {
                this.bPJ.er(this.bQF);
            }
            this.bQG = jSONObject.optBoolean("showConfirmBar", true);
            this.bQH = jSONObject.optBoolean("adjustPosition", true);
            this.bQJ = jSONObject.optBoolean("disabled", false);
            this.bQo = jSONObject.optInt("confirmHold") == 1;
            Vb();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void ar(JSONObject jSONObject) {
        super.ar(jSONObject);
        this.bQJ = jSONObject.optBoolean("disabled", this.bQJ);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.bQD = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.bQD);
        this.bQG = jSONObject.optBoolean("showConfirmBar", this.bQG);
        this.bQH = jSONObject.optBoolean("adjustPosition", this.bQH);
        av(jSONObject);
        au(jSONObject);
        aw(jSONObject);
        Vb();
    }

    private void au(JSONObject jSONObject) {
        this.bQF = jSONObject.optBoolean("fixed", this.bQF);
        if (this.bPJ != null) {
            this.bPJ.er(this.bQF);
        }
    }

    private void av(JSONObject jSONObject) {
        this.bQE = jSONObject.optBoolean("autoHeight", this.bQE);
        if (this.bPJ != null) {
            if (this.bQE) {
                this.bPJ.setHeight(-2);
                this.bPJ.eq(true);
                return;
            }
            int height = this.bPJ.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.bPJ.setHeight(height);
            this.bPJ.eq(false);
        }
    }

    private void Vb() {
        if (this.bPq != null) {
            int B = ag.B(getFloat(this.bPq, "minHeight", 0.0f));
            if (B < 0) {
                B = 0;
            }
            this.bQI = B;
            int B2 = ag.B(getFloat(this.bPq, "maxHeight", 2.1474836E9f));
            if (B2 < 0) {
                B2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = B2;
        }
    }

    private void aw(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.bQA = optJSONObject.optInt("fontSize");
            this.bQB = optJSONObject.optString("fontWeight");
            this.bQC = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public void m26do(boolean z) {
        this.bQD = z;
    }
}
