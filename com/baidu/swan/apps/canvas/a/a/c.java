package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class c extends a {
    private RectF cHk;
    private float cHl;
    private float cHm;
    private boolean cHn;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int M = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(0));
            int M2 = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(1));
            int M3 = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.cHk = new RectF(M - M3, M2 - M3, M + M3, M2 + M3);
            this.cHl = degrees;
            this.cHm = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.cHn = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cHk != null) {
            if (!this.cHn && Math.abs(this.cHm) >= 360.0f) {
                bVar.mPath.addCircle((this.cHk.right + this.cHk.left) / 2.0f, (this.cHk.bottom + this.cHk.top) / 2.0f, (this.cHk.bottom - this.cHk.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.cHk, 0.0f, this.cHl);
                return;
            }
            float f = this.cHm % 360.0f;
            if (f < 0.0f && !this.cHn) {
                f += 360.0f;
            } else if (f > 0.0f && this.cHn) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.cHk, this.cHl, f);
        }
    }
}
