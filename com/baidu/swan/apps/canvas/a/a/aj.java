package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class aj extends a {
    private float cCH;
    private float cCI;
    private float cCJ;
    private float cCK;
    private int cCL;
    private int cCM;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.cCH = (float) jSONArray.optDouble(0);
                this.cCI = (float) jSONArray.optDouble(1);
                this.cCJ = (float) jSONArray.optDouble(2);
                this.cCK = (float) jSONArray.optDouble(3);
                this.cCL = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(4));
                this.cCM = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akz() == 0) {
            bVar.hE(canvas.save());
        } else {
            canvas.restoreToCount(bVar.akz());
            bVar.hE(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.cCH, this.cCJ, this.cCL, this.cCI, this.cCK, this.cCM, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
