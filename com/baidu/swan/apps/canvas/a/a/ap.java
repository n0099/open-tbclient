package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class ap extends a {
    private float bOC;
    private float bOD;
    private float bOE;
    private float bOF;
    private int bOG;
    private int bOH;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bOC = (float) jSONArray.optDouble(0);
                this.bOD = (float) jSONArray.optDouble(1);
                this.bOE = (float) jSONArray.optDouble(2);
                this.bOF = (float) jSONArray.optDouble(3);
                this.bOG = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(4));
                this.bOH = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.US() == 0) {
            bVar.es(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.bOC, this.bOE, this.bOG, this.bOD, this.bOF, this.bOH, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
