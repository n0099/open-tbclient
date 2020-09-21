package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class c extends a {
    private RectF cbq;
    private float cbr;
    private float cbs;
    private boolean cbt;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int H = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(0));
            int H2 = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(1));
            int H3 = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.cbq = new RectF(H - H3, H2 - H3, H + H3, H2 + H3);
            this.cbr = degrees;
            this.cbs = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.cbt = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cbq != null) {
            if (!this.cbt && Math.abs(this.cbs) >= 360.0f) {
                bVar.mPath.addCircle((this.cbq.right + this.cbq.left) / 2.0f, (this.cbq.bottom + this.cbq.top) / 2.0f, (this.cbq.bottom - this.cbq.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.cbq, 0.0f, this.cbr);
                return;
            }
            float f = this.cbs % 360.0f;
            if (f < 0.0f && !this.cbt) {
                f += 360.0f;
            } else if (f > 0.0f && this.cbt) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.cbq, this.cbr, f);
        }
    }
}
