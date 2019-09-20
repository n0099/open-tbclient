package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ad extends a {
    private int anq = -1;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.anq = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.anq >= 0) {
            bVar.mStrokePaint.setStrokeWidth(this.anq);
        }
    }
}
