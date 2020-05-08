package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.as.af;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    public int bHI;
    public String bHJ;
    public String bHK;
    public boolean bHL;
    public boolean bHM;
    public boolean bHN;
    public boolean bHO;
    public boolean bHP;
    public int bHQ;
    public boolean bHR;
    public String hint;
    public int maxHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.bHJ = "";
        this.bHK = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            ao(jSONObject);
            this.bHL = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.bHM = jSONObject.optBoolean("autoHeight", false);
            if (this.bHM && this.bGR != null) {
                this.bGR.setHeight(-2);
                this.bGR.dZ(true);
            }
            this.bHN = jSONObject.optBoolean("fixed");
            if (this.bGR != null) {
                this.bGR.ea(this.bHN);
            }
            this.bHO = jSONObject.optBoolean("showConfirmBar", true);
            this.bHP = jSONObject.optBoolean("adjustPosition", true);
            this.bHR = jSONObject.optBoolean("disabled", false);
            Sq();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aj(JSONObject jSONObject) {
        super.aj(jSONObject);
        this.bHR = jSONObject.optBoolean("disabled", this.bHR);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.bHL = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.bHL);
        this.bHO = jSONObject.optBoolean("showConfirmBar", this.bHO);
        this.bHP = jSONObject.optBoolean("adjustPosition", this.bHP);
        an(jSONObject);
        am(jSONObject);
        ao(jSONObject);
        Sq();
    }

    private void am(JSONObject jSONObject) {
        this.bHN = jSONObject.optBoolean("fixed", this.bHN);
        if (this.bGR != null) {
            this.bGR.ea(this.bHN);
        }
    }

    private void an(JSONObject jSONObject) {
        this.bHM = jSONObject.optBoolean("autoHeight", this.bHM);
        if (this.bGR != null) {
            if (this.bHM) {
                this.bGR.setHeight(-2);
                this.bGR.dZ(true);
                return;
            }
            int height = this.bGR.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.bGR.setHeight(height);
            this.bGR.dZ(false);
        }
    }

    private void Sq() {
        if (this.bGy != null) {
            int C = af.C(getFloat(this.bGy, "minHeight", 0.0f));
            if (C < 0) {
                C = 0;
            }
            this.bHQ = C;
            int C2 = af.C(getFloat(this.bGy, "maxHeight", 2.1474836E9f));
            if (C2 < 0) {
                C2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = C2;
        }
    }

    private void ao(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.bHI = optJSONObject.optInt("fontSize");
            this.bHJ = optJSONObject.optString("fontWeight");
            this.bHK = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void db(boolean z) {
        this.bHL = z;
    }
}
