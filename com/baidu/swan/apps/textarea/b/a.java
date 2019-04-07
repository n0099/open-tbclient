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
    public boolean aBM;
    public String aUX;
    public int aUY;
    public String aUZ;
    public String aVa;
    public boolean aVb;
    public boolean aVc;
    public boolean aVd;
    public int aVe;
    public int aVf;
    public int aVg;
    public int aVh;
    public int aVi;
    public boolean aVj;
    public String aVk;
    public String aVl;
    public int aVm;
    public String aVn;
    public boolean aVo;
    public JSONArray aVp;
    public int aVq;
    public int aVr;
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
            aVar2.aVr = aVar.aVr;
            aVar2.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE, aVar.mValue);
            aVar2.aUX = jSONObject.optString("placeholder", aVar.aUX);
            JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
            aVar2.aUY = optJSONObject.optInt("fontSize", aVar.aUY);
            aVar2.aUZ = optJSONObject.optString("fontWeight", aVar.aUZ);
            aVar2.aVa = optJSONObject.optString("color", aVar.aVa);
            aVar2.aVb = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, aVar.aVb);
            aVar2.aVc = jSONObject.optBoolean("autoHeight", aVar.aVc);
            aVar2.aBM = jSONObject.optBoolean("fixed", aVar.aBM);
            aVar2.aVd = jSONObject.optBoolean("showConfirmBar", aVar.aVd);
            aVar2.aVe = jSONObject.optInt("maxLength", aVar.aVe);
            aVar2.aVf = jSONObject.optInt("cursorSpacing", aVar.aVf);
            aVar2.aVg = jSONObject.optInt("cursor", aVar.aVg);
            aVar2.aVh = jSONObject.optInt("selectionStart", aVar.aVh);
            aVar2.aVi = jSONObject.optInt("selectionEnd", aVar.aVi);
            aVar2.aVj = jSONObject.optBoolean("adjustPosition", aVar.aVj);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            aVar2.aVp = optJSONObject2.optJSONArray("padding");
            aVar2.mFontSize = optJSONObject2.optInt("fontSize", aVar.mFontSize);
            aVar2.aVk = optJSONObject2.optString("fontWeight", aVar.aVk);
            aVar2.aVl = optJSONObject2.optString("color", aVar.aVl);
            aVar2.aVn = optJSONObject2.optString("textAlign", aVar.aVn);
            int ad = x.ad(a(optJSONObject2, "minHeight", x.ae(aVar.aVq)));
            if (ad < 0) {
                ad = 0;
            }
            aVar2.aVq = ad;
            int ad2 = x.ad(a(optJSONObject2, "maxHeight", x.ae(aVar.mMaxHeight)));
            if (ad2 < 0) {
                ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            aVar2.mMaxHeight = ad2;
            aVar2.aVm = x.ad((float) optJSONObject2.optDouble("lineSpace", x.ae(aVar.aVm)));
            aVar2.aVo = jSONObject.optBoolean("disabled", aVar.aVo);
            aVar2.mLeft = aVar2.aBI.getLeft();
            aVar2.mTop = aVar2.aBI.getTop();
            aVar2.mWidth = aVar2.aBI.getWidth();
            aVar2.mHeight = aVar2.aBI.getHeight();
        }
        return aVar2;
    }

    private a() {
        super("inputId", "textArea");
        this.aVr = 1;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
        this.aUX = jSONObject.optString("placeholder");
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        this.aUY = optJSONObject.optInt("fontSize");
        this.aUZ = optJSONObject.optString("fontWeight");
        this.aVa = optJSONObject.optString("color");
        this.aVb = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        this.aVc = jSONObject.optBoolean("autoHeight", false);
        this.aBM = jSONObject.optBoolean("fixed");
        this.aVd = jSONObject.optBoolean("showConfirmBar", true);
        this.aVe = jSONObject.optInt("maxLength");
        this.aVf = jSONObject.optInt("cursorSpacing");
        this.aVg = jSONObject.optInt("cursor");
        this.aVh = jSONObject.optInt("selectionStart");
        this.aVi = jSONObject.optInt("selectionEnd");
        this.aVj = jSONObject.optBoolean("adjustPosition", true);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        this.aVp = optJSONObject2.optJSONArray("padding");
        this.mFontSize = optJSONObject2.optInt("fontSize");
        this.aVk = optJSONObject2.optString("fontWeight");
        this.aVl = optJSONObject2.optString("color");
        this.aVn = optJSONObject2.optString("textAlign");
        int ad = x.ad(a(optJSONObject2, "minHeight", 0.0f));
        if (ad < 0) {
            ad = 0;
        }
        this.aVq = ad;
        int ad2 = x.ad(a(optJSONObject2, "maxHeight", 2.1474836E9f));
        if (ad2 < 0) {
            ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        this.mMaxHeight = ad2;
        this.aVm = x.ad((float) optJSONObject2.optDouble("lineSpace"));
        this.aVo = jSONObject.optBoolean("disabled", false);
        this.mLeft = this.aBI.getLeft();
        this.mTop = this.aBI.getTop();
        this.mWidth = this.aBI.getWidth();
        this.mHeight = this.aBI.getHeight();
    }
}
