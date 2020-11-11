package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class e extends a {
    private float cCg;
    private float cCh;
    private float cCi;
    private float cCj;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.cCg = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(0));
            this.cCh = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(1));
            this.cCi = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(2));
            this.cCj = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.cCg, this.cCh, this.cCi, this.cCj, this.mX, this.mY);
        }
    }
}
