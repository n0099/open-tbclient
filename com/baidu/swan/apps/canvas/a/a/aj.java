package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class aj extends a {
    private float bUi;
    private float bUj;
    private float bUk;
    private float bUl;
    private int bUm;
    private int bUn;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bUi = (float) jSONArray.optDouble(0);
                this.bUj = (float) jSONArray.optDouble(1);
                this.bUk = (float) jSONArray.optDouble(2);
                this.bUl = (float) jSONArray.optDouble(3);
                this.bUm = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(4));
                this.bUn = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.WF() == 0) {
            bVar.eF(canvas.save());
        } else {
            canvas.restoreToCount(bVar.WF());
            bVar.eF(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.bUi, this.bUk, this.bUm, this.bUj, this.bUl, this.bUn, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
