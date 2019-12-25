package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class c extends a {
    private RectF bbt;
    private float bbu;
    private float bbv;
    private boolean bbw;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int T = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(0));
            int T2 = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(1));
            int T3 = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bbt = new RectF(T - T3, T2 - T3, T + T3, T2 + T3);
            this.bbu = degrees;
            this.bbv = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bbw = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bbt != null) {
            if (!this.bbw && Math.abs(this.bbv) >= 360.0f) {
                bVar.mPath.addCircle((this.bbt.right + this.bbt.left) / 2.0f, (this.bbt.bottom + this.bbt.top) / 2.0f, (this.bbt.bottom - this.bbt.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bbt, 0.0f, this.bbu);
                return;
            }
            float f = this.bbv % 360.0f;
            if (f < 0.0f && !this.bbw) {
                f += 360.0f;
            } else if (f > 0.0f && this.bbw) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bbt, this.bbu, f);
        }
    }
}
