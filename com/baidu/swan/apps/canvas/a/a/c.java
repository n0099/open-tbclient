package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {
    private RectF aGa;
    private float aGb;
    private float aGc;
    private boolean aGd;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int S = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(0));
            int S2 = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
            int S3 = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.aGa = new RectF(S - S3, S2 - S3, S + S3, S2 + S3);
            this.aGb = degrees;
            this.aGc = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.aGd = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aGa != null) {
            if (!this.aGd && Math.abs(this.aGc) >= 360.0f) {
                bVar.mPath.addCircle((this.aGa.right + this.aGa.left) / 2.0f, (this.aGa.bottom + this.aGa.top) / 2.0f, (this.aGa.bottom - this.aGa.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.aGa, 0.0f, this.aGb);
                return;
            }
            float f = this.aGc % 360.0f;
            if (f < 0.0f && !this.aGd) {
                f += 360.0f;
            } else if (f > 0.0f && this.aGd) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.aGa, this.aGb, f);
        }
    }
}
