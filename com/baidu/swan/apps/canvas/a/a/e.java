package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class e extends a {
    private float bgG;
    private float bgH;
    private float bgI;
    private float bgJ;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.bgG = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(0));
            this.bgH = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(1));
            this.bgI = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(2));
            this.bgJ = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.bgG, this.bgH, this.bgI, this.bgJ, this.mX, this.mY);
        }
    }
}
