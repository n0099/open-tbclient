package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean cpZ;
    public int cql;
    public String cqm;
    public String cqn;
    public boolean cqo;
    public boolean cqp;
    public boolean cqq;
    public boolean cqr;
    public boolean cqs;
    public boolean cqt;
    public String hint;
    public int maxHeight;
    public int minHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.cqm = "";
        this.cqn = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            aW(jSONObject);
            this.cqo = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.cqp = jSONObject.optBoolean("autoHeight", false);
            if (this.cqp && this.cpt != null) {
                this.cpt.setHeight(-2);
                this.cpt.fp(true);
            }
            this.cqq = jSONObject.optBoolean("fixed");
            if (this.cpt != null) {
                this.cpt.fq(this.cqq);
            }
            this.cqr = jSONObject.optBoolean("showConfirmBar", true);
            this.cqs = jSONObject.optBoolean("adjustPosition", true);
            this.cqt = jSONObject.optBoolean("disabled", false);
            this.cpZ = jSONObject.optInt("confirmHold") == 1;
            ago();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aR(JSONObject jSONObject) {
        super.aR(jSONObject);
        this.cqt = jSONObject.optBoolean("disabled", this.cqt);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.cqo = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.cqo);
        this.cqr = jSONObject.optBoolean("showConfirmBar", this.cqr);
        this.cqs = jSONObject.optBoolean("adjustPosition", this.cqs);
        aV(jSONObject);
        aU(jSONObject);
        aW(jSONObject);
        ago();
    }

    private void aU(JSONObject jSONObject) {
        this.cqq = jSONObject.optBoolean("fixed", this.cqq);
        if (this.cpt != null) {
            this.cpt.fq(this.cqq);
        }
    }

    private void aV(JSONObject jSONObject) {
        this.cqp = jSONObject.optBoolean("autoHeight", this.cqp);
        if (this.cpt != null) {
            if (this.cqp) {
                this.cpt.setHeight(-2);
                this.cpt.fp(true);
                return;
            }
            int height = this.cpt.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.cpt.setHeight(height);
            this.cpt.fp(false);
        }
    }

    private void ago() {
        if (this.cpa != null) {
            int J = ah.J(getFloat(this.cpa, "minHeight", 0.0f));
            if (J < 0) {
                J = 0;
            }
            this.minHeight = J;
            int J2 = ah.J(getFloat(this.cpa, "maxHeight", 2.1474836E9f));
            if (J2 < 0) {
                J2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = J2;
        }
    }

    private void aW(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.cql = optJSONObject.optInt("fontSize");
            this.cqm = optJSONObject.optString("fontWeight");
            this.cqn = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ea(boolean z) {
        this.cqo = z;
    }
}
