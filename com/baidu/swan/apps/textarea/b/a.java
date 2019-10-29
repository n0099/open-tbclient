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
    public boolean aXN;
    public int bsA;
    public String bsh;
    public int bsi;
    public String bsj;
    public String bsk;
    public boolean bsl;
    public boolean bsm;
    public boolean bsn;
    public int bso;
    public int bsp;
    public int bsq;
    public int bsr;
    public int bss;
    public boolean bst;
    public String bsu;
    public int bsv;
    public String bsw;
    public boolean bsx;
    public JSONArray bsy;
    public int bsz;
    public String mColor;
    public int mFontSize;
    public int mHeight;
    public int mLeft;
    public int mMaxHeight;
    public int mTop;
    public String mValue;
    public int mWidth;

    public static a aJ(JSONObject jSONObject) {
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
            aVar2.bsA = aVar.bsA;
            aVar2.mValue = jSONObject.optString("value", aVar.mValue);
            aVar2.bsh = jSONObject.optString("placeholder", aVar.bsh);
            JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
            aVar2.bsi = optJSONObject.optInt("fontSize", aVar.bsi);
            aVar2.bsj = optJSONObject.optString("fontWeight", aVar.bsj);
            aVar2.bsk = optJSONObject.optString("color", aVar.bsk);
            aVar2.bsl = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, aVar.bsl);
            aVar2.bsm = jSONObject.optBoolean("autoHeight", aVar.bsm);
            aVar2.aXN = jSONObject.optBoolean("fixed", aVar.aXN);
            aVar2.bsn = jSONObject.optBoolean("showConfirmBar", aVar.bsn);
            aVar2.bso = jSONObject.optInt("maxLength", aVar.bso);
            aVar2.bsp = jSONObject.optInt("cursorSpacing", aVar.bsp);
            aVar2.bsq = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, aVar.bsq);
            aVar2.bsr = jSONObject.optInt("selectionStart", aVar.bsr);
            aVar2.bss = jSONObject.optInt("selectionEnd", aVar.bss);
            aVar2.bst = jSONObject.optBoolean("adjustPosition", aVar.bst);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("style");
            aVar2.bsy = optJSONObject2.optJSONArray("padding");
            aVar2.mFontSize = optJSONObject2.optInt("fontSize", aVar.mFontSize);
            aVar2.bsu = optJSONObject2.optString("fontWeight", aVar.bsu);
            aVar2.mColor = optJSONObject2.optString("color", aVar.mColor);
            aVar2.bsw = optJSONObject2.optString("textAlign", aVar.bsw);
            int S = z.S(a(optJSONObject2, "minHeight", z.U(aVar.bsz)));
            if (S < 0) {
                S = 0;
            }
            aVar2.bsz = S;
            int S2 = z.S(a(optJSONObject2, "maxHeight", z.U(aVar.mMaxHeight)));
            if (S2 < 0) {
                S2 = Integer.MAX_VALUE;
            }
            aVar2.mMaxHeight = S2;
            aVar2.bsv = z.S((float) optJSONObject2.optDouble("lineSpace", z.U(aVar.bsv)));
            aVar2.bsx = jSONObject.optBoolean("disabled", aVar.bsx);
            aVar2.mLeft = aVar2.aXJ.getLeft();
            aVar2.mTop = aVar2.aXJ.Mt();
            aVar2.mWidth = aVar2.aXJ.getWidth();
            aVar2.mHeight = aVar2.aXJ.getHeight();
        }
        return aVar2;
    }

    private a() {
        super("inputId", "textArea");
        this.bsA = 1;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.mValue = jSONObject.optString("value");
        this.bsh = jSONObject.optString("placeholder");
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        this.bsi = optJSONObject.optInt("fontSize");
        this.bsj = optJSONObject.optString("fontWeight");
        this.bsk = optJSONObject.optString("color");
        this.bsl = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        this.bsm = jSONObject.optBoolean("autoHeight", false);
        this.aXN = jSONObject.optBoolean("fixed");
        this.bsn = jSONObject.optBoolean("showConfirmBar", true);
        this.bso = jSONObject.optInt("maxLength");
        this.bsp = jSONObject.optInt("cursorSpacing");
        this.bsq = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
        this.bsr = jSONObject.optInt("selectionStart");
        this.bss = jSONObject.optInt("selectionEnd");
        this.bst = jSONObject.optBoolean("adjustPosition", true);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("style");
        this.bsy = optJSONObject2.optJSONArray("padding");
        this.mFontSize = optJSONObject2.optInt("fontSize");
        this.bsu = optJSONObject2.optString("fontWeight");
        this.mColor = optJSONObject2.optString("color");
        this.bsw = optJSONObject2.optString("textAlign");
        int S = z.S(a(optJSONObject2, "minHeight", 0.0f));
        if (S < 0) {
            S = 0;
        }
        this.bsz = S;
        int S2 = z.S(a(optJSONObject2, "maxHeight", 2.1474836E9f));
        if (S2 < 0) {
            S2 = Integer.MAX_VALUE;
        }
        this.mMaxHeight = S2;
        this.bsv = z.S((float) optJSONObject2.optDouble("lineSpace"));
        this.bsx = jSONObject.optBoolean("disabled", false);
        this.mLeft = this.aXJ.getLeft();
        this.mTop = this.aXJ.Mt();
        this.mWidth = this.aXJ.getWidth();
        this.mHeight = this.aXJ.getHeight();
    }
}
