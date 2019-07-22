package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class w extends a {
    private float amL;
    private float amM;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.amL = (float) jSONArray.optDouble(0);
            this.amM = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amL > 0.0f && this.amM > 0.0f) {
            if (bVar.xT() == 0) {
                bVar.bQ(canvas.save());
            }
            canvas.scale(this.amL, this.amM);
        }
    }
}
