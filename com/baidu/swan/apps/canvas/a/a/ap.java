package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class ap extends a {
    private float bZQ;
    private float bZR;
    private float bZS;
    private float bZT;
    private int bZU;
    private int bZV;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bZQ = (float) jSONArray.optDouble(0);
                this.bZR = (float) jSONArray.optDouble(1);
                this.bZS = (float) jSONArray.optDouble(2);
                this.bZT = (float) jSONArray.optDouble(3);
                this.bZU = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(4));
                this.bZV = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.acL() == 0) {
            bVar.gD(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.bZQ, this.bZS, this.bZU, this.bZR, this.bZT, this.bZV, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
