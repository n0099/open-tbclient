package com.baidu.swan.apps.r;

import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.model.a.a.a {
    public boolean axS;
    public int axT;
    public int axU;
    public int axV;
    public int axW;
    public String axX;
    public boolean axY;
    public boolean axZ;
    public String color;
    public int fontSize;
    public String fontWeight;
    public int maxLength;
    public String textAlign;
    public String type;
    public String value;

    public d() {
        super("viewId", Config.INPUT_PART);
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        if (this.aDW == null) {
            this.aDW = new com.baidu.swan.apps.model.a.a.b();
        }
        this.value = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
        this.type = jSONObject.optString("type");
        this.maxLength = jSONObject.optInt("maxLength");
        this.axT = jSONObject.optInt("cursorSpacing");
        this.axU = jSONObject.optInt("cursor");
        this.axV = jSONObject.optInt("selectionStart");
        this.axW = jSONObject.optInt("selectionEnd");
        this.axX = jSONObject.optString("confirmType");
        JSONObject optJSONObject = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        this.fontSize = optJSONObject.optInt("fontSize");
        this.fontWeight = optJSONObject.optString("fontWeight");
        this.color = optJSONObject.optString("color");
        this.textAlign = optJSONObject.optString("textAlign");
        this.axS = jSONObject.optInt("password") == 1;
        this.axY = jSONObject.optInt("confirmHold") == 1;
        this.axZ = jSONObject.optInt("adjustPosition", 1) == 1;
    }

    public void D(JSONObject jSONObject) {
        try {
            super.parseFromJson(jSONObject);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Input", "parsing InputInfo occurs exception", e);
        }
    }
}
