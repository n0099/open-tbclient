package com.baidu.swan.apps.button.b;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.button.b.a;
import com.baidu.swan.apps.console.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a<M extends a> extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = b.DEBUG;
    public double adZ;
    public double aea;
    public double aeb;
    public double aec;
    public JSONObject akk;
    public int akl;
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
        this.akk = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        if (this.akk != null) {
            try {
                this.backgroundColor = Color.parseColor(this.akk.optString("bgColor"));
            } catch (Exception e) {
                c.e("SwanAppNativeViewModel", "bgColor occurs exception", e);
                this.backgroundColor = 0;
            }
            this.akl = this.akk.optInt("borderRadius");
            this.borderWidth = this.akk.optInt("borderWidth");
            try {
                this.borderColor = Color.parseColor(this.akk.optString("borderColor"));
            } catch (Exception e2) {
                c.e("SwanAppNativeViewModel", "borderColor occurs exception", e2);
                this.borderColor = 0;
            }
            JSONArray optJSONArray = this.akk.optJSONArray("padding");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                this.adZ = optJSONArray.optDouble(3, 0.0d);
                this.aea = optJSONArray.optDouble(0, 0.0d);
                this.aeb = optJSONArray.optDouble(1, 0.0d);
                this.aec = optJSONArray.optDouble(2, 0.0d);
            }
            this.alpha = n.a(this.akk, "opacity", -1.0f);
        }
    }

    public void a(M m, com.baidu.swan.apps.view.container.c.a aVar) {
        if (m != null && aVar != null) {
            if (!TextUtils.equals(this.id, m.id)) {
                aVar.ew(63);
                return;
            }
            if (this.aBI != null && !this.aBI.equals(m.aBI)) {
                aVar.ew(1);
            }
            if (m.hidden != this.hidden) {
                aVar.ew(8);
            }
            if (m.akk != null) {
                if (this.akk == null || !TextUtils.equals(this.akk.toString(), m.akk.toString())) {
                    aVar.ew(2);
                }
            }
        }
    }
}
