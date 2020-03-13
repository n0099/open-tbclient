package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class ap extends a {
    private float bhh;
    private float bhi;
    private float bhj;
    private float bhk;
    private int bhl;
    private int bhm;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bhh = (float) jSONArray.optDouble(0);
                this.bhi = (float) jSONArray.optDouble(1);
                this.bhj = (float) jSONArray.optDouble(2);
                this.bhk = (float) jSONArray.optDouble(3);
                this.bhl = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(4));
                this.bhm = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(5));
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
        if (this.bhh > 0.0f && this.bhk > 0.0f) {
            canvas.scale(this.bhh, this.bhk);
        }
        canvas.skew(this.bhj, this.bhi);
        canvas.translate(this.bhl, this.bhm);
    }
}
