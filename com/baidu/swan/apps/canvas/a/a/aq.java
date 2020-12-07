package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class aq extends a {
    private int cHC;
    private int cHD;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cHC = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(0));
            this.cHD = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.amZ() == 0) {
            bVar.hY(canvas.save());
        }
        canvas.translate(this.cHC, this.cHD);
    }
}
