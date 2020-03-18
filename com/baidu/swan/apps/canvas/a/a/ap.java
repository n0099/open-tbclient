package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class ap extends a {
    private float bhu;
    private float bhv;
    private float bhw;
    private float bhx;
    private int bhy;
    private int bhz;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bhu = (float) jSONArray.optDouble(0);
                this.bhv = (float) jSONArray.optDouble(1);
                this.bhw = (float) jSONArray.optDouble(2);
                this.bhx = (float) jSONArray.optDouble(3);
                this.bhy = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(4));
                this.bhz = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.Kt() == 0) {
            bVar.ec(canvas.save());
        }
        if (this.bhu > 0.0f && this.bhx > 0.0f) {
            canvas.scale(this.bhu, this.bhx);
        }
        canvas.skew(this.bhw, this.bhv);
        canvas.translate(this.bhy, this.bhz);
    }
}
