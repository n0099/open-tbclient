package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class r extends a {
    private float amf;
    private float amg;
    private float mX;
    private float mY;
    private boolean tV = false;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.amf = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
            this.amg = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
            this.mX = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
            this.mY = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(3));
            this.tV = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.tV) {
            bVar.mPath.quadTo(this.amf, this.amg, this.mX, this.mY);
        }
    }
}
