package com.baidu.swan.apps.button.b;

import android.graphics.Color;
import android.text.TextUtils;
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
    public double Ml;
    public double Mm;
    public double Mn;
    public double Mo;
    public JSONObject aET;
    public int aEU;
    public float aEV;
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
        this.aET = jSONObject.optJSONObject("style");
        if (this.aET != null) {
            try {
                this.backgroundColor = Color.parseColor(this.aET.optString("bgColor"));
            } catch (Exception e) {
                c.e("SwanAppNativeViewModel", "bgColor occurs exception", e);
                this.backgroundColor = 0;
            }
            this.aEU = this.aET.optInt("borderRadius");
            this.borderWidth = this.aET.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.aET.optString("borderColor"));
            } catch (Exception e2) {
                c.e("SwanAppNativeViewModel", "borderColor occurs exception", e2);
                this.borderColor = 0;
            }
            JSONArray optJSONArray = this.aET.optJSONArray("padding");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                this.Ml = optJSONArray.optDouble(3, 0.0d);
                this.Mm = optJSONArray.optDouble(0, 0.0d);
                this.Mn = optJSONArray.optDouble(1, 0.0d);
                this.Mo = optJSONArray.optDouble(2, 0.0d);
            }
            this.aEV = o.a(this.aET, "opacity", -1.0f);
        }
    }

    public void a(M m, com.baidu.swan.apps.view.container.c.a aVar) {
        if (m != null && aVar != null) {
            if (!TextUtils.equals(this.id, m.id)) {
                aVar.fH(63);
                return;
            }
            if (this.aXJ != null && !this.aXJ.equals(m.aXJ)) {
                aVar.fH(1);
            }
            if (m.hidden != this.hidden) {
                aVar.fH(8);
            }
            if (m.aET != null) {
                if (this.aET == null || !TextUtils.equals(this.aET.toString(), m.aET.toString())) {
                    aVar.fH(2);
                }
            }
        }
    }
}
