package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    public int cEF;
    public String cEG;
    public String cEH;
    public boolean cEI;
    public boolean cEJ;
    public boolean cEK;
    public boolean cEL;
    public boolean cEM;
    public boolean cEN;
    boolean cEt;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cEG = "";
        this.cEH = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            bf(jSONObject);
            this.cEI = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cEJ = jSONObject.optBoolean("autoHeight", false);
            if (this.cEJ && this.cDO != null) {
                this.cDO.setHeight(-2);
                this.cDO.fL(true);
            }
            this.cEK = jSONObject.optBoolean("fixed");
            if (this.cDO != null) {
                this.cDO.fM(this.cEK);
            }
            this.cEL = jSONObject.optBoolean("showConfirmBar", true);
            this.cEM = jSONObject.optBoolean("adjustPosition", true);
            this.cEN = jSONObject.optBoolean("disabled", false);
            this.cEt = jSONObject.optInt("confirmHold") == 1;
            akI();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void ba(JSONObject jSONObject) {
        super.ba(jSONObject);
        this.cEN = jSONObject.optBoolean("disabled", this.cEN);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cEI = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cEI);
        this.cEL = jSONObject.optBoolean("showConfirmBar", this.cEL);
        this.cEM = jSONObject.optBoolean("adjustPosition", this.cEM);
        be(jSONObject);
        bd(jSONObject);
        bf(jSONObject);
        akI();
    }

    private void bd(JSONObject jSONObject) {
        this.cEK = jSONObject.optBoolean("fixed", this.cEK);
        if (this.cDO != null) {
            this.cDO.fM(this.cEK);
        }
    }

    private void be(JSONObject jSONObject) {
        this.cEJ = jSONObject.optBoolean("autoHeight", this.cEJ);
        if (this.cDO != null) {
            if (this.cEJ) {
                this.cDO.setHeight(-2);
                this.cDO.fL(true);
                return;
            }
            int height = this.cDO.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.cDO.setHeight(height);
            this.cDO.fL(false);
        }
    }

    private void akI() {
        if (this.cDv != null) {
            int N = ah.N(getFloat(this.cDv, "minHeight", 0.0f));
            if (N < 0) {
                N = 0;
            }
            this.minHeight = N;
            int N2 = ah.N(getFloat(this.cDv, "maxHeight", 2.1474836E9f));
            if (N2 < 0) {
                N2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = N2;
        }
    }

    private void bf(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cEF = optJSONObject.optInt("fontSize");
            this.cEG = optJSONObject.optString("fontWeight");
            this.cEH = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ew(boolean z) {
        this.cEI = z;
    }
}
