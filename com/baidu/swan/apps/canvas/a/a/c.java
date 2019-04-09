package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {
    private RectF alu;
    private float alv;
    private float alw;
    private boolean alx;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int ad = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
            int ad2 = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
            int ad3 = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.alu = new RectF(ad - ad3, ad2 - ad3, ad + ad3, ad2 + ad3);
            this.alv = degrees;
            this.alw = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.alx = jSONArray.optBoolean(5);
            if (this.alx) {
                this.alw = -Math.abs(this.alw);
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alu != null) {
            if (Math.abs(this.alw) < 360.0f) {
                bVar.mPath.arcTo(this.alu, this.alv, this.alw);
                return;
            }
            float f = this.alw % 360.0f;
            bVar.mPath.addCircle((this.alu.right + this.alu.left) / 2.0f, (this.alu.bottom + this.alu.top) / 2.0f, (this.alu.bottom - this.alu.top) / 2.0f, this.alx ? Path.Direction.CCW : Path.Direction.CW);
            if (f != 0.0f) {
                bVar.mPath.arcTo(this.alu, this.alv, f, true);
            }
        }
    }
}
