package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class aj extends a {
    private float cHT;
    private float cHU;
    private float cHV;
    private float cHW;
    private int cHX;
    private int mE;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.cHT = (float) jSONArray.optDouble(0);
                this.cHU = (float) jSONArray.optDouble(1);
                this.cHV = (float) jSONArray.optDouble(2);
                this.cHW = (float) jSONArray.optDouble(3);
                this.mE = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(4));
                this.cHX = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.amZ() == 0) {
            bVar.hY(canvas.save());
        } else {
            canvas.restoreToCount(bVar.amZ());
            bVar.hY(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.cHT, this.cHV, this.mE, this.cHU, this.cHW, this.cHX, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
