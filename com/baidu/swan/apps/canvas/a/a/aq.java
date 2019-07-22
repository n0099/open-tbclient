package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aq extends a {
    private int amu;
    private int amv;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.amu = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
            this.amv = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.xT() == 0) {
            bVar.bQ(canvas.save());
        }
        canvas.translate(this.amu, this.amv);
    }
}
