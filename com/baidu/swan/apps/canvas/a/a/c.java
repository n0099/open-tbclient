package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class c extends a {
    private RectF bSL;
    private float bSM;
    private float bSN;
    private boolean bSO;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int D = com.baidu.swan.apps.aq.ag.D((float) jSONArray.optDouble(0));
            int D2 = com.baidu.swan.apps.aq.ag.D((float) jSONArray.optDouble(1));
            int D3 = com.baidu.swan.apps.aq.ag.D((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bSL = new RectF(D - D3, D2 - D3, D + D3, D2 + D3);
            this.bSM = degrees;
            this.bSN = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bSO = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bSL != null) {
            if (!this.bSO && Math.abs(this.bSN) >= 360.0f) {
                bVar.mPath.addCircle((this.bSL.right + this.bSL.left) / 2.0f, (this.bSL.bottom + this.bSL.top) / 2.0f, (this.bSL.bottom - this.bSL.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bSL, 0.0f, this.bSM);
                return;
            }
            float f = this.bSN % 360.0f;
            if (f < 0.0f && !this.bSO) {
                f += 360.0f;
            } else if (f > 0.0f && this.bSO) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bSL, this.bSM, f);
        }
    }
}
