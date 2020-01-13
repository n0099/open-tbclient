package com.baidu.swan.apps.z.a.a;

import android.support.v4.view.ViewCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    public c bvB;
    public int color = 0;
    public int bwa = ViewCompat.MEASURED_STATE_MASK;
    public int radius = -1;
    public float strokeWidth = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            this.bvB = new c();
            this.bvB.parseFromJson(jSONObject);
            if (this.bvB.isValid()) {
                this.color = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("color"), 0);
                this.bwa = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("fillColor"), ViewCompat.MEASURED_STATE_MASK);
                this.radius = jSONObject.optInt("radius", -1);
                this.strokeWidth = Math.abs(com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.bvB == null || !this.bvB.isValid() || this.radius == -1) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("coordinate ->").append(this.bvB).append("color ->").append(this.color).append("fillColor ->").append(this.bwa).append("radius ->").append(this.radius).append("strokeWidth ->").append(this.strokeWidth);
        return sb.toString();
    }
}
