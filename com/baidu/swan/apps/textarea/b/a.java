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
    public boolean aBI;
    public String aUT;
    public int aUU;
    public String aUV;
    public String aUW;
    public boolean aUX;
    public boolean aUY;
    public boolean aUZ;
    public int aVa;
    public int aVb;
    public int aVc;
    public int aVd;
    public int aVe;
    public boolean aVf;
    public String aVg;
    public String aVh;
    public int aVi;
    public String aVj;
    public boolean aVk;
    public JSONArray aVl;
    public int aVm;
    public int aVn;
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
            aVar2.aVn = aVar.aVn;
            aVar2.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE, aVar.mValue);
            aVar2.aUT = jSONObject.optString("placeholder", aVar.aUT);
            JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
            aVar2.aUU = optJSONObject.optInt("fontSize", aVar.aUU);
            aVar2.aUV = optJSONObject.optString("fontWeight", aVar.aUV);
            aVar2.aUW = optJSONObject.optString("color", aVar.aUW);
            aVar2.aUX = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, aVar.aUX);
            aVar2.aUY = jSONObject.optBoolean("autoHeight", aVar.aUY);
            aVar2.aBI = jSONObject.optBoolean("fixed", aVar.aBI);
            aVar2.aUZ = jSONObject.optBoolean("showConfirmBar", aVar.aUZ);
            aVar2.aVa = jSONObject.optInt("maxLength", aVar.aVa);
            aVar2.aVb = jSONObject.optInt("cursorSpacing", aVar.aVb);
            aVar2.aVc = jSONObject.optInt("cursor", aVar.aVc);
            aVar2.aVd = jSONObject.optInt("selectionStart", aVar.aVd);
            aVar2.aVe = jSONObject.optInt("selectionEnd", aVar.aVe);
            aVar2.aVf = jSONObject.optBoolean("adjustPosition", aVar.aVf);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            aVar2.aVl = optJSONObject2.optJSONArray("padding");
            aVar2.mFontSize = optJSONObject2.optInt("fontSize", aVar.mFontSize);
            aVar2.aVg = optJSONObject2.optString("fontWeight", aVar.aVg);
            aVar2.aVh = optJSONObject2.optString("color", aVar.aVh);
            aVar2.aVj = optJSONObject2.optString("textAlign", aVar.aVj);
            int ad = x.ad(a(optJSONObject2, "minHeight", x.ae(aVar.aVm)));
            if (ad < 0) {
                ad = 0;
            }
            aVar2.aVm = ad;
            int ad2 = x.ad(a(optJSONObject2, "maxHeight", x.ae(aVar.mMaxHeight)));
            if (ad2 < 0) {
                ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            aVar2.mMaxHeight = ad2;
            aVar2.aVi = x.ad((float) optJSONObject2.optDouble("lineSpace", x.ae(aVar.aVi)));
            aVar2.aVk = jSONObject.optBoolean("disabled", aVar.aVk);
            aVar2.mLeft = aVar2.aBE.getLeft();
            aVar2.mTop = aVar2.aBE.getTop();
            aVar2.mWidth = aVar2.aBE.getWidth();
            aVar2.mHeight = aVar2.aBE.getHeight();
        }
        return aVar2;
    }

    private a() {
        super("inputId", "textArea");
        this.aVn = 1;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
        this.aUT = jSONObject.optString("placeholder");
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        this.aUU = optJSONObject.optInt("fontSize");
        this.aUV = optJSONObject.optString("fontWeight");
        this.aUW = optJSONObject.optString("color");
        this.aUX = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        this.aUY = jSONObject.optBoolean("autoHeight", false);
        this.aBI = jSONObject.optBoolean("fixed");
        this.aUZ = jSONObject.optBoolean("showConfirmBar", true);
        this.aVa = jSONObject.optInt("maxLength");
        this.aVb = jSONObject.optInt("cursorSpacing");
        this.aVc = jSONObject.optInt("cursor");
        this.aVd = jSONObject.optInt("selectionStart");
        this.aVe = jSONObject.optInt("selectionEnd");
        this.aVf = jSONObject.optBoolean("adjustPosition", true);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        this.aVl = optJSONObject2.optJSONArray("padding");
        this.mFontSize = optJSONObject2.optInt("fontSize");
        this.aVg = optJSONObject2.optString("fontWeight");
        this.aVh = optJSONObject2.optString("color");
        this.aVj = optJSONObject2.optString("textAlign");
        int ad = x.ad(a(optJSONObject2, "minHeight", 0.0f));
        if (ad < 0) {
            ad = 0;
        }
        this.aVm = ad;
        int ad2 = x.ad(a(optJSONObject2, "maxHeight", 2.1474836E9f));
        if (ad2 < 0) {
            ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        this.mMaxHeight = ad2;
        this.aVi = x.ad((float) optJSONObject2.optDouble("lineSpace"));
        this.aVk = jSONObject.optBoolean("disabled", false);
        this.mLeft = this.aBE.getLeft();
        this.mTop = this.aBE.getTop();
        this.mWidth = this.aBE.getWidth();
        this.mHeight = this.aBE.getHeight();
    }
}
