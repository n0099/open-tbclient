package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.as.af;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    public int bHD;
    public String bHE;
    public String bHF;
    public boolean bHG;
    public boolean bHH;
    public boolean bHI;
    public boolean bHJ;
    public boolean bHK;
    public int bHL;
    public boolean bHM;
    public String hint;
    public int maxHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.bHE = "";
        this.bHF = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            ao(jSONObject);
            this.bHG = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.bHH = jSONObject.optBoolean("autoHeight", false);
            if (this.bHH && this.bGM != null) {
                this.bGM.setHeight(-2);
                this.bGM.dZ(true);
            }
            this.bHI = jSONObject.optBoolean("fixed");
            if (this.bGM != null) {
                this.bGM.ea(this.bHI);
            }
            this.bHJ = jSONObject.optBoolean("showConfirmBar", true);
            this.bHK = jSONObject.optBoolean("adjustPosition", true);
            this.bHM = jSONObject.optBoolean("disabled", false);
            Sr();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aj(JSONObject jSONObject) {
        super.aj(jSONObject);
        this.bHM = jSONObject.optBoolean("disabled", this.bHM);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.bHG = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.bHG);
        this.bHJ = jSONObject.optBoolean("showConfirmBar", this.bHJ);
        this.bHK = jSONObject.optBoolean("adjustPosition", this.bHK);
        an(jSONObject);
        am(jSONObject);
        ao(jSONObject);
        Sr();
    }

    private void am(JSONObject jSONObject) {
        this.bHI = jSONObject.optBoolean("fixed", this.bHI);
        if (this.bGM != null) {
            this.bGM.ea(this.bHI);
        }
    }

    private void an(JSONObject jSONObject) {
        this.bHH = jSONObject.optBoolean("autoHeight", this.bHH);
        if (this.bGM != null) {
            if (this.bHH) {
                this.bGM.setHeight(-2);
                this.bGM.dZ(true);
                return;
            }
            int height = this.bGM.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.bGM.setHeight(height);
            this.bGM.dZ(false);
        }
    }

    private void Sr() {
        if (this.bGt != null) {
            int C = af.C(getFloat(this.bGt, "minHeight", 0.0f));
            if (C < 0) {
                C = 0;
            }
            this.bHL = C;
            int C2 = af.C(getFloat(this.bGt, "maxHeight", 2.1474836E9f));
            if (C2 < 0) {
                C2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = C2;
        }
    }

    private void ao(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.bHD = optJSONObject.optInt("fontSize");
            this.bHE = optJSONObject.optString("fontWeight");
            this.bHF = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void db(boolean z) {
        this.bHG = z;
    }
}
