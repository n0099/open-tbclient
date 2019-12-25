package com.baidu.swan.apps.component.components.textarea;

import com.baidu.swan.apps.as.af;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    public int bec;
    public String bed;
    public String bee;
    public boolean bef;
    public boolean beh;
    public boolean bei;
    public boolean bej;
    public int bek;
    public boolean bel;
    public boolean fixed;
    public String hint;
    public int maxHeight;

    public b() {
        super("textArea", "inputId");
        this.hint = "";
        this.bed = "";
        this.bee = "";
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.text = jSONObject.optString("value");
            this.hint = jSONObject.optString("placeholder");
            ad(jSONObject);
            this.bef = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
            this.beh = jSONObject.optBoolean("autoHeight", false);
            if (this.beh && this.bdl != null) {
                this.bdl.setHeight(-2);
                this.bdl.cQ(true);
            }
            this.fixed = jSONObject.optBoolean("fixed");
            if (this.bdl != null) {
                this.bdl.cR(this.fixed);
            }
            this.bei = jSONObject.optBoolean("showConfirmBar", true);
            this.bej = jSONObject.optBoolean("adjustPosition", true);
            this.bel = jSONObject.optBoolean("disabled", false);
            HN();
        }
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        this.bel = jSONObject.optBoolean("disabled", this.bel);
        this.hint = jSONObject.optString("placeholder", this.hint);
        this.text = jSONObject.optString("value", this.text);
        this.bef = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.bef);
        this.bei = jSONObject.optBoolean("showConfirmBar", this.bei);
        this.bej = jSONObject.optBoolean("adjustPosition", this.bej);
        ac(jSONObject);
        ab(jSONObject);
        ad(jSONObject);
        HN();
    }

    private void ab(JSONObject jSONObject) {
        this.fixed = jSONObject.optBoolean("fixed", this.fixed);
        if (this.bdl != null) {
            this.bdl.cR(this.fixed);
        }
    }

    private void ac(JSONObject jSONObject) {
        this.beh = jSONObject.optBoolean("autoHeight", this.beh);
        if (this.bdl != null) {
            if (this.beh) {
                this.bdl.setHeight(-2);
                this.bdl.cQ(true);
                return;
            }
            int height = this.bdl.getHeight();
            if (this.mViewHeight > 0) {
                height = this.mViewHeight;
            }
            this.bdl.setHeight(height);
            this.bdl.cQ(false);
        }
    }

    private void HN() {
        if (this.bcR != null) {
            int T = af.T(getFloat(this.bcR, "minHeight", 0.0f));
            if (T < 0) {
                T = 0;
            }
            this.bek = T;
            int T2 = af.T(getFloat(this.bcR, "maxHeight", 2.1474836E9f));
            if (T2 < 0) {
                T2 = Integer.MAX_VALUE;
            }
            this.maxHeight = T2;
        }
    }

    private void ad(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.bec = optJSONObject.optInt("fontSize");
            this.bed = optJSONObject.optString("fontWeight");
            this.bee = optJSONObject.optString("color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bR(boolean z) {
        this.bef = z;
    }
}
