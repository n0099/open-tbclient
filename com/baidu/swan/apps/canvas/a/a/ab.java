package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ab extends a {
    private DashPathEffect aGo;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        JSONArray optJSONArray;
        int length;
        float[] fArr = null;
        if (jSONArray.length() > 0 && (optJSONArray = jSONArray.optJSONArray(0)) != null && (length = optJSONArray.length()) > 0) {
            fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = com.baidu.swan.apps.an.z.S((float) optJSONArray.optDouble(i));
            }
        }
        int S = jSONArray.length() > 1 ? com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1)) : 0;
        if (fArr != null && S >= 0) {
            this.aGo = new DashPathEffect(fArr, S);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aGo != null) {
            bVar.mStrokePaint.setPathEffect(this.aGo);
        }
    }
}
