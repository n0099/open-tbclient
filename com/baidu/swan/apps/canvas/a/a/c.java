package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {
    private RectF alp;
    private float alq;
    private float alr;
    private boolean als;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int ad = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
            int ad2 = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
            int ad3 = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.alp = new RectF(ad - ad3, ad2 - ad3, ad + ad3, ad2 + ad3);
            this.alq = degrees;
            this.alr = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.als = jSONArray.optBoolean(5);
            if (this.als) {
                this.alr = -Math.abs(this.alr);
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alp != null) {
            if (Math.abs(this.alr) < 360.0f) {
                bVar.mPath.arcTo(this.alp, this.alq, this.alr);
                return;
            }
            float f = this.alr % 360.0f;
            bVar.mPath.addCircle((this.alp.right + this.alp.left) / 2.0f, (this.alp.bottom + this.alp.top) / 2.0f, (this.alp.bottom - this.alp.top) / 2.0f, this.als ? Path.Direction.CCW : Path.Direction.CW);
            if (f != 0.0f) {
                bVar.mPath.arcTo(this.alp, this.alq, f, true);
            }
        }
    }
}
