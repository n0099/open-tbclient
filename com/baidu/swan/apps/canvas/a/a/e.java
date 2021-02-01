package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class e extends a {
    private float cJN;
    private float cJO;
    private float cJP;
    private float cJQ;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.cJN = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(0));
            this.cJO = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(1));
            this.cJP = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(2));
            this.cJQ = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.cJN, this.cJO, this.cJP, this.cJQ, this.mX, this.mY);
        }
    }
}
