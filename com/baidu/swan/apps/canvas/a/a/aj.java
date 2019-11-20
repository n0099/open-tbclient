package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aj extends a {
    private float aGs;
    private float aGt;
    private float aGu;
    private float aGv;
    private int aGw;
    private int aGx;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.aGs = (float) jSONArray.optDouble(0);
                this.aGt = (float) jSONArray.optDouble(1);
                this.aGu = (float) jSONArray.optDouble(2);
                this.aGv = (float) jSONArray.optDouble(3);
                this.aGw = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(4));
                this.aGx = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.CT() == 0) {
            bVar.cN(canvas.save());
        } else {
            canvas.restoreToCount(bVar.CT());
            bVar.cN(canvas.save());
        }
        if (this.aGs > 0.0f && this.aGv > 0.0f) {
            canvas.scale(this.aGs, this.aGv);
        }
        canvas.skew(this.aGu, this.aGt);
        canvas.translate(this.aGw, this.aGx);
    }
}
