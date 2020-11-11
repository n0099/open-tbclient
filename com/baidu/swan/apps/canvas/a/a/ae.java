package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class ae extends a {
    private int cCF = -1;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cCF = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(0));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cCF >= 0) {
            bVar.mStrokePaint.setStrokeMiter(this.cCF);
        }
    }
}
