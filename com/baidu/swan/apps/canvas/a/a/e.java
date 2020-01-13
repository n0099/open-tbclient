package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class e extends a {
    private float bcp;
    private float bcq;
    private float bcr;
    private float bcs;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.bcp = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(0));
            this.bcq = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(1));
            this.bcr = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(2));
            this.bcs = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.bcp, this.bcq, this.bcr, this.bcs, this.mX, this.mY);
        }
    }
}
