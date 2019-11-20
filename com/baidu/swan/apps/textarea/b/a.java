package com.baidu.swan.apps.textarea.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.console.c;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.model.a.a.a {
    public boolean aXv;
    public int brA;
    public int brB;
    public boolean brC;
    public String brD;
    public int brE;
    public String brF;
    public boolean brG;
    public JSONArray brH;
    public int brI;
    public int brJ;
    public String brq;
    public int brr;
    public String brs;
    public String brt;
    public boolean bru;
    public boolean brv;
    public boolean brw;
    public int brx;
    public int bry;
    public int brz;
    public String mColor;
    public int mFontSize;
    public int mHeight;
    public int mLeft;
    public int mMaxHeight;
    public int mTop;
    public String mValue;
    public int mWidth;

    public static a aK(JSONObject jSONObject) {
        a aVar = new a();
        try {
            aVar.parseFromJson(jSONObject);
        } catch (JSONException e) {
            c.e("TextArea", "parsing TextAreaStatusInfo occurs exception", e);
        }
        return aVar;
    }

    public static a a(a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar2 = new a();
        if (aVar != null) {
            aVar2.a(jSONObject, aVar);
            aVar2.brJ = aVar.brJ;
            aVar2.mValue = jSONObject.optString("value", aVar.mValue);
            aVar2.brq = jSONObject.optString("placeholder", aVar.brq);
            JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
            aVar2.brr = optJSONObject.optInt("fontSize", aVar.brr);
            aVar2.brs = optJSONObject.optString("fontWeight", aVar.brs);
            aVar2.brt = optJSONObject.optString("color", aVar.brt);
            aVar2.bru = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, aVar.bru);
            aVar2.brv = jSONObject.optBoolean("autoHeight", aVar.brv);
            aVar2.aXv = jSONObject.optBoolean("fixed", aVar.aXv);
            aVar2.brw = jSONObject.optBoolean("showConfirmBar", aVar.brw);
            aVar2.brx = jSONObject.optInt("maxLength", aVar.brx);
            aVar2.bry = jSONObject.optInt("cursorSpacing", aVar.bry);
            aVar2.brz = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, aVar.brz);
            aVar2.brA = jSONObject.optInt("selectionStart", aVar.brA);
            aVar2.brB = jSONObject.optInt("selectionEnd", aVar.brB);
            aVar2.brC = jSONObject.optBoolean("adjustPosition", aVar.brC);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("style");
            aVar2.brH = optJSONObject2.optJSONArray("padding");
            aVar2.mFontSize = optJSONObject2.optInt("fontSize", aVar.mFontSize);
            aVar2.brD = optJSONObject2.optString("fontWeight", aVar.brD);
            aVar2.mColor = optJSONObject2.optString("color", aVar.mColor);
            aVar2.brF = optJSONObject2.optString("textAlign", aVar.brF);
            int S = z.S(a(optJSONObject2, "minHeight", z.U(aVar.brI)));
            if (S < 0) {
                S = 0;
            }
            aVar2.brI = S;
            int S2 = z.S(a(optJSONObject2, "maxHeight", z.U(aVar.mMaxHeight)));
            if (S2 < 0) {
                S2 = Integer.MAX_VALUE;
            }
            aVar2.mMaxHeight = S2;
            aVar2.brE = z.S((float) optJSONObject2.optDouble("lineSpace", z.U(aVar.brE)));
            aVar2.brG = jSONObject.optBoolean("disabled", aVar.brG);
            aVar2.mLeft = aVar2.aXr.getLeft();
            aVar2.mTop = aVar2.aXr.Mu();
            aVar2.mWidth = aVar2.aXr.getWidth();
            aVar2.mHeight = aVar2.aXr.getHeight();
        }
        return aVar2;
    }

    private a() {
        super("inputId", "textArea");
        this.brJ = 1;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.mValue = jSONObject.optString("value");
        this.brq = jSONObject.optString("placeholder");
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        this.brr = optJSONObject.optInt("fontSize");
        this.brs = optJSONObject.optString("fontWeight");
        this.brt = optJSONObject.optString("color");
        this.bru = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        this.brv = jSONObject.optBoolean("autoHeight", false);
        this.aXv = jSONObject.optBoolean("fixed");
        this.brw = jSONObject.optBoolean("showConfirmBar", true);
        this.brx = jSONObject.optInt("maxLength");
        this.bry = jSONObject.optInt("cursorSpacing");
        this.brz = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
        this.brA = jSONObject.optInt("selectionStart");
        this.brB = jSONObject.optInt("selectionEnd");
        this.brC = jSONObject.optBoolean("adjustPosition", true);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("style");
        this.brH = optJSONObject2.optJSONArray("padding");
        this.mFontSize = optJSONObject2.optInt("fontSize");
        this.brD = optJSONObject2.optString("fontWeight");
        this.mColor = optJSONObject2.optString("color");
        this.brF = optJSONObject2.optString("textAlign");
        int S = z.S(a(optJSONObject2, "minHeight", 0.0f));
        if (S < 0) {
            S = 0;
        }
        this.brI = S;
        int S2 = z.S(a(optJSONObject2, "maxHeight", 2.1474836E9f));
        if (S2 < 0) {
            S2 = Integer.MAX_VALUE;
        }
        this.mMaxHeight = S2;
        this.brE = z.S((float) optJSONObject2.optDouble("lineSpace"));
        this.brG = jSONObject.optBoolean("disabled", false);
        this.mLeft = this.aXr.getLeft();
        this.mTop = this.aXr.Mu();
        this.mWidth = this.aXr.getWidth();
        this.mHeight = this.aXr.getHeight();
    }
}
