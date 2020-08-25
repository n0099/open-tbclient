package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean cbC;
    public int cbO;
    public String cbP;
    public String cbQ;
    public boolean cbR;
    public boolean cbS;
    public boolean cbT;
    public boolean cbU;
    public boolean cbV;
    public boolean cbW;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cbP = "";
        this.cbQ = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            aM(jSONObject);
            this.cbR = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cbS = jSONObject.optBoolean("autoHeight", false);
            if (this.cbS && this.caX != null) {
                this.caX.setHeight(-2);
                this.caX.eU(true);
            }
            this.cbT = jSONObject.optBoolean("fixed");
            if (this.caX != null) {
                this.caX.eV(this.cbT);
            }
            this.cbU = jSONObject.optBoolean("showConfirmBar", true);
            this.cbV = jSONObject.optBoolean("adjustPosition", true);
            this.cbW = jSONObject.optBoolean("disabled", false);
            this.cbC = jSONObject.optInt("confirmHold") == 1;
            acU();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aH(JSONObject jSONObject) {
        super.aH(jSONObject);
        this.cbW = jSONObject.optBoolean("disabled", this.cbW);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cbR = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cbR);
        this.cbU = jSONObject.optBoolean("showConfirmBar", this.cbU);
        this.cbV = jSONObject.optBoolean("adjustPosition", this.cbV);
        aL(jSONObject);
        aK(jSONObject);
        aM(jSONObject);
        acU();
    }

    private void aK(JSONObject jSONObject) {
        this.cbT = jSONObject.optBoolean("fixed", this.cbT);
        if (this.caX != null) {
            this.caX.eV(this.cbT);
        }
    }

    private void aL(JSONObject jSONObject) {
        this.cbS = jSONObject.optBoolean("autoHeight", this.cbS);
        if (this.caX != null) {
            if (this.cbS) {
                this.caX.setHeight(-2);
                this.caX.eU(true);
                return;
            }
            int height = this.caX.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.caX.setHeight(height);
            this.caX.eU(false);
        }
    }

    private void acU() {
        if (this.caE != null) {
            int H = ah.H(getFloat(this.caE, "minHeight", 0.0f));
            if (H < 0) {
                H = 0;
            }
            this.minHeight = H;
            int H2 = ah.H(getFloat(this.caE, "maxHeight", 2.1474836E9f));
            if (H2 < 0) {
                H2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = H2;
        }
    }

    private void aM(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cbO = optJSONObject.optInt("fontSize");
            this.cbP = optJSONObject.optString("fontWeight");
            this.cbQ = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dF(boolean z) {
        this.cbR = z;
    }
}
