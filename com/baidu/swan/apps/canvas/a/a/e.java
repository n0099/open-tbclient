package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class e extends a {
    private float cMf;
    private float cMg;
    private float cMh;
    private float cMi;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.cMf = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
            this.cMg = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
            this.cMh = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(2));
            this.cMi = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.cMf, this.cMg, this.cMh, this.cMi, this.mX, this.mY);
        }
    }
}
