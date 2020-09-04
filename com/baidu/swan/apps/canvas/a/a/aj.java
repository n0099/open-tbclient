package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class aj extends a {
    private float bZU;
    private float bZV;
    private float bZW;
    private float bZX;
    private int bZY;
    private int bZZ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bZU = (float) jSONArray.optDouble(0);
                this.bZV = (float) jSONArray.optDouble(1);
                this.bZW = (float) jSONArray.optDouble(2);
                this.bZX = (float) jSONArray.optDouble(3);
                this.bZY = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(4));
                this.bZZ = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(5));
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
        } else {
            canvas.restoreToCount(bVar.acL());
            bVar.gD(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.bZU, this.bZW, this.bZY, this.bZV, this.bZX, this.bZZ, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
