package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class c extends a {
    private RectF cnG;
    private float cnH;
    private float cnI;
    private boolean cnJ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int J = com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(0));
            int J2 = com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(1));
            int J3 = com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.cnG = new RectF(J - J3, J2 - J3, J + J3, J2 + J3);
            this.cnH = degrees;
            this.cnI = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.cnJ = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cnG != null) {
            if (!this.cnJ && Math.abs(this.cnI) >= 360.0f) {
                bVar.mPath.addCircle((this.cnG.right + this.cnG.left) / 2.0f, (this.cnG.bottom + this.cnG.top) / 2.0f, (this.cnG.bottom - this.cnG.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.cnG, 0.0f, this.cnH);
                return;
            }
            float f = this.cnI % 360.0f;
            if (f < 0.0f && !this.cnJ) {
                f += 360.0f;
            } else if (f > 0.0f && this.cnJ) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.cnG, this.cnH, f);
        }
    }
}
