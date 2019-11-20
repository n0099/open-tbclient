package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {
    private RectF aFI;
    private float aFJ;
    private float aFK;
    private boolean aFL;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int S = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(0));
            int S2 = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
            int S3 = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.aFI = new RectF(S - S3, S2 - S3, S + S3, S2 + S3);
            this.aFJ = degrees;
            this.aFK = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.aFL = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aFI != null) {
            if (!this.aFL && Math.abs(this.aFK) >= 360.0f) {
                bVar.mPath.addCircle((this.aFI.right + this.aFI.left) / 2.0f, (this.aFI.bottom + this.aFI.top) / 2.0f, (this.aFI.bottom - this.aFI.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.aFI, 0.0f, this.aFJ);
                return;
            }
            float f = this.aFK % 360.0f;
            if (f < 0.0f && !this.aFL) {
                f += 360.0f;
            } else if (f > 0.0f && this.aFL) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.aFI, this.aFJ, f);
        }
    }
}
