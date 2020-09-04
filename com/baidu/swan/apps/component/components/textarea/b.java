package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean cbG;
    public int cbS;
    public String cbT;
    public String cbU;
    public boolean cbV;
    public boolean cbW;
    public boolean cbX;
    public boolean cbY;
    public boolean cbZ;
    public boolean cca;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cbT = "";
        this.cbU = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            aM(jSONObject);
            this.cbV = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cbW = jSONObject.optBoolean("autoHeight", false);
            if (this.cbW && this.cbb != null) {
                this.cbb.setHeight(-2);
                this.cbb.eV(true);
            }
            this.cbX = jSONObject.optBoolean("fixed");
            if (this.cbb != null) {
                this.cbb.eW(this.cbX);
            }
            this.cbY = jSONObject.optBoolean("showConfirmBar", true);
            this.cbZ = jSONObject.optBoolean("adjustPosition", true);
            this.cca = jSONObject.optBoolean("disabled", false);
            this.cbG = jSONObject.optInt("confirmHold") == 1;
            acU();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aH(JSONObject jSONObject) {
        super.aH(jSONObject);
        this.cca = jSONObject.optBoolean("disabled", this.cca);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cbV = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cbV);
        this.cbY = jSONObject.optBoolean("showConfirmBar", this.cbY);
        this.cbZ = jSONObject.optBoolean("adjustPosition", this.cbZ);
        aL(jSONObject);
        aK(jSONObject);
        aM(jSONObject);
        acU();
    }

    private void aK(JSONObject jSONObject) {
        this.cbX = jSONObject.optBoolean("fixed", this.cbX);
        if (this.cbb != null) {
            this.cbb.eW(this.cbX);
        }
    }

    private void aL(JSONObject jSONObject) {
        this.cbW = jSONObject.optBoolean("autoHeight", this.cbW);
        if (this.cbb != null) {
            if (this.cbW) {
                this.cbb.setHeight(-2);
                this.cbb.eV(true);
                return;
            }
            int height = this.cbb.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.cbb.setHeight(height);
            this.cbb.eV(false);
        }
    }

    private void acU() {
        if (this.caI != null) {
            int H = ah.H(getFloat(this.caI, "minHeight", 0.0f));
            if (H < 0) {
                H = 0;
            }
            this.minHeight = H;
            int H2 = ah.H(getFloat(this.caI, "maxHeight", 2.1474836E9f));
            if (H2 < 0) {
                H2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = H2;
        }
    }

    private void aM(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cbS = optJSONObject.optInt("fontSize");
            this.cbT = optJSONObject.optString("fontWeight");
            this.cbU = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dG(boolean z) {
        this.cbV = z;
    }
}
