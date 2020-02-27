package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class ap extends a {
    private float bhf;
    private float bhg;
    private float bhh;
    private float bhi;
    private int bhj;
    private int bhk;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bhf = (float) jSONArray.optDouble(0);
                this.bhg = (float) jSONArray.optDouble(1);
                this.bhh = (float) jSONArray.optDouble(2);
                this.bhi = (float) jSONArray.optDouble(3);
                this.bhj = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(4));
                this.bhk = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.Ko() == 0) {
            bVar.ec(canvas.save());
        }
        if (this.bhf > 0.0f && this.bhi > 0.0f) {
            canvas.scale(this.bhf, this.bhi);
        }
        canvas.skew(this.bhh, this.bhg);
        canvas.translate(this.bhj, this.bhk);
    }
}
