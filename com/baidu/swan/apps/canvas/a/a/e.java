package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class e extends a {
    private float cHo;
    private float cHp;
    private float cHq;
    private float cHr;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.cHo = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(0));
            this.cHp = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(1));
            this.cHq = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(2));
            this.cHr = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.cHo, this.cHp, this.cHq, this.cHr, this.mX, this.mY);
        }
    }
}
