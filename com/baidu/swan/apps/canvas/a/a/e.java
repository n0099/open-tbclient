package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {
    private float amn;
    private float amo;
    private float amp;
    private float amq;
    private float mX;
    private float mY;
    private boolean tY = false;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.amn = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
            this.amo = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
            this.amp = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
            this.amq = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(5));
            this.tY = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.tY) {
            bVar.mPath.cubicTo(this.amn, this.amo, this.amp, this.amq, this.mX, this.mY);
        }
    }
}
