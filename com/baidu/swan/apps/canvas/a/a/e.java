package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class e extends a {
    private float bSP;
    private float bSQ;
    private float bSR;
    private float bSS;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.bSP = com.baidu.swan.apps.aq.ag.D((float) jSONArray.optDouble(0));
            this.bSQ = com.baidu.swan.apps.aq.ag.D((float) jSONArray.optDouble(1));
            this.bSR = com.baidu.swan.apps.aq.ag.D((float) jSONArray.optDouble(2));
            this.bSS = com.baidu.swan.apps.aq.ag.D((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.aq.ag.D((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.aq.ag.D((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.bSP, this.bSQ, this.bSR, this.bSS, this.mX, this.mY);
        }
    }
}
