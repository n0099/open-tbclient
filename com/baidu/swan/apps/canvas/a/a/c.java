package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class c extends a {
    private RectF cCc;
    private float cCd;
    private float cCe;
    private boolean cCf;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int N = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(0));
            int N2 = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(1));
            int N3 = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.cCc = new RectF(N - N3, N2 - N3, N + N3, N2 + N3);
            this.cCd = degrees;
            this.cCe = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.cCf = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cCc != null) {
            if (!this.cCf && Math.abs(this.cCe) >= 360.0f) {
                bVar.mPath.addCircle((this.cCc.right + this.cCc.left) / 2.0f, (this.cCc.bottom + this.cCc.top) / 2.0f, (this.cCc.bottom - this.cCc.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.cCc, 0.0f, this.cCd);
                return;
            }
            float f = this.cCe % 360.0f;
            if (f < 0.0f && !this.cCf) {
                f += 360.0f;
            } else if (f > 0.0f && this.cCf) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.cCc, this.cCd, f);
        }
    }
}
