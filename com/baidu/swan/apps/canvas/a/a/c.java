package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {
    private RectF alt;
    private float alu;
    private float alv;
    private boolean alw;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int ad = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
            int ad2 = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
            int ad3 = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.alt = new RectF(ad - ad3, ad2 - ad3, ad + ad3, ad2 + ad3);
            this.alu = degrees;
            this.alv = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.alw = jSONArray.optBoolean(5);
            if (this.alw) {
                this.alv = -Math.abs(this.alv);
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alt != null) {
            if (Math.abs(this.alv) < 360.0f) {
                bVar.mPath.arcTo(this.alt, this.alu, this.alv);
                return;
            }
            float f = this.alv % 360.0f;
            bVar.mPath.addCircle((this.alt.right + this.alt.left) / 2.0f, (this.alt.bottom + this.alt.top) / 2.0f, (this.alt.bottom - this.alt.top) / 2.0f, this.alw ? Path.Direction.CCW : Path.Direction.CW);
            if (f != 0.0f) {
                bVar.mPath.arcTo(this.alt, this.alu, f, true);
            }
        }
    }
}
