package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class aj extends a {
    private float cAX;
    private float cAY;
    private float cAZ;
    private float cBa;
    private int cBb;
    private int cBc;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.cAX = (float) jSONArray.optDouble(0);
                this.cAY = (float) jSONArray.optDouble(1);
                this.cAZ = (float) jSONArray.optDouble(2);
                this.cBa = (float) jSONArray.optDouble(3);
                this.cBb = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(4));
                this.cBc = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.ajR() == 0) {
            bVar.hA(canvas.save());
        } else {
            canvas.restoreToCount(bVar.ajR());
            bVar.hA(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.cAX, this.cAZ, this.cBb, this.cAY, this.cBa, this.cBc, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
