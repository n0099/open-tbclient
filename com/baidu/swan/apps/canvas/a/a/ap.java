package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class ap extends a {
    private float cwO;
    private float cwP;
    private float cwQ;
    private float cwR;
    private int cwS;
    private int cwT;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.cwO = (float) jSONArray.optDouble(0);
                this.cwP = (float) jSONArray.optDouble(1);
                this.cwQ = (float) jSONArray.optDouble(2);
                this.cwR = (float) jSONArray.optDouble(3);
                this.cwS = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(4));
                this.cwT = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.ahZ() == 0) {
            bVar.hu(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.cwO, this.cwQ, this.cwS, this.cwP, this.cwR, this.cwT, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
