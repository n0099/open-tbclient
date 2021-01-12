package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class c extends a {
    private RectF cHp;
    private float cHq;
    private float cHr;
    private boolean cHs;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int O = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
            int O2 = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
            int O3 = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.cHp = new RectF(O - O3, O2 - O3, O + O3, O2 + O3);
            this.cHq = degrees;
            this.cHr = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.cHs = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cHp != null) {
            if (!this.cHs && Math.abs(this.cHr) >= 360.0f) {
                bVar.mPath.addCircle((this.cHp.right + this.cHp.left) / 2.0f, (this.cHp.bottom + this.cHp.top) / 2.0f, (this.cHp.bottom - this.cHp.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.cHp, 0.0f, this.cHq);
                return;
            }
            float f = this.cHr % 360.0f;
            if (f < 0.0f && !this.cHs) {
                f += 360.0f;
            } else if (f > 0.0f && this.cHs) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.cHp, this.cHq, f);
        }
    }
}
