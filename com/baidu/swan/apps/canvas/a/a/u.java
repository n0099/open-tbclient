package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class u extends a {
    private float ani;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.ani = (float) jSONArray.optDouble(0);
            this.ani = (float) Math.toDegrees(this.ani);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.xX() == 0) {
            bVar.bR(canvas.save());
        }
        canvas.rotate(this.ani);
    }
}
