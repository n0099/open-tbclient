package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class e extends a {
    private float bTH;
    private float bTI;
    private float bTJ;
    private float bTK;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.bTH = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(0));
            this.bTI = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(1));
            this.bTJ = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(2));
            this.bTK = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.bTH, this.bTI, this.bTJ, this.bTK, this.mX, this.mY);
        }
    }
}
