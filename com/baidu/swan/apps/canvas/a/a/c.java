package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {
    private RectF amj;
    private float amk;
    private float aml;
    private boolean amm;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int ad = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
            int ad2 = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
            int ad3 = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.amj = new RectF(ad - ad3, ad2 - ad3, ad + ad3, ad2 + ad3);
            this.amk = degrees;
            this.aml = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.amm = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amj != null) {
            if (!this.amm && Math.abs(this.aml) >= 360.0f) {
                bVar.mPath.addCircle((this.amj.right + this.amj.left) / 2.0f, (this.amj.bottom + this.amj.top) / 2.0f, (this.amj.bottom - this.amj.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.amj, 0.0f, this.amk);
                return;
            }
            float f = this.aml % 360.0f;
            if (f < 0.0f && !this.amm) {
                f += 360.0f;
            } else if (f > 0.0f && this.amm) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.amj, this.amk, f);
        }
    }
}
