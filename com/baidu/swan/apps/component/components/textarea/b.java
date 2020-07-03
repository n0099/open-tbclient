package com.baidu.swan.apps.component.components.textarea;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.aq.ag;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean bVc;
    public int bVo;
    public String bVp;
    public String bVq;
    public boolean bVr;
    public boolean bVs;
    public boolean bVt;
    public boolean bVu;
    public boolean bVv;
    public int bVw;
    public boolean bVx;
    public String hint;
    public int maxHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.bVp = "";
        this.bVq = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER);
            aD(jSONObject);
            this.bVr = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.bVs = jSONObject.optBoolean("autoHeight", false);
            if (this.bVs && this.bUx != null) {
                this.bUx.setHeight(-2);
                this.bUx.ev(true);
            }
            this.bVt = jSONObject.optBoolean("fixed");
            if (this.bUx != null) {
                this.bUx.ew(this.bVt);
            }
            this.bVu = jSONObject.optBoolean("showConfirmBar", true);
            this.bVv = jSONObject.optBoolean("adjustPosition", true);
            this.bVx = jSONObject.optBoolean("disabled", false);
            this.bVc = jSONObject.optInt("confirmHold") == 1;
            Wh();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void ay(JSONObject jSONObject) {
        super.ay(jSONObject);
        this.bVx = jSONObject.optBoolean("disabled", this.bVx);
        this.hint = jSONObject.optString(UgcConstant.PLACEHOLDER, this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.bVr = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.bVr);
        this.bVu = jSONObject.optBoolean("showConfirmBar", this.bVu);
        this.bVv = jSONObject.optBoolean("adjustPosition", this.bVv);
        aC(jSONObject);
        aB(jSONObject);
        aD(jSONObject);
        Wh();
    }

    private void aB(JSONObject jSONObject) {
        this.bVt = jSONObject.optBoolean("fixed", this.bVt);
        if (this.bUx != null) {
            this.bUx.ew(this.bVt);
        }
    }

    private void aC(JSONObject jSONObject) {
        this.bVs = jSONObject.optBoolean("autoHeight", this.bVs);
        if (this.bUx != null) {
            if (this.bVs) {
                this.bUx.setHeight(-2);
                this.bUx.ev(true);
                return;
            }
            int height = this.bUx.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.bUx.setHeight(height);
            this.bUx.ev(false);
        }
    }

    private void Wh() {
        if (this.bUe != null) {
            int D = ag.D(getFloat(this.bUe, "minHeight", 0.0f));
            if (D < 0) {
                D = 0;
            }
            this.bVw = D;
            int D2 = ag.D(getFloat(this.bUe, "maxHeight", 2.1474836E9f));
            if (D2 < 0) {
                D2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.maxHeight = D2;
        }
    }

    private void aD(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.bVo = optJSONObject.optInt("fontSize");
            this.bVp = optJSONObject.optString("fontWeight");
            this.bVq = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dt(boolean z) {
        this.bVr = z;
    }
}
