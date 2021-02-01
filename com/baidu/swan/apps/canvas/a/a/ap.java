package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class ap extends a {
    private float cKp;
    private float cKq;
    private float cKr;
    private float cKs;
    private int cKt;
    private int mE;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.cKp = (float) jSONArray.optDouble(0);
                this.cKq = (float) jSONArray.optDouble(1);
                this.cKr = (float) jSONArray.optDouble(2);
                this.cKs = (float) jSONArray.optDouble(3);
                this.mE = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(4));
                this.cKt = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akO() == 0) {
            bVar.gp(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.cKp, this.cKr, this.mE, this.cKq, this.cKs, this.cKt, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
