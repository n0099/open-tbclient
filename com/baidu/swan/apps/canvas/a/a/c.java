package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class c extends a {
    private RectF bFa;
    private float bFb;
    private float bFc;
    private boolean bFd;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int C = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(0));
            int C2 = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(1));
            int C3 = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bFa = new RectF(C - C3, C2 - C3, C + C3, C2 + C3);
            this.bFb = degrees;
            this.bFc = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bFd = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bFa != null) {
            if (!this.bFd && Math.abs(this.bFc) >= 360.0f) {
                bVar.mPath.addCircle((this.bFa.right + this.bFa.left) / 2.0f, (this.bFa.bottom + this.bFa.top) / 2.0f, (this.bFa.bottom - this.bFa.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bFa, 0.0f, this.bFb);
                return;
            }
            float f = this.bFc % 360.0f;
            if (f < 0.0f && !this.bFd) {
                f += 360.0f;
            } else if (f > 0.0f && this.bFd) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bFa, this.bFb, f);
        }
    }
}
