package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class e extends a {
    private float bZt;
    private float bZu;
    private float bZv;
    private float bZw;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.bZt = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(0));
            this.bZu = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(1));
            this.bZv = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(2));
            this.bZw = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.bZt, this.bZu, this.bZv, this.bZw, this.mX, this.mY);
        }
    }
}
