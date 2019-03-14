package com.baidu.swan.apps.textarea.b;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.console.c;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.ubc.UBC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.model.a.a.a {
    public boolean aBJ;
    public String aUU;
    public int aUV;
    public String aUW;
    public String aUX;
    public boolean aUY;
    public boolean aUZ;
    public boolean aVa;
    public int aVb;
    public int aVc;
    public int aVd;
    public int aVe;
    public int aVf;
    public boolean aVg;
    public String aVh;
    public String aVi;
    public int aVj;
    public String aVk;
    public boolean aVl;
    public JSONArray aVm;
    public int aVn;
    public int aVo;
    public int mFontSize;
    public int mHeight;
    public int mLeft;
    public int mMaxHeight;
    public int mTop;
    public String mValue;
    public int mWidth;

    public static a aj(JSONObject jSONObject) {
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
            aVar2.aVo = aVar.aVo;
            aVar2.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE, aVar.mValue);
            aVar2.aUU = jSONObject.optString("placeholder", aVar.aUU);
            JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
            aVar2.aUV = optJSONObject.optInt("fontSize", aVar.aUV);
            aVar2.aUW = optJSONObject.optString("fontWeight", aVar.aUW);
            aVar2.aUX = optJSONObject.optString("color", aVar.aUX);
            aVar2.aUY = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, aVar.aUY);
            aVar2.aUZ = jSONObject.optBoolean("autoHeight", aVar.aUZ);
            aVar2.aBJ = jSONObject.optBoolean("fixed", aVar.aBJ);
            aVar2.aVa = jSONObject.optBoolean("showConfirmBar", aVar.aVa);
            aVar2.aVb = jSONObject.optInt("maxLength", aVar.aVb);
            aVar2.aVc = jSONObject.optInt("cursorSpacing", aVar.aVc);
            aVar2.aVd = jSONObject.optInt("cursor", aVar.aVd);
            aVar2.aVe = jSONObject.optInt("selectionStart", aVar.aVe);
            aVar2.aVf = jSONObject.optInt("selectionEnd", aVar.aVf);
            aVar2.aVg = jSONObject.optBoolean("adjustPosition", aVar.aVg);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            aVar2.aVm = optJSONObject2.optJSONArray("padding");
            aVar2.mFontSize = optJSONObject2.optInt("fontSize", aVar.mFontSize);
            aVar2.aVh = optJSONObject2.optString("fontWeight", aVar.aVh);
            aVar2.aVi = optJSONObject2.optString("color", aVar.aVi);
            aVar2.aVk = optJSONObject2.optString("textAlign", aVar.aVk);
            int ad = x.ad(a(optJSONObject2, "minHeight", x.ae(aVar.aVn)));
            if (ad < 0) {
                ad = 0;
            }
            aVar2.aVn = ad;
            int ad2 = x.ad(a(optJSONObject2, "maxHeight", x.ae(aVar.mMaxHeight)));
            if (ad2 < 0) {
                ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            aVar2.mMaxHeight = ad2;
            aVar2.aVj = x.ad((float) optJSONObject2.optDouble("lineSpace", x.ae(aVar.aVj)));
            aVar2.aVl = jSONObject.optBoolean("disabled", aVar.aVl);
            aVar2.mLeft = aVar2.aBF.getLeft();
            aVar2.mTop = aVar2.aBF.getTop();
            aVar2.mWidth = aVar2.aBF.getWidth();
            aVar2.mHeight = aVar2.aBF.getHeight();
        }
        return aVar2;
    }

    private a() {
        super("inputId", "textArea");
        this.aVo = 1;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
        this.aUU = jSONObject.optString("placeholder");
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        this.aUV = optJSONObject.optInt("fontSize");
        this.aUW = optJSONObject.optString("fontWeight");
        this.aUX = optJSONObject.optString("color");
        this.aUY = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        this.aUZ = jSONObject.optBoolean("autoHeight", false);
        this.aBJ = jSONObject.optBoolean("fixed");
        this.aVa = jSONObject.optBoolean("showConfirmBar", true);
        this.aVb = jSONObject.optInt("maxLength");
        this.aVc = jSONObject.optInt("cursorSpacing");
        this.aVd = jSONObject.optInt("cursor");
        this.aVe = jSONObject.optInt("selectionStart");
        this.aVf = jSONObject.optInt("selectionEnd");
        this.aVg = jSONObject.optBoolean("adjustPosition", true);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        this.aVm = optJSONObject2.optJSONArray("padding");
        this.mFontSize = optJSONObject2.optInt("fontSize");
        this.aVh = optJSONObject2.optString("fontWeight");
        this.aVi = optJSONObject2.optString("color");
        this.aVk = optJSONObject2.optString("textAlign");
        int ad = x.ad(a(optJSONObject2, "minHeight", 0.0f));
        if (ad < 0) {
            ad = 0;
        }
        this.aVn = ad;
        int ad2 = x.ad(a(optJSONObject2, "maxHeight", 2.1474836E9f));
        if (ad2 < 0) {
            ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        this.mMaxHeight = ad2;
        this.aVj = x.ad((float) optJSONObject2.optDouble("lineSpace"));
        this.aVl = jSONObject.optBoolean("disabled", false);
        this.mLeft = this.aBF.getLeft();
        this.mTop = this.aBF.getTop();
        this.mWidth = this.aBF.getWidth();
        this.mHeight = this.aBF.getHeight();
    }
}
