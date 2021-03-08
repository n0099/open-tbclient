package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class c extends a {
    private RectF cLj;
    private float cLk;
    private float cLl;
    private boolean cLm;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int T = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(0));
            int T2 = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(1));
            int T3 = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.cLj = new RectF(T - T3, T2 - T3, T + T3, T2 + T3);
            this.cLk = degrees;
            this.cLl = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.cLm = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cLj != null) {
            if (!this.cLm && Math.abs(this.cLl) >= 360.0f) {
                bVar.mPath.addCircle((this.cLj.right + this.cLj.left) / 2.0f, (this.cLj.bottom + this.cLj.top) / 2.0f, (this.cLj.bottom - this.cLj.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.cLj, 0.0f, this.cLk);
                return;
            }
            float f = this.cLl % 360.0f;
            if (f < 0.0f && !this.cLm) {
                f += 360.0f;
            } else if (f > 0.0f && this.cLm) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.cLj, this.cLk, f);
        }
    }
}
