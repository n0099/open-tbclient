package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class c extends a {
    private RectF bcl;
    private float bcm;
    private float bcn;
    private boolean bco;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int S = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(0));
            int S2 = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(1));
            int S3 = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bcl = new RectF(S - S3, S2 - S3, S + S3, S2 + S3);
            this.bcm = degrees;
            this.bcn = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bco = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bcl != null) {
            if (!this.bco && Math.abs(this.bcn) >= 360.0f) {
                bVar.mPath.addCircle((this.bcl.right + this.bcl.left) / 2.0f, (this.bcl.bottom + this.bcl.top) / 2.0f, (this.bcl.bottom - this.bcl.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bcl, 0.0f, this.bcm);
                return;
            }
            float f = this.bcn % 360.0f;
            if (f < 0.0f && !this.bco) {
                f += 360.0f;
            } else if (f > 0.0f && this.bco) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bcl, this.bcm, f);
        }
    }
}
