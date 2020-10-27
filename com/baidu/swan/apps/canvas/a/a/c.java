package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class c extends a {
    private RectF cwj;
    private float cwk;
    private float cwl;
    private boolean cwm;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int L = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(0));
            int L2 = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(1));
            int L3 = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.cwj = new RectF(L - L3, L2 - L3, L + L3, L2 + L3);
            this.cwk = degrees;
            this.cwl = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.cwm = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cwj != null) {
            if (!this.cwm && Math.abs(this.cwl) >= 360.0f) {
                bVar.mPath.addCircle((this.cwj.right + this.cwj.left) / 2.0f, (this.cwj.bottom + this.cwj.top) / 2.0f, (this.cwj.bottom - this.cwj.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.cwj, 0.0f, this.cwk);
                return;
            }
            float f = this.cwl % 360.0f;
            if (f < 0.0f && !this.cwm) {
                f += 360.0f;
            } else if (f > 0.0f && this.cwm) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.cwj, this.cwk, f);
        }
    }
}
