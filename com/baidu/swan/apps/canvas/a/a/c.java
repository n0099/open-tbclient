package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class c extends a {
    private RectF bNX;
    private float bNY;
    private float bNZ;
    private boolean bOa;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int B = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(0));
            int B2 = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(1));
            int B3 = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bNX = new RectF(B - B3, B2 - B3, B + B3, B2 + B3);
            this.bNY = degrees;
            this.bNZ = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bOa = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bNX != null) {
            if (!this.bOa && Math.abs(this.bNZ) >= 360.0f) {
                bVar.mPath.addCircle((this.bNX.right + this.bNX.left) / 2.0f, (this.bNX.bottom + this.bNX.top) / 2.0f, (this.bNX.bottom - this.bNX.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bNX, 0.0f, this.bNY);
                return;
            }
            float f = this.bNZ % 360.0f;
            if (f < 0.0f && !this.bOa) {
                f += 360.0f;
            } else if (f > 0.0f && this.bOa) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bNX, this.bNY, f);
        }
    }
}
