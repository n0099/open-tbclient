package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean cyA;
    public int cyM;
    public String cyN;
    public String cyO;
    public boolean cyP;
    public boolean cyQ;
    public boolean cyR;
    public boolean cyS;
    public boolean cyT;
    public boolean cyU;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cyN = "";
        this.cyO = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            aZ(jSONObject);
            this.cyP = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cyQ = jSONObject.optBoolean("autoHeight", false);
            if (this.cyQ && this.cxV != null) {
                this.cxV.setHeight(-2);
                this.cxV.fC(true);
            }
            this.cyR = jSONObject.optBoolean("fixed");
            if (this.cxV != null) {
                this.cxV.fD(this.cyR);
            }
            this.cyS = jSONObject.optBoolean("showConfirmBar", true);
            this.cyT = jSONObject.optBoolean("adjustPosition", true);
            this.cyU = jSONObject.optBoolean("disabled", false);
            this.cyA = jSONObject.optInt("confirmHold") == 1;
            aii();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aU(JSONObject jSONObject) {
        super.aU(jSONObject);
        this.cyU = jSONObject.optBoolean("disabled", this.cyU);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cyP = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cyP);
        this.cyS = jSONObject.optBoolean("showConfirmBar", this.cyS);
        this.cyT = jSONObject.optBoolean("adjustPosition", this.cyT);
        aY(jSONObject);
        aX(jSONObject);
        aZ(jSONObject);
        aii();
    }

    private void aX(JSONObject jSONObject) {
        this.cyR = jSONObject.optBoolean("fixed", this.cyR);
        if (this.cxV != null) {
            this.cxV.fD(this.cyR);
        }
    }

    private void aY(JSONObject jSONObject) {
        this.cyQ = jSONObject.optBoolean("autoHeight", this.cyQ);
        if (this.cxV != null) {
            if (this.cyQ) {
                this.cxV.setHeight(-2);
                this.cxV.fC(true);
                return;
            }
            int height = this.cxV.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.cxV.setHeight(height);
            this.cxV.fC(false);
        }
    }

    private void aii() {
        if (this.cxC != null) {
            int L = ah.L(getFloat(this.cxC, "minHeight", 0.0f));
            if (L < 0) {
                L = 0;
            }
            this.minHeight = L;
            int L2 = ah.L(getFloat(this.cxC, "maxHeight", 2.1474836E9f));
            if (L2 < 0) {
                L2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = L2;
        }
    }

    private void aZ(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cyM = optJSONObject.optInt("fontSize");
            this.cyN = optJSONObject.optString("fontWeight");
            this.cyO = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void en(boolean z) {
        this.cyP = z;
    }
}
