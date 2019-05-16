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
    public double abO;
    public double abP;
    public double abQ;
    public double abR;
    public JSONObject akx;
    public int aky;
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
        this.akx = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        if (this.akx != null) {
            try {
                this.backgroundColor = Color.parseColor(this.akx.optString("bgColor"));
            } catch (Exception e) {
                c.e("SwanAppNativeViewModel", "bgColor occurs exception", e);
                this.backgroundColor = 0;
            }
            this.aky = this.akx.optInt("borderRadius");
            this.borderWidth = this.akx.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.akx.optString("borderColor"));
            } catch (Exception e2) {
                c.e("SwanAppNativeViewModel", "borderColor occurs exception", e2);
                this.borderColor = 0;
            }
            JSONArray optJSONArray = this.akx.optJSONArray("padding");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                this.abO = optJSONArray.optDouble(3, 0.0d);
                this.abP = optJSONArray.optDouble(0, 0.0d);
                this.abQ = optJSONArray.optDouble(1, 0.0d);
                this.abR = optJSONArray.optDouble(2, 0.0d);
            }
            this.alpha = o.a(this.akx, "opacity", -1.0f);
        }
    }

    public void a(M m, com.baidu.swan.apps.view.container.c.a aVar) {
        if (m != null && aVar != null) {
            if (!TextUtils.equals(this.id, m.id)) {
                aVar.eI(63);
                return;
            }
            if (this.aDo != null && !this.aDo.equals(m.aDo)) {
                aVar.eI(1);
            }
            if (m.hidden != this.hidden) {
                aVar.eI(8);
            }
            if (m.akx != null) {
                if (this.akx == null || !TextUtils.equals(this.akx.toString(), m.akx.toString())) {
                    aVar.eI(2);
                }
            }
        }
    }
}
