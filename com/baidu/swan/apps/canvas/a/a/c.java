package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class c extends a {
    private RectF bgB;
    private float bgC;
    private float bgD;
    private boolean bgE;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int S = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(0));
            int S2 = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(1));
            int S3 = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bgB = new RectF(S - S3, S2 - S3, S + S3, S2 + S3);
            this.bgC = degrees;
            this.bgD = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bgE = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bgB != null) {
            if (!this.bgE && Math.abs(this.bgD) >= 360.0f) {
                bVar.mPath.addCircle((this.bgB.right + this.bgB.left) / 2.0f, (this.bgB.bottom + this.bgB.top) / 2.0f, (this.bgB.bottom - this.bgB.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bgB, 0.0f, this.bgC);
                return;
            }
            float f = this.bgD % 360.0f;
            if (f < 0.0f && !this.bgE) {
                f += 360.0f;
            } else if (f > 0.0f && this.bgE) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bgB, this.bgC, f);
        }
    }
}
