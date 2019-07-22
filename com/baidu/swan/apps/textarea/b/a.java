package com.baidu.swan.apps.textarea.b;

import android.support.v7.widget.ActivityChooserView;
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
    public boolean aEa;
    public String aYI;
    public int aYJ;
    public String aYK;
    public String aYL;
    public boolean aYM;
    public boolean aYN;
    public boolean aYO;
    public int aYP;
    public int aYQ;
    public int aYR;
    public int aYS;
    public int aYT;
    public boolean aYU;
    public String aYV;
    public String aYW;
    public int aYX;
    public String aYY;
    public boolean aYZ;
    public JSONArray aZa;
    public int aZb;
    public int aZc;
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
            aVar2.aZc = aVar.aZc;
            aVar2.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE, aVar.mValue);
            aVar2.aYI = jSONObject.optString("placeholder", aVar.aYI);
            JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
            aVar2.aYJ = optJSONObject.optInt("fontSize", aVar.aYJ);
            aVar2.aYK = optJSONObject.optString("fontWeight", aVar.aYK);
            aVar2.aYL = optJSONObject.optString("color", aVar.aYL);
            aVar2.aYM = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, aVar.aYM);
            aVar2.aYN = jSONObject.optBoolean("autoHeight", aVar.aYN);
            aVar2.aEa = jSONObject.optBoolean("fixed", aVar.aEa);
            aVar2.aYO = jSONObject.optBoolean("showConfirmBar", aVar.aYO);
            aVar2.aYP = jSONObject.optInt("maxLength", aVar.aYP);
            aVar2.aYQ = jSONObject.optInt("cursorSpacing", aVar.aYQ);
            aVar2.aYR = jSONObject.optInt("cursor", aVar.aYR);
            aVar2.aYS = jSONObject.optInt("selectionStart", aVar.aYS);
            aVar2.aYT = jSONObject.optInt("selectionEnd", aVar.aYT);
            aVar2.aYU = jSONObject.optBoolean("adjustPosition", aVar.aYU);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            aVar2.aZa = optJSONObject2.optJSONArray("padding");
            aVar2.mFontSize = optJSONObject2.optInt("fontSize", aVar.mFontSize);
            aVar2.aYV = optJSONObject2.optString("fontWeight", aVar.aYV);
            aVar2.aYW = optJSONObject2.optString("color", aVar.aYW);
            aVar2.aYY = optJSONObject2.optString("textAlign", aVar.aYY);
            int ad = z.ad(a(optJSONObject2, "minHeight", z.af(aVar.aZb)));
            if (ad < 0) {
                ad = 0;
            }
            aVar2.aZb = ad;
            int ad2 = z.ad(a(optJSONObject2, "maxHeight", z.af(aVar.mMaxHeight)));
            if (ad2 < 0) {
                ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            aVar2.mMaxHeight = ad2;
            aVar2.aYX = z.ad((float) optJSONObject2.optDouble("lineSpace", z.af(aVar.aYX)));
            aVar2.aYZ = jSONObject.optBoolean("disabled", aVar.aYZ);
            aVar2.mLeft = aVar2.aDW.getLeft();
            aVar2.mTop = aVar2.aDW.Hv();
            aVar2.mWidth = aVar2.aDW.getWidth();
            aVar2.mHeight = aVar2.aDW.getHeight();
        }
        return aVar2;
    }

    private a() {
        super("inputId", "textArea");
        this.aZc = 1;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
        this.aYI = jSONObject.optString("placeholder");
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        this.aYJ = optJSONObject.optInt("fontSize");
        this.aYK = optJSONObject.optString("fontWeight");
        this.aYL = optJSONObject.optString("color");
        this.aYM = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        this.aYN = jSONObject.optBoolean("autoHeight", false);
        this.aEa = jSONObject.optBoolean("fixed");
        this.aYO = jSONObject.optBoolean("showConfirmBar", true);
        this.aYP = jSONObject.optInt("maxLength");
        this.aYQ = jSONObject.optInt("cursorSpacing");
        this.aYR = jSONObject.optInt("cursor");
        this.aYS = jSONObject.optInt("selectionStart");
        this.aYT = jSONObject.optInt("selectionEnd");
        this.aYU = jSONObject.optBoolean("adjustPosition", true);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        this.aZa = optJSONObject2.optJSONArray("padding");
        this.mFontSize = optJSONObject2.optInt("fontSize");
        this.aYV = optJSONObject2.optString("fontWeight");
        this.aYW = optJSONObject2.optString("color");
        this.aYY = optJSONObject2.optString("textAlign");
        int ad = z.ad(a(optJSONObject2, "minHeight", 0.0f));
        if (ad < 0) {
            ad = 0;
        }
        this.aZb = ad;
        int ad2 = z.ad(a(optJSONObject2, "maxHeight", 2.1474836E9f));
        if (ad2 < 0) {
            ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        this.mMaxHeight = ad2;
        this.aYX = z.ad((float) optJSONObject2.optDouble("lineSpace"));
        this.aYZ = jSONObject.optBoolean("disabled", false);
        this.mLeft = this.aDW.getLeft();
        this.mTop = this.aDW.Hv();
        this.mWidth = this.aDW.getWidth();
        this.mHeight = this.aDW.getHeight();
    }
}
