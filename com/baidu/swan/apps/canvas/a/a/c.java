package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class c extends a {
    private RectF bZl;
    private float bZm;
    private float bZn;
    private boolean bZo;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int H = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(0));
            int H2 = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(1));
            int H3 = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bZl = new RectF(H - H3, H2 - H3, H + H3, H2 + H3);
            this.bZm = degrees;
            this.bZn = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bZo = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bZl != null) {
            if (!this.bZo && Math.abs(this.bZn) >= 360.0f) {
                bVar.mPath.addCircle((this.bZl.right + this.bZl.left) / 2.0f, (this.bZl.bottom + this.bZl.top) / 2.0f, (this.bZl.bottom - this.bZl.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bZl, 0.0f, this.bZm);
                return;
            }
            float f = this.bZn % 360.0f;
            if (f < 0.0f && !this.bZo) {
                f += 360.0f;
            } else if (f > 0.0f && this.bZo) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bZl, this.bZm, f);
        }
    }
}
