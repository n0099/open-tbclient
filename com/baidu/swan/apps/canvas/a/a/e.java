package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {
    private float amL;
    private float amM;
    private float amN;
    private float amO;
    private float mX;
    private float mY;
    private boolean tY = false;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.amL = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
            this.amM = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
            this.amN = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
            this.amO = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(5));
            this.tY = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.tY) {
            bVar.mPath.cubicTo(this.amL, this.amM, this.amN, this.amO, this.mX, this.mY);
        }
    }
}
