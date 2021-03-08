package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class aj extends a {
    private float cLP;
    private float cLQ;
    private float cLR;
    private float cLS;
    private int cLT;
    private int mE;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.cLP = (float) jSONArray.optDouble(0);
                this.cLQ = (float) jSONArray.optDouble(1);
                this.cLR = (float) jSONArray.optDouble(2);
                this.cLS = (float) jSONArray.optDouble(3);
                this.mE = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(4));
                this.cLT = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akR() == 0) {
            bVar.gq(canvas.save());
        } else {
            canvas.restoreToCount(bVar.akR());
            bVar.gq(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.cLP, this.cLR, this.mE, this.cLQ, this.cLS, this.cLT, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
