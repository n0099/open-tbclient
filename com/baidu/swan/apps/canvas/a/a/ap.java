package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class ap extends a {
    private float bTq;
    private float bTr;
    private float bTs;
    private float bTt;
    private int bTu;
    private int bTv;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bTq = (float) jSONArray.optDouble(0);
                this.bTr = (float) jSONArray.optDouble(1);
                this.bTs = (float) jSONArray.optDouble(2);
                this.bTt = (float) jSONArray.optDouble(3);
                this.bTu = com.baidu.swan.apps.aq.ag.D((float) jSONArray.optDouble(4));
                this.bTv = com.baidu.swan.apps.aq.ag.D((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.VY() == 0) {
            bVar.eD(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.bTq, this.bTs, this.bTu, this.bTr, this.bTt, this.bTv, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
