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
    public double LJ;
    public double LK;
    public double LM;
    public double LN;
    public JSONObject aEB;
    public int aEC;
    public float aED;
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
        this.aEB = jSONObject.optJSONObject("style");
        if (this.aEB != null) {
            try {
                this.backgroundColor = Color.parseColor(this.aEB.optString("bgColor"));
            } catch (Exception e) {
                c.e("SwanAppNativeViewModel", "bgColor occurs exception", e);
                this.backgroundColor = 0;
            }
            this.aEC = this.aEB.optInt("borderRadius");
            this.borderWidth = this.aEB.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.aEB.optString("borderColor"));
            } catch (Exception e2) {
                c.e("SwanAppNativeViewModel", "borderColor occurs exception", e2);
                this.borderColor = 0;
            }
            JSONArray optJSONArray = this.aEB.optJSONArray("padding");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                this.LJ = optJSONArray.optDouble(3, 0.0d);
                this.LK = optJSONArray.optDouble(0, 0.0d);
                this.LM = optJSONArray.optDouble(1, 0.0d);
                this.LN = optJSONArray.optDouble(2, 0.0d);
            }
            this.aED = o.a(this.aEB, "opacity", -1.0f);
        }
    }

    public void a(M m, com.baidu.swan.apps.view.container.c.a aVar) {
        if (m != null && aVar != null) {
            if (!TextUtils.equals(this.id, m.id)) {
                aVar.fG(63);
                return;
            }
            if (this.aXr != null && !this.aXr.equals(m.aXr)) {
                aVar.fG(1);
            }
            if (m.hidden != this.hidden) {
                aVar.fG(8);
            }
            if (m.aEB != null) {
                if (this.aEB == null || !TextUtils.equals(this.aEB.toString(), m.aEB.toString())) {
                    aVar.fG(2);
                }
            }
        }
    }
}
