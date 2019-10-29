package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends a {
    private float aGe;
    private float aGf;
    private float aGg;
    private float aGh;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.aGe = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(0));
            this.aGf = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
            this.aGg = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(2));
            this.aGh = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.aGe, this.aGf, this.aGg, this.aGh, this.mX, this.mY);
        }
    }
}
