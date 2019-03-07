package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aj extends a {
    private float ama;
    private float amb;
    private float amc;
    private float amd;
    private int ame;
    private int amf;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.ama = (float) jSONArray.optDouble(0);
                this.amb = (float) jSONArray.optDouble(1);
                this.amc = (float) jSONArray.optDouble(2);
                this.amd = (float) jSONArray.optDouble(3);
                this.ame = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(4));
                this.amf = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.wz() == 0) {
            bVar.bR(canvas.save());
        } else {
            canvas.restoreToCount(bVar.wz());
            bVar.bR(canvas.save());
        }
        if (this.ama > 0.0f && this.amd > 0.0f) {
            canvas.scale(this.ama, this.amd);
        }
        canvas.skew(this.amc, this.amb);
        canvas.translate(this.ame, this.amf);
    }
}
