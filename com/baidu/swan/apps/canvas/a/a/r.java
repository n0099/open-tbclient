package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class r extends a {
    private float cKd;
    private float cKe;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.cKd = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(0));
            this.cKe = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(1));
            this.mX = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(2));
            this.mY = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(3));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.quadTo(this.cKd, this.cKe, this.mX, this.mY);
        }
    }
}
