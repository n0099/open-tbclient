package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class e extends a {
    private float bgT;
    private float bgU;
    private float bgV;
    private float bgW;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.bgT = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(0));
            this.bgU = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(1));
            this.bgV = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(2));
            this.bgW = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.bgT, this.bgU, this.bgV, this.bgW, this.mX, this.mY);
        }
    }
}
