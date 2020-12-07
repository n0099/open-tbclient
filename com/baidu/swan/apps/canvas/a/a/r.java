package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class r extends a {
    private float cHI;
    private float cHJ;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.cHI = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(0));
            this.cHJ = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(1));
            this.mX = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(2));
            this.mY = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(3));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.quadTo(this.cHI, this.cHJ, this.mX, this.mY);
        }
    }
}
