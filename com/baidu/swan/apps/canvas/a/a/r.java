package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class r extends a {
    private float cMx;
    private float cMy;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.cMx = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
            this.cMy = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
            this.mX = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(2));
            this.mY = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(3));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.quadTo(this.cMx, this.cMy, this.mX, this.mY);
        }
    }
}
