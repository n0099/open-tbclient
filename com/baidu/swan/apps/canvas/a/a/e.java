package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class e extends a {
    private float bgE;
    private float bgF;
    private float bgG;
    private float bgH;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.bgE = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(0));
            this.bgF = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(1));
            this.bgG = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(2));
            this.bgH = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.bgE, this.bgF, this.bgG, this.bgH, this.mX, this.mY);
        }
    }
}
