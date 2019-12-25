package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class e extends a {
    private float bbA;
    private float bbx;
    private float bby;
    private float bbz;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.bbx = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(0));
            this.bby = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(1));
            this.bbz = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(2));
            this.bbA = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.bbx, this.bby, this.bbz, this.bbA, this.mX, this.mY);
        }
    }
}
