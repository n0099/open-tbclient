package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class aj extends a {
    private float cHX;
    private float cHY;
    private float cHZ;
    private float cIa;
    private int cIb;
    private int mE;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.cHX = (float) jSONArray.optDouble(0);
                this.cHY = (float) jSONArray.optDouble(1);
                this.cHZ = (float) jSONArray.optDouble(2);
                this.cIa = (float) jSONArray.optDouble(3);
                this.mE = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(4));
                this.cIb = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akq() == 0) {
            bVar.gl(canvas.save());
        } else {
            canvas.restoreToCount(bVar.akq());
            bVar.gl(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.cHX, this.cHZ, this.mE, this.cHY, this.cIa, this.cIb, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
