package com.baidu.swan.apps.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.model.a.a.a {
    public boolean aRG;
    public int aRH;
    public int aRI;
    public int aRJ;
    public int aRK;
    public String aRL;
    public boolean aRM;
    public boolean aRN;
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
        if (this.aXJ == null) {
            this.aXJ = new com.baidu.swan.apps.model.a.a.b();
        }
        this.value = jSONObject.optString("value");
        this.type = jSONObject.optString("type");
        this.maxLength = jSONObject.optInt("maxLength");
        this.aRH = jSONObject.optInt("cursorSpacing");
        this.aRI = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
        this.aRJ = jSONObject.optInt("selectionStart");
        this.aRK = jSONObject.optInt("selectionEnd");
        this.aRL = jSONObject.optString("confirmType");
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        this.fontSize = optJSONObject.optInt("fontSize");
        this.fontWeight = optJSONObject.optString("fontWeight");
        this.color = optJSONObject.optString("color");
        this.textAlign = optJSONObject.optString("textAlign");
        this.aRG = jSONObject.optInt("password") == 1;
        this.aRM = jSONObject.optInt("confirmHold") == 1;
        this.aRN = jSONObject.optInt("adjustPosition", 1) == 1;
    }

    public void ab(JSONObject jSONObject) {
        try {
            super.parseFromJson(jSONObject);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Input", "parsing InputInfo occurs exception", e);
        }
    }
}
