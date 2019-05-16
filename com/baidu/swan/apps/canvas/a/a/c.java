package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {
    private RectF alG;
    private float alH;
    private float alI;
    private boolean alJ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int ad = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
            int ad2 = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
            int ad3 = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.alG = new RectF(ad - ad3, ad2 - ad3, ad + ad3, ad2 + ad3);
            this.alH = degrees;
            this.alI = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.alJ = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alG != null) {
            if (!this.alJ && Math.abs(this.alI) >= 360.0f) {
                bVar.mPath.addCircle((this.alG.right + this.alG.left) / 2.0f, (this.alG.bottom + this.alG.top) / 2.0f, (this.alG.bottom - this.alG.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.alG, 0.0f, this.alH);
                return;
            }
            float f = this.alI % 360.0f;
            if (f < 0.0f && !this.alJ) {
                f += 360.0f;
            } else if (f > 0.0f && this.alJ) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.alG, this.alH, f);
        }
    }
}
