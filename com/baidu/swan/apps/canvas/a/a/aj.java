package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aj extends a {
    private float aGK;
    private float aGL;
    private float aGM;
    private float aGN;
    private int aGO;
    private int aGP;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.aGK = (float) jSONArray.optDouble(0);
                this.aGL = (float) jSONArray.optDouble(1);
                this.aGM = (float) jSONArray.optDouble(2);
                this.aGN = (float) jSONArray.optDouble(3);
                this.aGO = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(4));
                this.aGP = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.CS() == 0) {
            bVar.cN(canvas.save());
        } else {
            canvas.restoreToCount(bVar.CS());
            bVar.cN(canvas.save());
        }
        if (this.aGK > 0.0f && this.aGN > 0.0f) {
            canvas.scale(this.aGK, this.aGN);
        }
        canvas.skew(this.aGM, this.aGL);
        canvas.translate(this.aGO, this.aGP);
    }
}
