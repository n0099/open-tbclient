package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class c extends a {
    private RectF bZp;
    private float bZq;
    private float bZr;
    private boolean bZs;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int H = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(0));
            int H2 = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(1));
            int H3 = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bZp = new RectF(H - H3, H2 - H3, H + H3, H2 + H3);
            this.bZq = degrees;
            this.bZr = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bZs = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bZp != null) {
            if (!this.bZs && Math.abs(this.bZr) >= 360.0f) {
                bVar.mPath.addCircle((this.bZp.right + this.bZp.left) / 2.0f, (this.bZp.bottom + this.bZp.top) / 2.0f, (this.bZp.bottom - this.bZp.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bZp, 0.0f, this.bZq);
                return;
            }
            float f = this.bZr % 360.0f;
            if (f < 0.0f && !this.bZs) {
                f += 360.0f;
            } else if (f > 0.0f && this.bZs) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bZp, this.bZq, f);
        }
    }
}
