package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class e extends a {
    private float bFe;
    private float bFf;
    private float bFg;
    private float bFh;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.bFe = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(0));
            this.bFf = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(1));
            this.bFg = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(2));
            this.bFh = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.bFe, this.bFf, this.bFg, this.bFh, this.mX, this.mY);
        }
    }
}
