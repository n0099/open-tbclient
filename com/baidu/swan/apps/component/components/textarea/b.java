package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean cdJ;
    public int cdV;
    public String cdW;
    public String cdX;
    public boolean cdY;
    public boolean cdZ;
    public boolean cea;
    public boolean ceb;
    public boolean cec;
    public boolean ced;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cdW = "";
        this.cdX = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            aP(jSONObject);
            this.cdY = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cdZ = jSONObject.optBoolean("autoHeight", false);
            if (this.cdZ && this.cdd != null) {
                this.cdd.setHeight(-2);
                this.cdd.eT(true);
            }
            this.cea = jSONObject.optBoolean("fixed");
            if (this.cdd != null) {
                this.cdd.eU(this.cea);
            }
            this.ceb = jSONObject.optBoolean("showConfirmBar", true);
            this.cec = jSONObject.optBoolean("adjustPosition", true);
            this.ced = jSONObject.optBoolean("disabled", false);
            this.cdJ = jSONObject.optInt("confirmHold") == 1;
            adD();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aK(JSONObject jSONObject) {
        super.aK(jSONObject);
        this.ced = jSONObject.optBoolean("disabled", this.ced);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cdY = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cdY);
        this.ceb = jSONObject.optBoolean("showConfirmBar", this.ceb);
        this.cec = jSONObject.optBoolean("adjustPosition", this.cec);
        aO(jSONObject);
        aN(jSONObject);
        aP(jSONObject);
        adD();
    }

    private void aN(JSONObject jSONObject) {
        this.cea = jSONObject.optBoolean("fixed", this.cea);
        if (this.cdd != null) {
            this.cdd.eU(this.cea);
        }
    }

    private void aO(JSONObject jSONObject) {
        this.cdZ = jSONObject.optBoolean("autoHeight", this.cdZ);
        if (this.cdd != null) {
            if (this.cdZ) {
                this.cdd.setHeight(-2);
                this.cdd.eT(true);
                return;
            }
            int height = this.cdd.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.cdd.setHeight(height);
            this.cdd.eT(false);
        }
    }

    private void adD() {
        if (this.ccK != null) {
            int H = ah.H(getFloat(this.ccK, "minHeight", 0.0f));
            if (H < 0) {
                H = 0;
            }
            this.minHeight = H;
            int H2 = ah.H(getFloat(this.ccK, "maxHeight", 2.1474836E9f));
            if (H2 < 0) {
                H2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = H2;
        }
    }

    private void aP(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cdV = optJSONObject.optInt("fontSize");
            this.cdW = optJSONObject.optString("fontWeight");
            this.cdX = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dE(boolean z) {
        this.cdY = z;
    }
}
