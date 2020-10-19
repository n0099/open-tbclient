package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class e extends a {
    private float cnK;
    private float cnL;
    private float cnM;
    private float cnN;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.cnK = com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(0));
            this.cnL = com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(1));
            this.cnM = com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(2));
            this.cnN = com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(3));
            this.mX = com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(4));
            this.mY = com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mIsValid) {
            bVar.mPath.cubicTo(this.cnK, this.cnL, this.cnM, this.cnN, this.mX, this.mY);
        }
    }
}
