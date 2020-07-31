package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class c extends a {
    private RectF bTD;
    private float bTE;
    private float bTF;
    private boolean bTG;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int D = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(0));
            int D2 = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(1));
            int D3 = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.bTD = new RectF(D - D3, D2 - D3, D + D3, D2 + D3);
            this.bTE = degrees;
            this.bTF = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5) {
            this.bTG = jSONArray.optBoolean(5);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bTD != null) {
            if (!this.bTG && Math.abs(this.bTF) >= 360.0f) {
                bVar.mPath.addCircle((this.bTD.right + this.bTD.left) / 2.0f, (this.bTD.bottom + this.bTD.top) / 2.0f, (this.bTD.bottom - this.bTD.top) / 2.0f, Path.Direction.CW);
                bVar.mPath.arcTo(this.bTD, 0.0f, this.bTE);
                return;
            }
            float f = this.bTF % 360.0f;
            if (f < 0.0f && !this.bTG) {
                f += 360.0f;
            } else if (f > 0.0f && this.bTG) {
                f -= 360.0f;
            }
            bVar.mPath.arcTo(this.bTD, this.bTE, f);
        }
    }
}
