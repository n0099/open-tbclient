package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class e extends a {
    private float bOb;
    private float bOc;
    private float bOd;
    private float bOe;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.bOb = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(0));
            this.bOc = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(1));
            this.bOd = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(2));
            this.bOe = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.bOb, this.bOc, this.bOd, this.bOe, this.mX, this.mY);
        }
    }
}
