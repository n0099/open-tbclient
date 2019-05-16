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
    public boolean aDs;
    public String aXY;
    public int aXZ;
    public String aYa;
    public String aYb;
    public boolean aYc;
    public boolean aYd;
    public boolean aYe;
    public int aYf;
    public int aYg;
    public int aYh;
    public int aYi;
    public int aYj;
    public boolean aYk;
    public String aYl;
    public String aYm;
    public int aYn;
    public String aYo;
    public boolean aYp;
    public JSONArray aYq;
    public int aYr;
    public int aYs;
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
            aVar2.aYs = aVar.aYs;
            aVar2.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE, aVar.mValue);
            aVar2.aXY = jSONObject.optString("placeholder", aVar.aXY);
            JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
            aVar2.aXZ = optJSONObject.optInt("fontSize", aVar.aXZ);
            aVar2.aYa = optJSONObject.optString("fontWeight", aVar.aYa);
            aVar2.aYb = optJSONObject.optString("color", aVar.aYb);
            aVar2.aYc = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, aVar.aYc);
            aVar2.aYd = jSONObject.optBoolean("autoHeight", aVar.aYd);
            aVar2.aDs = jSONObject.optBoolean("fixed", aVar.aDs);
            aVar2.aYe = jSONObject.optBoolean("showConfirmBar", aVar.aYe);
            aVar2.aYf = jSONObject.optInt("maxLength", aVar.aYf);
            aVar2.aYg = jSONObject.optInt("cursorSpacing", aVar.aYg);
            aVar2.aYh = jSONObject.optInt("cursor", aVar.aYh);
            aVar2.aYi = jSONObject.optInt("selectionStart", aVar.aYi);
            aVar2.aYj = jSONObject.optInt("selectionEnd", aVar.aYj);
            aVar2.aYk = jSONObject.optBoolean("adjustPosition", aVar.aYk);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            aVar2.aYq = optJSONObject2.optJSONArray("padding");
            aVar2.mFontSize = optJSONObject2.optInt("fontSize", aVar.mFontSize);
            aVar2.aYl = optJSONObject2.optString("fontWeight", aVar.aYl);
            aVar2.aYm = optJSONObject2.optString("color", aVar.aYm);
            aVar2.aYo = optJSONObject2.optString("textAlign", aVar.aYo);
            int ad = z.ad(a(optJSONObject2, "minHeight", z.af(aVar.aYr)));
            if (ad < 0) {
                ad = 0;
            }
            aVar2.aYr = ad;
            int ad2 = z.ad(a(optJSONObject2, "maxHeight", z.af(aVar.mMaxHeight)));
            if (ad2 < 0) {
                ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            aVar2.mMaxHeight = ad2;
            aVar2.aYn = z.ad((float) optJSONObject2.optDouble("lineSpace", z.af(aVar.aYn)));
            aVar2.aYp = jSONObject.optBoolean("disabled", aVar.aYp);
            aVar2.mLeft = aVar2.aDo.getLeft();
            aVar2.mTop = aVar2.aDo.getTop();
            aVar2.mWidth = aVar2.aDo.getWidth();
            aVar2.mHeight = aVar2.aDo.getHeight();
        }
        return aVar2;
    }

    private a() {
        super("inputId", "textArea");
        this.aYs = 1;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
        this.aXY = jSONObject.optString("placeholder");
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        this.aXZ = optJSONObject.optInt("fontSize");
        this.aYa = optJSONObject.optString("fontWeight");
        this.aYb = optJSONObject.optString("color");
        this.aYc = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        this.aYd = jSONObject.optBoolean("autoHeight", false);
        this.aDs = jSONObject.optBoolean("fixed");
        this.aYe = jSONObject.optBoolean("showConfirmBar", true);
        this.aYf = jSONObject.optInt("maxLength");
        this.aYg = jSONObject.optInt("cursorSpacing");
        this.aYh = jSONObject.optInt("cursor");
        this.aYi = jSONObject.optInt("selectionStart");
        this.aYj = jSONObject.optInt("selectionEnd");
        this.aYk = jSONObject.optBoolean("adjustPosition", true);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        this.aYq = optJSONObject2.optJSONArray("padding");
        this.mFontSize = optJSONObject2.optInt("fontSize");
        this.aYl = optJSONObject2.optString("fontWeight");
        this.aYm = optJSONObject2.optString("color");
        this.aYo = optJSONObject2.optString("textAlign");
        int ad = z.ad(a(optJSONObject2, "minHeight", 0.0f));
        if (ad < 0) {
            ad = 0;
        }
        this.aYr = ad;
        int ad2 = z.ad(a(optJSONObject2, "maxHeight", 2.1474836E9f));
        if (ad2 < 0) {
            ad2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        this.mMaxHeight = ad2;
        this.aYn = z.ad((float) optJSONObject2.optDouble("lineSpace"));
        this.aYp = jSONObject.optBoolean("disabled", false);
        this.mLeft = this.aDo.getLeft();
        this.mTop = this.aDo.getTop();
        this.mWidth = this.aDo.getWidth();
        this.mHeight = this.aDo.getHeight();
    }
}
