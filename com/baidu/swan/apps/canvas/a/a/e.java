package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {
    private float alA;
    private float alx;
    private float aly;
    private float alz;
    private float mX;
    private float mY;
    private boolean wq = false;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.alx = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
            this.aly = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
            this.alz = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
            this.alA = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(5));
            this.wq = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.wq) {
            bVar.mPath.cubicTo(this.alx, this.aly, this.alz, this.alA, this.mX, this.mY);
        }
    }
}
