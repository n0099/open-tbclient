package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class c extends a {
    private RectF bFf;
    private float bFg;
    private float bFh;
    private boolean bFi;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int C = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(0));
            int C2 = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(1));
            int C3 = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bFf = new RectF(C - C3, C2 - C3, C + C3, C2 + C3);
            this.bFg = degrees;
            this.bFh = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bFi = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bFf != null) {
            if (!this.bFi && Math.abs(this.bFh) >= 360.0f) {
                bVar.mPath.addCircle((this.bFf.right + this.bFf.left) / 2.0f, (this.bFf.bottom + this.bFf.top) / 2.0f, (this.bFf.bottom - this.bFf.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bFf, 0.0f, this.bFg);
                return;
            }
            float f = this.bFh % 360.0f;
            if (f < 0.0f && !this.bFi) {
                f += 360.0f;
            } else if (f > 0.0f && this.bFi) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bFf, this.bFg, f);
        }
    }
}
