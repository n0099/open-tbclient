package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class r extends a {
    private float alN;
    private float alO;
    private float mX;
    private float mY;
    private boolean wq = false;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.alN = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
            this.alO = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
            this.mX = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
            this.mY = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(3));
            this.wq = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.wq) {
            bVar.mPath.quadTo(this.alN, this.alO, this.mX, this.mY);
        }
    }
}
