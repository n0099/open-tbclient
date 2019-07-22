package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ab extends a {
    private DashPathEffect amQ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        JSONArray optJSONArray;
        int length;
        float[] fArr = null;
        if (jSONArray.length() > 0 && (optJSONArray = jSONArray.optJSONArray(0)) != null && (length = optJSONArray.length()) > 0) {
            fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = com.baidu.swan.apps.an.z.ad((float) optJSONArray.optDouble(i));
            }
        }
        int ad = jSONArray.length() > 1 ? com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1)) : 0;
        if (fArr != null && ad >= 0) {
            this.amQ = new DashPathEffect(fArr, ad);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amQ != null) {
            bVar.mStrokePaint.setPathEffect(this.amQ);
        }
    }
}
