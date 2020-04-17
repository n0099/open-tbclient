package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class r extends a {
    private float bFu;
    private float bFv;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.bFu = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(0));
            this.bFv = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(1));
            this.mX = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(2));
            this.mY = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(3));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.quadTo(this.bFu, this.bFv, this.mX, this.mY);
        }
    }
}
