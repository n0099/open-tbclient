package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean cCJ;
    public int cCV;
    public String cCW;
    public String cCX;
    public boolean cCY;
    public boolean cCZ;
    public boolean cDa;
    public boolean cDb;
    public boolean cDc;
    public boolean cDd;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cCW = "";
        this.cCX = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            aZ(jSONObject);
            this.cCY = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cCZ = jSONObject.optBoolean("autoHeight", false);
            if (this.cCZ && this.cCe != null) {
                this.cCe.setHeight(-2);
                this.cCe.fO(true);
            }
            this.cDa = jSONObject.optBoolean("fixed");
            if (this.cCe != null) {
                this.cCe.fP(this.cDa);
            }
            this.cDb = jSONObject.optBoolean("showConfirmBar", true);
            this.cDc = jSONObject.optBoolean("adjustPosition", true);
            this.cDd = jSONObject.optBoolean("disabled", false);
            this.cCJ = jSONObject.optInt("confirmHold") == 1;
            aka();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aU(JSONObject jSONObject) {
        super.aU(jSONObject);
        this.cDd = jSONObject.optBoolean("disabled", this.cDd);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cCY = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cCY);
        this.cDb = jSONObject.optBoolean("showConfirmBar", this.cDb);
        this.cDc = jSONObject.optBoolean("adjustPosition", this.cDc);
        aY(jSONObject);
        aX(jSONObject);
        aZ(jSONObject);
        aka();
    }

    private void aX(JSONObject jSONObject) {
        this.cDa = jSONObject.optBoolean("fixed", this.cDa);
        if (this.cCe != null) {
            this.cCe.fP(this.cDa);
        }
    }

    private void aY(JSONObject jSONObject) {
        this.cCZ = jSONObject.optBoolean("autoHeight", this.cCZ);
        if (this.cCe != null) {
            if (this.cCZ) {
                this.cCe.setHeight(-2);
                this.cCe.fO(true);
                return;
            }
            int height = this.cCe.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.cCe.setHeight(height);
            this.cCe.fO(false);
        }
    }

    private void aka() {
        if (this.cBL != null) {
            int M = ah.M(getFloat(this.cBL, "minHeight", 0.0f));
            if (M < 0) {
                M = 0;
            }
            this.minHeight = M;
            int M2 = ah.M(getFloat(this.cBL, "maxHeight", 2.1474836E9f));
            if (M2 < 0) {
                M2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = M2;
        }
    }

    private void aZ(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cCV = optJSONObject.optInt("fontSize");
            this.cCW = optJSONObject.optString("fontWeight");
            this.cCX = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ez(boolean z) {
        this.cCY = z;
    }
}
