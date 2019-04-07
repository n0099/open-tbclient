package com.baidu.swan.apps.r;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.model.a.a.a {
    public boolean awJ;
    public int awK;
    public int awL;
    public String awM;
    public boolean awN;
    public boolean awO;
    public String color;
    public int fontSize;
    public String fontWeight;
    public int maxLength;
    public int selectionEnd;
    public int selectionStart;
    public String textAlign;
    public String type;
    public String value;

    public d() {
        super("viewId", "input");
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        if (this.aBI == null) {
            this.aBI = new com.baidu.swan.apps.model.a.a.b();
        }
        this.value = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
        this.type = jSONObject.optString("type");
        this.maxLength = jSONObject.optInt("maxLength");
        this.awK = jSONObject.optInt("cursorSpacing");
        this.awL = jSONObject.optInt("cursor");
        this.selectionStart = jSONObject.optInt("selectionStart");
        this.selectionEnd = jSONObject.optInt("selectionEnd");
        this.awM = jSONObject.optString("confirmType");
        JSONObject optJSONObject = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        this.fontSize = optJSONObject.optInt("fontSize");
        this.fontWeight = optJSONObject.optString("fontWeight");
        this.color = optJSONObject.optString("color");
        this.textAlign = optJSONObject.optString("textAlign");
        this.awJ = jSONObject.optInt("password") == 1;
        this.awN = jSONObject.optInt("confirmHold") == 1;
        this.awO = jSONObject.optInt("adjustPosition", 1) == 1;
    }

    public void G(JSONObject jSONObject) {
        try {
            super.parseFromJson(jSONObject);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Input", "parsing InputInfo occurs exception", e);
        }
    }
}
