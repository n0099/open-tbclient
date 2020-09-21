package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class ap extends a {
    private float cbV;
    private float cbW;
    private float cbX;
    private float cbY;
    private int cbZ;
    private int cca;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.cbV = (float) jSONArray.optDouble(0);
                this.cbW = (float) jSONArray.optDouble(1);
                this.cbX = (float) jSONArray.optDouble(2);
                this.cbY = (float) jSONArray.optDouble(3);
                this.cbZ = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(4));
                this.cca = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.adu() == 0) {
            bVar.gM(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.cbV, this.cbX, this.cbZ, this.cbW, this.cbY, this.cca, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }
}
