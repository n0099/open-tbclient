package com.baidu.swan.apps.button.b;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.button.b.a;
import com.baidu.swan.apps.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a<M extends a> extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = c.DEBUG;
    public double adT;
    public double adU;
    public double adV;
    public double adW;
    public JSONObject akf;
    public int akg;
    public float alpha;
    public int backgroundColor;
    public int borderColor;
    public int borderWidth;

    public a(String str, String str2) {
        super(str, str2);
        this.backgroundColor = 0;
        this.borderColor = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.akf = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        if (this.akf != null) {
            try {
                this.backgroundColor = Color.parseColor(this.akf.optString("bgColor"));
            } catch (Exception e) {
                com.baidu.swan.apps.console.c.e("SwanAppNativeViewModel", "bgColor occurs exception", e);
                this.backgroundColor = 0;
            }
            this.akg = this.akf.optInt("borderRadius");
            this.borderWidth = this.akf.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.akf.optString("borderColor"));
            } catch (Exception e2) {
                com.baidu.swan.apps.console.c.e("SwanAppNativeViewModel", "borderColor occurs exception", e2);
                this.borderColor = 0;
            }
            JSONArray optJSONArray = this.akf.optJSONArray("padding");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                this.adT = optJSONArray.optDouble(3, 0.0d);
                this.adU = optJSONArray.optDouble(0, 0.0d);
                this.adV = optJSONArray.optDouble(1, 0.0d);
                this.adW = optJSONArray.optDouble(2, 0.0d);
            }
            this.alpha = n.a(this.akf, "opacity", -1.0f);
        }
    }

    public void a(M m, com.baidu.swan.apps.view.container.c.a aVar) {
        if (m != null && aVar != null) {
            if (!TextUtils.equals(this.id, m.id)) {
                aVar.ex(63);
                return;
            }
            if (this.aBE != null && !this.aBE.equals(m.aBE)) {
                aVar.ex(1);
            }
            if (m.hidden != this.hidden) {
                aVar.ex(8);
            }
            if (m.akf != null) {
                if (this.akf == null || !TextUtils.equals(this.akf.toString(), m.akf.toString())) {
                    aVar.ex(2);
                }
            }
        }
    }
}
