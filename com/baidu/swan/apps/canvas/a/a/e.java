package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class e extends a {
    private float bFj;
    private float bFk;
    private float bFl;
    private float bFm;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.bFj = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(0));
            this.bFk = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(1));
            this.bFl = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(2));
            this.bFm = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.bFj, this.bFk, this.bFl, this.bFm, this.mX, this.mY);
        }
    }
}
