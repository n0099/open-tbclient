package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class c extends a {
    private RectF cAs;
    private float cAt;
    private float cAu;
    private boolean cAv;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int M = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(0));
            int M2 = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(1));
            int M3 = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.cAs = new RectF(M - M3, M2 - M3, M + M3, M2 + M3);
            this.cAt = degrees;
            this.cAu = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.cAv = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cAs != null) {
            if (!this.cAv && Math.abs(this.cAu) >= 360.0f) {
                bVar.mPath.addCircle((this.cAs.right + this.cAs.left) / 2.0f, (this.cAs.bottom + this.cAs.top) / 2.0f, (this.cAs.bottom - this.cAs.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.cAs, 0.0f, this.cAt);
                return;
            }
            float f = this.cAu % 360.0f;
            if (f < 0.0f && !this.cAv) {
                f += 360.0f;
            } else if (f > 0.0f && this.cAv) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.cAs, this.cAt, f);
        }
    }
}
