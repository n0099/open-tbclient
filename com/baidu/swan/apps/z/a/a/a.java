package com.baidu.swan.apps.z.a.a;

import android.support.v4.view.ViewCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    public c bYj;
    public int color = 0;
    public int bYI = ViewCompat.MEASURED_STATE_MASK;
    public int radius = -1;
    public float strokeWidth = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            this.bYj = new c();
            this.bYj.parseFromJson(jSONObject);
            if (this.bYj.isValid()) {
                this.color = com.baidu.swan.apps.z.a.d.J(jSONObject.optString("color"), 0);
                this.bYI = com.baidu.swan.apps.z.a.d.J(jSONObject.optString("fillColor"), ViewCompat.MEASURED_STATE_MASK);
                this.radius = jSONObject.optInt("radius", -1);
                this.strokeWidth = Math.abs(com.baidu.swan.apps.z.a.d.k(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.bYj == null || !this.bYj.isValid() || this.radius == -1) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("coordinate ->").append(this.bYj).append("color ->").append(this.color).append("fillColor ->").append(this.bYI).append("radius ->").append(this.radius).append("strokeWidth ->").append(this.strokeWidth);
        return sb.toString();
    }
}
