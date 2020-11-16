package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class e extends a {
    private float cAw;
    private float cAx;
    private float cAy;
    private float cAz;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.cAw = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(0));
            this.cAx = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(1));
            this.cAy = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(2));
            this.cAz = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.cAw, this.cAx, this.cAy, this.cAz, this.mX, this.mY);
        }
    }
}
