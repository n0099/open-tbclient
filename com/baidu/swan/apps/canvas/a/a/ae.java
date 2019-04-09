package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ae extends a {
    private int ame = -1;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.ame = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.ame >= 0) {
            bVar.mStrokePaint.setStrokeMiter(this.ame);
        }
    }
}
