package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class c extends a {
    private RectF cMb;
    private float cMc;
    private float cMd;
    private boolean cMe;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int O = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
            int O2 = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
            int O3 = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.cMb = new RectF(O - O3, O2 - O3, O + O3, O2 + O3);
            this.cMc = degrees;
            this.cMd = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.cMe = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cMb != null) {
            if (!this.cMe && Math.abs(this.cMd) >= 360.0f) {
                bVar.mPath.addCircle((this.cMb.right + this.cMb.left) / 2.0f, (this.cMb.bottom + this.cMb.top) / 2.0f, (this.cMb.bottom - this.cMb.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.cMb, 0.0f, this.cMc);
                return;
            }
            float f = this.cMd % 360.0f;
            if (f < 0.0f && !this.cMe) {
                f += 360.0f;
            } else if (f > 0.0f && this.cMe) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.cMb, this.cMc, f);
        }
    }
}
