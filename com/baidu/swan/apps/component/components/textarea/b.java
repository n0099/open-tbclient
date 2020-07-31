package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.aq.ai;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean bVU;
    public int bWg;
    public String bWh;
    public String bWi;
    public boolean bWj;
    public boolean bWk;
    public boolean bWl;
    public boolean bWm;
    public boolean bWn;
    public boolean bWo;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.bWh = "";
        this.bWi = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            aG(jSONObject);
            this.bWj = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.bWk = jSONObject.optBoolean("autoHeight", false);
            if (this.bWk && this.bVp != null) {
                this.bVp.setHeight(-2);
                this.bVp.eD(true);
            }
            this.bWl = jSONObject.optBoolean("fixed");
            if (this.bVp != null) {
                this.bVp.eE(this.bWl);
            }
            this.bWm = jSONObject.optBoolean("showConfirmBar", true);
            this.bWn = jSONObject.optBoolean("adjustPosition", true);
            this.bWo = jSONObject.optBoolean("disabled", false);
            this.bVU = jSONObject.optInt("confirmHold") == 1;
            WO();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aB(JSONObject jSONObject) {
        super.aB(jSONObject);
        this.bWo = jSONObject.optBoolean("disabled", this.bWo);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.bWj = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.bWj);
        this.bWm = jSONObject.optBoolean("showConfirmBar", this.bWm);
        this.bWn = jSONObject.optBoolean("adjustPosition", this.bWn);
        aF(jSONObject);
        aE(jSONObject);
        aG(jSONObject);
        WO();
    }

    private void aE(JSONObject jSONObject) {
        this.bWl = jSONObject.optBoolean("fixed", this.bWl);
        if (this.bVp != null) {
            this.bVp.eE(this.bWl);
        }
    }

    private void aF(JSONObject jSONObject) {
        this.bWk = jSONObject.optBoolean("autoHeight", this.bWk);
        if (this.bVp != null) {
            if (this.bWk) {
                this.bVp.setHeight(-2);
                this.bVp.eD(true);
                return;
            }
            int height = this.bVp.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.bVp.setHeight(height);
            this.bVp.eD(false);
        }
    }

    private void WO() {
        if (this.bUW != null) {
            int D = ai.D(getFloat(this.bUW, "minHeight", 0.0f));
            if (D < 0) {
                D = 0;
            }
            this.minHeight = D;
            int D2 = ai.D(getFloat(this.bUW, "maxHeight", 2.1474836E9f));
            if (D2 < 0) {
                D2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = D2;
        }
    }

    private void aG(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.bWg = optJSONObject.optInt("fontSize");
            this.bWh = optJSONObject.optString("fontWeight");
            this.bWi = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dw(boolean z) {
        this.bWj = z;
    }
}
