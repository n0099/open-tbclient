package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class ab extends a {
    private DashPathEffect cLL;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        JSONArray optJSONArray;
        int length;
        float[] fArr = null;
        if (jSONArray.length() > 0 && (optJSONArray = jSONArray.optJSONArray(0)) != null && (length = optJSONArray.length()) > 0) {
            fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = com.baidu.swan.apps.ao.ah.T((float) optJSONArray.optDouble(i));
            }
        }
        int T = jSONArray.length() > 1 ? com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(1)) : 0;
        if (fArr != null && T >= 0) {
            this.cLL = new DashPathEffect(fArr, T);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cLL != null) {
            bVar.mStrokePaint.setPathEffect(this.cLL);
        }
    }
}
