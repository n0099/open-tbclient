package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class e extends a {
    private float cHt;
    private float cHu;
    private float cHv;
    private float cHw;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.cHt = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
            this.cHu = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
            this.cHv = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(2));
            this.cHw = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.cHt, this.cHu, this.cHv, this.cHw, this.mX, this.mY);
        }
    }
}
