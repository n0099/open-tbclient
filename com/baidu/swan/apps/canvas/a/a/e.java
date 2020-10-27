package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class e extends a {
    private float cwn;
    private float cwo;
    private float cwp;
    private float cwq;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.cwn = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(0));
            this.cwo = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(1));
            this.cwp = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(2));
            this.cwq = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.cwn, this.cwo, this.cwp, this.cwq, this.mX, this.mY);
        }
    }
}
