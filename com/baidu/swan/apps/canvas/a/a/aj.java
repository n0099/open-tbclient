package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aj extends a {
    private float amf;
    private float amg;
    private float amh;
    private float ami;
    private int amj;
    private int amk;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.amf = (float) jSONArray.optDouble(0);
                this.amg = (float) jSONArray.optDouble(1);
                this.amh = (float) jSONArray.optDouble(2);
                this.ami = (float) jSONArray.optDouble(3);
                this.amj = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(4));
                this.amk = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.wy() == 0) {
            bVar.bQ(canvas.save());
        } else {
            canvas.restoreToCount(bVar.wy());
            bVar.bQ(canvas.save());
        }
        if (this.amf > 0.0f && this.ami > 0.0f) {
            canvas.scale(this.amf, this.ami);
        }
        canvas.skew(this.amh, this.amg);
        canvas.translate(this.amj, this.amk);
    }
}
