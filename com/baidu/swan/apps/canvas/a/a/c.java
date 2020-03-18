package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class c extends a {
    private RectF bgP;
    private float bgQ;
    private float bgR;
    private boolean bgS;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int S = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(0));
            int S2 = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(1));
            int S3 = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bgP = new RectF(S - S3, S2 - S3, S + S3, S2 + S3);
            this.bgQ = degrees;
            this.bgR = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bgS = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bgP != null) {
            if (!this.bgS && Math.abs(this.bgR) >= 360.0f) {
                bVar.mPath.addCircle((this.bgP.right + this.bgP.left) / 2.0f, (this.bgP.bottom + this.bgP.top) / 2.0f, (this.bgP.bottom - this.bgP.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bgP, 0.0f, this.bgQ);
                return;
            }
            float f = this.bgR % 360.0f;
            if (f < 0.0f && !this.bgS) {
                f += 360.0f;
            } else if (f > 0.0f && this.bgS) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bgP, this.bgQ, f);
        }
    }
}
