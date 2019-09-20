package com.baidu.swan.apps.x.a.a;

import android.support.v4.view.ViewCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    public c aAP;
    public int color = 0;
    public int aBj = ViewCompat.MEASURED_STATE_MASK;
    public int radius = -1;
    public float aBk = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            this.aAP = new c();
            this.aAP.parseFromJson(jSONObject);
            if (this.aAP.isValid()) {
                this.color = com.baidu.swan.apps.x.a.d.B(jSONObject.optString("color"), 0);
                this.aBj = com.baidu.swan.apps.x.a.d.B(jSONObject.optString("fillColor"), ViewCompat.MEASURED_STATE_MASK);
                this.radius = jSONObject.optInt("radius", -1);
                this.aBk = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.aAP == null || !this.aAP.isValid() || this.radius == -1) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("coordinate ->").append(this.aAP).append("color ->").append(this.color).append("fillColor ->").append(this.aBj).append("radius ->").append(this.radius).append("strokeWidth ->").append(this.aBk);
        return sb.toString();
    }
}
