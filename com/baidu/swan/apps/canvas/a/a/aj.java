package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aj extends a {
    private float amb;
    private float amc;
    private float amd;
    private float ame;
    private int amf;
    private int amg;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.amb = (float) jSONArray.optDouble(0);
                this.amc = (float) jSONArray.optDouble(1);
                this.amd = (float) jSONArray.optDouble(2);
                this.ame = (float) jSONArray.optDouble(3);
                this.amf = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(4));
                this.amg = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
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
        if (this.amb > 0.0f && this.ame > 0.0f) {
            canvas.scale(this.amb, this.ame);
        }
        canvas.skew(this.amd, this.amc);
        canvas.translate(this.amf, this.amg);
    }
}
