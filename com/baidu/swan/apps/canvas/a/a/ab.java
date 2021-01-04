package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class ab extends a {
    private DashPathEffect cMF;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        JSONArray optJSONArray;
        int length;
        float[] fArr = null;
        if (jSONArray.length() > 0 && (optJSONArray = jSONArray.optJSONArray(0)) != null && (length = optJSONArray.length()) > 0) {
            fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = com.baidu.swan.apps.ao.ah.O((float) optJSONArray.optDouble(i));
            }
        }
        int O = jSONArray.length() > 1 ? com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1)) : 0;
        if (fArr != null && O >= 0) {
            this.cMF = new DashPathEffect(fArr, O);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cMF != null) {
            bVar.mStrokePaint.setPathEffect(this.cMF);
        }
    }
}
