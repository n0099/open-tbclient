package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class ap extends a {
    private float cMJ;
    private float cMK;
    private float cML;
    private float cMM;
    private int cMN;
    private int mE;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.cMJ = (float) jSONArray.optDouble(0);
                this.cMK = (float) jSONArray.optDouble(1);
                this.cML = (float) jSONArray.optDouble(2);
                this.cMM = (float) jSONArray.optDouble(3);
                this.mE = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(4));
                this.cMN = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.aok() == 0) {
            bVar.hS(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.cMJ, this.cML, this.mE, this.cMK, this.cMM, this.cMN, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
