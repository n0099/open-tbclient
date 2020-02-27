package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class c extends a {
    private RectF bgA;
    private float bgB;
    private float bgC;
    private boolean bgD;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int S = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(0));
            int S2 = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(1));
            int S3 = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bgA = new RectF(S - S3, S2 - S3, S + S3, S2 + S3);
            this.bgB = degrees;
            this.bgC = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bgD = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bgA != null) {
            if (!this.bgD && Math.abs(this.bgC) >= 360.0f) {
                bVar.mPath.addCircle((this.bgA.right + this.bgA.left) / 2.0f, (this.bgA.bottom + this.bgA.top) / 2.0f, (this.bgA.bottom - this.bgA.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bgA, 0.0f, this.bgB);
                return;
            }
            float f = this.bgC % 360.0f;
            if (f < 0.0f && !this.bgD) {
                f += 360.0f;
            } else if (f > 0.0f && this.bgD) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bgA, this.bgB, f);
        }
    }
}
