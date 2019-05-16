package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {
    private float alK;
    private float alL;
    private float alM;
    private float alN;
    private float mX;
    private float mY;
    private boolean tW = false;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.alK = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
            this.alL = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
            this.alM = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
            this.alN = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(5));
            this.tW = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.tW) {
            bVar.mPath.cubicTo(this.alK, this.alL, this.alM, this.alN, this.mX, this.mY);
        }
    }
}
