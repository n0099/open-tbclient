package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {
    private float aFM;
    private float aFN;
    private float aFO;
    private float aFP;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.aFM = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(0));
            this.aFN = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
            this.aFO = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(2));
            this.aFP = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.aFM, this.aFN, this.aFO, this.aFP, this.mX, this.mY);
        }
    }
}
