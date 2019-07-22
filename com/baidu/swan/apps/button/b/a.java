package com.baidu.swan.apps.button.b;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.button.b.a;
import com.baidu.swan.apps.console.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a<M extends a> extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = b.DEBUG;
    public double acm;
    public double acn;
    public double aco;
    public double acp;
    public JSONObject akZ;
    public int ala;
    public float alb;
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
        this.akZ = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        if (this.akZ != null) {
            try {
                this.backgroundColor = Color.parseColor(this.akZ.optString("bgColor"));
            } catch (Exception e) {
                c.e("SwanAppNativeViewModel", "bgColor occurs exception", e);
                this.backgroundColor = 0;
            }
            this.ala = this.akZ.optInt("borderRadius");
            this.borderWidth = this.akZ.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.akZ.optString("borderColor"));
            } catch (Exception e2) {
                c.e("SwanAppNativeViewModel", "borderColor occurs exception", e2);
                this.borderColor = 0;
            }
            JSONArray optJSONArray = this.akZ.optJSONArray("padding");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                this.acm = optJSONArray.optDouble(3, 0.0d);
                this.acn = optJSONArray.optDouble(0, 0.0d);
                this.aco = optJSONArray.optDouble(1, 0.0d);
                this.acp = optJSONArray.optDouble(2, 0.0d);
            }
            this.alb = o.a(this.akZ, "opacity", -1.0f);
        }
    }

    public void a(M m, com.baidu.swan.apps.view.container.c.a aVar) {
        if (m != null && aVar != null) {
            if (!TextUtils.equals(this.id, m.id)) {
                aVar.eL(63);
                return;
            }
            if (this.aDW != null && !this.aDW.equals(m.aDW)) {
                aVar.eL(1);
            }
            if (m.hidden != this.hidden) {
                aVar.eL(8);
            }
            if (m.akZ != null) {
                if (this.akZ == null || !TextUtils.equals(this.akZ.toString(), m.akZ.toString())) {
                    aVar.eL(2);
                }
            }
        }
    }
}
