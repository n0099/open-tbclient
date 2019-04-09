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
    public boolean aBN;
    public String aUY;
    public int aUZ;
    public String aVa;
    public String aVb;
    public boolean aVc;
    public boolean aVd;
    public boolean aVe;
    public int aVf;
    public int aVg;
    public int aVh;
    public int aVi;
    public int aVj;
    public boolean aVk;
    public String aVl;
    public String aVm;
    public int aVn;
    public String aVo;
    public boolean aVp;
    public JSONArray aVq;
    public int aVr;
    public int aVs;
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
            aVar2.aVs = aVar.aVs;
            aVar2.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE, aVar.mValue);
            aVar2.aUY = jSONObject.optString("placeholder", aVar.aUY);
            JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
            aVar2.aUZ = optJSONObject.optInt("fontSize", aVar.aUZ);
            aVar2.aVa = optJSONObject.optString("fontWeight", aVar.aVa);
            aVar2.aVb = optJSONObject.optString("color", aVar.aVb);
            aVar2.aVc = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, aVar.aVc);
            aVar2.aVd = jSONObject.optBoolean("autoHeight", aVar.aVd);
            aVar2.aBN = jSONObject.optBoolean("fixed", aVar.aBN);
            aVar2.aVe = jSONObject.optBoolean("showConfirmBar", aVar.aVe);
            aVar2.aVf = jSONObject.optInt("maxLength", aVar.aVf);
            aVar2.aVg = jSONObject.optInt("cursorSpacing", aVar.aVg);
            aVar2.aVh = jSONObject.optInt("cursor", aVar.aVh);
            aVar2.aVi = jSONObject.optInt("selectionStart", aVar.aVi);
            aVar2.aVj = jSONObject.optInt("selectionEnd", aVar.aVj);
            aVar2.aVk = jSONObject.optBoolean("adjustPosition", aVar.aVk);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            aVar2.aVq = optJSONObject2.optJSONArray("padding");
            aVar2.mFontSize = optJSONObject2.optInt("fontSize", aVar.mFontSize);
            aVar2.aVl = optJSONObject2.optString("fontWeight", aVar.aVl);
            aVar2.aVm = optJSONObject2.optString("color", aVar.aVm);
            aVar2.aVo = optJSONObject2.optString("textAlign", aVar.aVo);
            int ad = x.ad(a(optJSONObject2, "minHeight", x.ae(aVar.aVr)));
            if (ad < 0) {
                ad = 0;
            }
            aVar2.aVr = ad;
            int ad2 = x.ad(a(optJSONObject2, "maxHeight", x.ae(aVar.mMaxHeight)));
            if (ad2 < 0) {
                ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            aVar2.mMaxHeight = ad2;
            aVar2.aVn = x.ad((float) optJSONObject2.optDouble("lineSpace", x.ae(aVar.aVn)));
            aVar2.aVp = jSONObject.optBoolean("disabled", aVar.aVp);
            aVar2.mLeft = aVar2.aBJ.getLeft();
            aVar2.mTop = aVar2.aBJ.getTop();
            aVar2.mWidth = aVar2.aBJ.getWidth();
            aVar2.mHeight = aVar2.aBJ.getHeight();
        }
        return aVar2;
    }

    private a() {
        super("inputId", "textArea");
        this.aVs = 1;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
        this.aUY = jSONObject.optString("placeholder");
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        this.aUZ = optJSONObject.optInt("fontSize");
        this.aVa = optJSONObject.optString("fontWeight");
        this.aVb = optJSONObject.optString("color");
        this.aVc = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        this.aVd = jSONObject.optBoolean("autoHeight", false);
        this.aBN = jSONObject.optBoolean("fixed");
        this.aVe = jSONObject.optBoolean("showConfirmBar", true);
        this.aVf = jSONObject.optInt("maxLength");
        this.aVg = jSONObject.optInt("cursorSpacing");
        this.aVh = jSONObject.optInt("cursor");
        this.aVi = jSONObject.optInt("selectionStart");
        this.aVj = jSONObject.optInt("selectionEnd");
        this.aVk = jSONObject.optBoolean("adjustPosition", true);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        this.aVq = optJSONObject2.optJSONArray("padding");
        this.mFontSize = optJSONObject2.optInt("fontSize");
        this.aVl = optJSONObject2.optString("fontWeight");
        this.aVm = optJSONObject2.optString("color");
        this.aVo = optJSONObject2.optString("textAlign");
        int ad = x.ad(a(optJSONObject2, "minHeight", 0.0f));
        if (ad < 0) {
            ad = 0;
        }
        this.aVr = ad;
        int ad2 = x.ad(a(optJSONObject2, "maxHeight", 2.1474836E9f));
        if (ad2 < 0) {
            ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        this.mMaxHeight = ad2;
        this.aVn = x.ad((float) optJSONObject2.optDouble("lineSpace"));
        this.aVp = jSONObject.optBoolean("disabled", false);
        this.mLeft = this.aBJ.getLeft();
        this.mTop = this.aBJ.getTop();
        this.mWidth = this.aBJ.getWidth();
        this.mHeight = this.aBJ.getHeight();
    }
}
