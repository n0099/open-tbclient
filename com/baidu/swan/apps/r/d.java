package com.baidu.swan.apps.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.model.a.a.a {
    public boolean aRo;
    public int aRp;
    public int aRq;
    public int aRr;
    public int aRs;
    public String aRt;
    public boolean aRu;
    public boolean aRv;
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
        if (this.aXr == null) {
            this.aXr = new com.baidu.swan.apps.model.a.a.b();
        }
        this.value = jSONObject.optString("value");
        this.type = jSONObject.optString("type");
        this.maxLength = jSONObject.optInt("maxLength");
        this.aRp = jSONObject.optInt("cursorSpacing");
        this.aRq = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
        this.aRr = jSONObject.optInt("selectionStart");
        this.aRs = jSONObject.optInt("selectionEnd");
        this.aRt = jSONObject.optString("confirmType");
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        this.fontSize = optJSONObject.optInt("fontSize");
        this.fontWeight = optJSONObject.optString("fontWeight");
        this.color = optJSONObject.optString("color");
        this.textAlign = optJSONObject.optString("textAlign");
        this.aRo = jSONObject.optInt("password") == 1;
        this.aRu = jSONObject.optInt("confirmHold") == 1;
        this.aRv = jSONObject.optInt("adjustPosition", 1) == 1;
    }

    public void ac(JSONObject jSONObject) {
        try {
            super.parseFromJson(jSONObject);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Input", "parsing InputInfo occurs exception", e);
        }
    }
}
