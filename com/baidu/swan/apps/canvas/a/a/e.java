package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class e extends a {
    private float cLn;
    private float cLo;
    private float cLp;
    private float cLq;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.cLn = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(0));
            this.cLo = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(1));
            this.cLp = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(2));
            this.cLq = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.cLn, this.cLo, this.cLp, this.cLq, this.mX, this.mY);
        }
    }
}
