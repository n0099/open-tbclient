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
    public float alA;
    public JSONObject aly;
    public int alz;
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
        this.aly = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        if (this.aly != null) {
            try {
                this.backgroundColor = Color.parseColor(this.aly.optString("bgColor"));
            } catch (Exception e) {
                c.e("SwanAppNativeViewModel", "bgColor occurs exception", e);
                this.backgroundColor = 0;
            }
            this.alz = this.aly.optInt("borderRadius");
            this.borderWidth = this.aly.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.aly.optString("borderColor"));
            } catch (Exception e2) {
                c.e("SwanAppNativeViewModel", "borderColor occurs exception", e2);
                this.borderColor = 0;
            }
            JSONArray optJSONArray = this.aly.optJSONArray("padding");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                this.acm = optJSONArray.optDouble(3, 0.0d);
                this.acn = optJSONArray.optDouble(0, 0.0d);
                this.aco = optJSONArray.optDouble(1, 0.0d);
                this.acp = optJSONArray.optDouble(2, 0.0d);
            }
            this.alA = o.a(this.aly, "opacity", -1.0f);
        }
    }

    public void a(M m, com.baidu.swan.apps.view.container.c.a aVar) {
        if (m != null && aVar != null) {
            if (!TextUtils.equals(this.id, m.id)) {
                aVar.eM(63);
                return;
            }
            if (this.aEu != null && !this.aEu.equals(m.aEu)) {
                aVar.eM(1);
            }
            if (m.hidden != this.hidden) {
                aVar.eM(8);
            }
            if (m.aly != null) {
                if (this.aly == null || !TextUtils.equals(this.aly.toString(), m.aly.toString())) {
                    aVar.eM(2);
                }
            }
        }
    }
}
