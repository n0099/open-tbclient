package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {
    private RectF alo;
    private float alp;
    private float alq;
    private boolean alr;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int ad = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
            int ad2 = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
            int ad3 = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.alo = new RectF(ad - ad3, ad2 - ad3, ad + ad3, ad2 + ad3);
            this.alp = degrees;
            this.alq = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.alr = jSONArray.optBoolean(5);
            if (this.alr) {
                this.alq = -Math.abs(this.alq);
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alo != null) {
            if (Math.abs(this.alq) < 360.0f) {
                bVar.mPath.arcTo(this.alo, this.alp, this.alq);
                return;
            }
            float f = this.alq % 360.0f;
            bVar.mPath.addCircle((this.alo.right + this.alo.left) / 2.0f, (this.alo.bottom + this.alo.top) / 2.0f, (this.alo.bottom - this.alo.top) / 2.0f, this.alr ? Path.Direction.CCW : Path.Direction.CW);
            if (f != 0.0f) {
                bVar.mPath.arcTo(this.alo, this.alp, f, true);
            }
        }
    }
}
