package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class ab extends a {
    private DashPathEffect cwK;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        JSONArray optJSONArray;
        int length;
        float[] fArr = null;
        if (jSONArray.length() > 0 && (optJSONArray = jSONArray.optJSONArray(0)) != null && (length = optJSONArray.length()) > 0) {
            fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = com.baidu.swan.apps.ap.ah.L((float) optJSONArray.optDouble(i));
            }
        }
        int L = jSONArray.length() > 1 ? com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(1)) : 0;
        if (fArr != null && L >= 0) {
            this.cwK = new DashPathEffect(fArr, L);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cwK != null) {
            bVar.mStrokePaint.setPathEffect(this.cwK);
        }
    }
}
