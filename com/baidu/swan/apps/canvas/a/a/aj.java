package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class aj extends a {
    private float col;

    /* renamed from: com  reason: collision with root package name */
    private float f3669com;
    private float coo;
    private float cop;
    private int coq;
    private int cor;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.col = (float) jSONArray.optDouble(0);
                this.f3669com = (float) jSONArray.optDouble(1);
                this.coo = (float) jSONArray.optDouble(2);
                this.cop = (float) jSONArray.optDouble(3);
                this.coq = com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(4));
                this.cor = com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.agf() == 0) {
            bVar.hj(canvas.save());
        } else {
            canvas.restoreToCount(bVar.agf());
            bVar.hj(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.col, this.coo, this.coq, this.f3669com, this.cop, this.cor, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
