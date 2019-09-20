package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aj extends a {
    private float ant;
    private float anu;
    private float anv;
    private float anw;
    private int anx;
    private int any;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.ant = (float) jSONArray.optDouble(0);
                this.anu = (float) jSONArray.optDouble(1);
                this.anv = (float) jSONArray.optDouble(2);
                this.anw = (float) jSONArray.optDouble(3);
                this.anx = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(4));
                this.any = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.xX() == 0) {
            bVar.bR(canvas.save());
        } else {
            canvas.restoreToCount(bVar.xX());
            bVar.bR(canvas.save());
        }
        if (this.ant > 0.0f && this.anw > 0.0f) {
            canvas.scale(this.ant, this.anw);
        }
        canvas.skew(this.anv, this.anu);
        canvas.translate(this.anx, this.any);
    }
}
