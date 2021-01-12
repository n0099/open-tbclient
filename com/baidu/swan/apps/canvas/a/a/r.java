package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class r extends a {
    private float cHL;
    private float cHM;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.cHL = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
            this.cHM = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
            this.mX = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(2));
            this.mY = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(3));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.quadTo(this.cHL, this.cHM, this.mX, this.mY);
        }
    }
}
