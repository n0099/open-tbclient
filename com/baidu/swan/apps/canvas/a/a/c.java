package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class c extends a {
    private RectF cJJ;
    private float cJK;
    private float cJL;
    private boolean cJM;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int P = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(0));
            int P2 = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(1));
            int P3 = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.cJJ = new RectF(P - P3, P2 - P3, P + P3, P2 + P3);
            this.cJK = degrees;
            this.cJL = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.cJM = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cJJ != null) {
            if (!this.cJM && Math.abs(this.cJL) >= 360.0f) {
                bVar.mPath.addCircle((this.cJJ.right + this.cJJ.left) / 2.0f, (this.cJJ.bottom + this.cJJ.top) / 2.0f, (this.cJJ.bottom - this.cJJ.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.cJJ, 0.0f, this.cJK);
                return;
            }
            float f = this.cJL % 360.0f;
            if (f < 0.0f && !this.cJM) {
                f += 360.0f;
            } else if (f > 0.0f && this.cJM) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.cJJ, this.cJK, f);
        }
    }
}
