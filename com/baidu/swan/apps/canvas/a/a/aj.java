package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aj extends a {
    private float ams;
    private float amt;
    private float amu;
    private float amv;
    private int amw;
    private int amx;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.ams = (float) jSONArray.optDouble(0);
                this.amt = (float) jSONArray.optDouble(1);
                this.amu = (float) jSONArray.optDouble(2);
                this.amv = (float) jSONArray.optDouble(3);
                this.amw = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(4));
                this.amx = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.xq() == 0) {
            bVar.bQ(canvas.save());
        } else {
            canvas.restoreToCount(bVar.xq());
            bVar.bQ(canvas.save());
        }
        if (this.ams > 0.0f && this.amv > 0.0f) {
            canvas.scale(this.ams, this.amv);
        }
        canvas.skew(this.amu, this.amt);
        canvas.translate(this.amw, this.amx);
    }
}
