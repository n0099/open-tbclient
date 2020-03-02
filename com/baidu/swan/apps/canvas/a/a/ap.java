package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class ap extends a {
    private float bhg;
    private float bhh;
    private float bhi;
    private float bhj;
    private int bhk;
    private int bhl;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bhg = (float) jSONArray.optDouble(0);
                this.bhh = (float) jSONArray.optDouble(1);
                this.bhi = (float) jSONArray.optDouble(2);
                this.bhj = (float) jSONArray.optDouble(3);
                this.bhk = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(4));
                this.bhl = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.Kq() == 0) {
            bVar.ec(canvas.save());
        }
        if (this.bhg > 0.0f && this.bhj > 0.0f) {
            canvas.scale(this.bhg, this.bhj);
        }
        canvas.skew(this.bhi, this.bhh);
        canvas.translate(this.bhk, this.bhl);
    }
}
