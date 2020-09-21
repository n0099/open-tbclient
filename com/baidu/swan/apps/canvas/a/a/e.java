package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class e extends a {
    private float cbu;
    private float cbv;
    private float cbw;
    private float cbx;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.cbu = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(0));
            this.cbv = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(1));
            this.cbw = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(2));
            this.cbx = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.cbu, this.cbv, this.cbw, this.cbx, this.mX, this.mY);
        }
    }
}
