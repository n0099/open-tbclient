package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class w extends a {
    private float anj;
    private float ank;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.anj = (float) jSONArray.optDouble(0);
            this.ank = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.anj > 0.0f && this.ank > 0.0f) {
            if (bVar.xX() == 0) {
                bVar.bR(canvas.save());
            }
            canvas.scale(this.anj, this.ank);
        }
    }
}
