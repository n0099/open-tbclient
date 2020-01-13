package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class aj extends a {
    private float bcQ;
    private float bcR;
    private float bcS;
    private float bcT;
    private int bcU;
    private int bcV;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bcQ = (float) jSONArray.optDouble(0);
                this.bcR = (float) jSONArray.optDouble(1);
                this.bcS = (float) jSONArray.optDouble(2);
                this.bcT = (float) jSONArray.optDouble(3);
                this.bcU = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(4));
                this.bcV = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.HZ() == 0) {
            bVar.dM(canvas.save());
        } else {
            canvas.restoreToCount(bVar.HZ());
            bVar.dM(canvas.save());
        }
        if (this.bcQ > 0.0f && this.bcT > 0.0f) {
            canvas.scale(this.bcQ, this.bcT);
        }
        canvas.skew(this.bcS, this.bcR);
        canvas.translate(this.bcU, this.bcV);
    }
}
