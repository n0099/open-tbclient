package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aj extends a {
    private float amV;
    private float amW;
    private float amX;
    private float amY;
    private int amZ;
    private int ana;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.amV = (float) jSONArray.optDouble(0);
                this.amW = (float) jSONArray.optDouble(1);
                this.amX = (float) jSONArray.optDouble(2);
                this.amY = (float) jSONArray.optDouble(3);
                this.amZ = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(4));
                this.ana = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.xT() == 0) {
            bVar.bQ(canvas.save());
        } else {
            canvas.restoreToCount(bVar.xT());
            bVar.bQ(canvas.save());
        }
        if (this.amV > 0.0f && this.amY > 0.0f) {
            canvas.scale(this.amV, this.amY);
        }
        canvas.skew(this.amX, this.amW);
        canvas.translate(this.amZ, this.ana);
    }
}
