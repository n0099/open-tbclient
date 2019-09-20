package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {
    private RectF amH;
    private float amI;
    private float amJ;
    private boolean amK;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int ad = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
            int ad2 = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
            int ad3 = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.amH = new RectF(ad - ad3, ad2 - ad3, ad + ad3, ad2 + ad3);
            this.amI = degrees;
            this.amJ = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.amK = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amH != null) {
            if (!this.amK && Math.abs(this.amJ) >= 360.0f) {
                bVar.mPath.addCircle((this.amH.right + this.amH.left) / 2.0f, (this.amH.bottom + this.amH.top) / 2.0f, (this.amH.bottom - this.amH.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.amH, 0.0f, this.amI);
                return;
            }
            float f = this.amJ % 360.0f;
            if (f < 0.0f && !this.amK) {
                f += 360.0f;
            } else if (f > 0.0f && this.amK) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.amH, this.amI, f);
        }
    }
}
