package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class ab extends a {
    private DashPathEffect cCD;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        JSONArray optJSONArray;
        int length;
        float[] fArr = null;
        if (jSONArray.length() > 0 && (optJSONArray = jSONArray.optJSONArray(0)) != null && (length = optJSONArray.length()) > 0) {
            fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = com.baidu.swan.apps.ap.ah.N((float) optJSONArray.optDouble(i));
            }
        }
        int N = jSONArray.length() > 1 ? com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(1)) : 0;
        if (fArr != null && N >= 0) {
            this.cCD = new DashPathEffect(fArr, N);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cCD != null) {
            bVar.mStrokePaint.setPathEffect(this.cCD);
        }
    }
}
