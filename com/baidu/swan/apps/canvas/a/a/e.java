package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {
    private float alt;
    private float alu;
    private float alv;
    private float alw;
    private float mX;
    private float mY;
    private boolean wq = false;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.alt = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
            this.alu = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
            this.alv = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
            this.alw = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(5));
            this.wq = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.wq) {
            bVar.mPath.cubicTo(this.alt, this.alu, this.alv, this.alw, this.mX, this.mY);
        }
    }
}
