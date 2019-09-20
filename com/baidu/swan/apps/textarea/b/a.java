package com.baidu.swan.apps.textarea.b;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.console.c;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.ubc.UBC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.model.a.a.a {
    public boolean aEy;
    public int aZA;
    public String aZg;
    public int aZh;
    public String aZi;
    public String aZj;
    public boolean aZk;
    public boolean aZl;
    public boolean aZm;
    public int aZn;
    public int aZo;
    public int aZp;
    public int aZq;
    public int aZr;
    public boolean aZs;
    public String aZt;
    public String aZu;
    public int aZv;
    public String aZw;
    public boolean aZx;
    public JSONArray aZy;
    public int aZz;
    public int mFontSize;
    public int mHeight;
    public int mLeft;
    public int mMaxHeight;
    public int mTop;
    public String mValue;
    public int mWidth;

    public static a al(JSONObject jSONObject) {
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
            aVar2.aZA = aVar.aZA;
            aVar2.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE, aVar.mValue);
            aVar2.aZg = jSONObject.optString("placeholder", aVar.aZg);
            JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
            aVar2.aZh = optJSONObject.optInt("fontSize", aVar.aZh);
            aVar2.aZi = optJSONObject.optString("fontWeight", aVar.aZi);
            aVar2.aZj = optJSONObject.optString("color", aVar.aZj);
            aVar2.aZk = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, aVar.aZk);
            aVar2.aZl = jSONObject.optBoolean("autoHeight", aVar.aZl);
            aVar2.aEy = jSONObject.optBoolean("fixed", aVar.aEy);
            aVar2.aZm = jSONObject.optBoolean("showConfirmBar", aVar.aZm);
            aVar2.aZn = jSONObject.optInt("maxLength", aVar.aZn);
            aVar2.aZo = jSONObject.optInt("cursorSpacing", aVar.aZo);
            aVar2.aZp = jSONObject.optInt("cursor", aVar.aZp);
            aVar2.aZq = jSONObject.optInt("selectionStart", aVar.aZq);
            aVar2.aZr = jSONObject.optInt("selectionEnd", aVar.aZr);
            aVar2.aZs = jSONObject.optBoolean("adjustPosition", aVar.aZs);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            aVar2.aZy = optJSONObject2.optJSONArray("padding");
            aVar2.mFontSize = optJSONObject2.optInt("fontSize", aVar.mFontSize);
            aVar2.aZt = optJSONObject2.optString("fontWeight", aVar.aZt);
            aVar2.aZu = optJSONObject2.optString("color", aVar.aZu);
            aVar2.aZw = optJSONObject2.optString("textAlign", aVar.aZw);
            int ad = z.ad(a(optJSONObject2, "minHeight", z.af(aVar.aZz)));
            if (ad < 0) {
                ad = 0;
            }
            aVar2.aZz = ad;
            int ad2 = z.ad(a(optJSONObject2, "maxHeight", z.af(aVar.mMaxHeight)));
            if (ad2 < 0) {
                ad2 = Integer.MAX_VALUE;
            }
            aVar2.mMaxHeight = ad2;
            aVar2.aZv = z.ad((float) optJSONObject2.optDouble("lineSpace", z.af(aVar.aZv)));
            aVar2.aZx = jSONObject.optBoolean("disabled", aVar.aZx);
            aVar2.mLeft = aVar2.aEu.getLeft();
            aVar2.mTop = aVar2.aEu.Hz();
            aVar2.mWidth = aVar2.aEu.getWidth();
            aVar2.mHeight = aVar2.aEu.getHeight();
        }
        return aVar2;
    }

    private a() {
        super("inputId", "textArea");
        this.aZA = 1;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
        this.aZg = jSONObject.optString("placeholder");
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        this.aZh = optJSONObject.optInt("fontSize");
        this.aZi = optJSONObject.optString("fontWeight");
        this.aZj = optJSONObject.optString("color");
        this.aZk = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        this.aZl = jSONObject.optBoolean("autoHeight", false);
        this.aEy = jSONObject.optBoolean("fixed");
        this.aZm = jSONObject.optBoolean("showConfirmBar", true);
        this.aZn = jSONObject.optInt("maxLength");
        this.aZo = jSONObject.optInt("cursorSpacing");
        this.aZp = jSONObject.optInt("cursor");
        this.aZq = jSONObject.optInt("selectionStart");
        this.aZr = jSONObject.optInt("selectionEnd");
        this.aZs = jSONObject.optBoolean("adjustPosition", true);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        this.aZy = optJSONObject2.optJSONArray("padding");
        this.mFontSize = optJSONObject2.optInt("fontSize");
        this.aZt = optJSONObject2.optString("fontWeight");
        this.aZu = optJSONObject2.optString("color");
        this.aZw = optJSONObject2.optString("textAlign");
        int ad = z.ad(a(optJSONObject2, "minHeight", 0.0f));
        if (ad < 0) {
            ad = 0;
        }
        this.aZz = ad;
        int ad2 = z.ad(a(optJSONObject2, "maxHeight", 2.1474836E9f));
        if (ad2 < 0) {
            ad2 = Integer.MAX_VALUE;
        }
        this.mMaxHeight = ad2;
        this.aZv = z.ad((float) optJSONObject2.optDouble("lineSpace"));
        this.aZx = jSONObject.optBoolean("disabled", false);
        this.mLeft = this.aEu.getLeft();
        this.mTop = this.aEu.Hz();
        this.mWidth = this.aEu.getWidth();
        this.mHeight = this.aEu.getHeight();
    }
}
