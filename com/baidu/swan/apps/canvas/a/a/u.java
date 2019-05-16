package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class u extends a {
    private float amh;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.amh = (float) jSONArray.optDouble(0);
            this.amh = (float) Math.toDegrees(this.amh);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.xq() == 0) {
            bVar.bQ(canvas.save());
        }
        canvas.rotate(this.amh);
    }
}
