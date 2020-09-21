package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class u extends a {
    private float mRotateAngle;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.mRotateAngle = (float) jSONArray.optDouble(0);
            this.mRotateAngle = (float) Math.toDegrees(this.mRotateAngle);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.adu() == 0) {
            bVar.gM(canvas.save());
        }
        canvas.rotate(this.mRotateAngle);
    }
}
