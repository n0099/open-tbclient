package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aq extends a {
    private int aGl;
    private int aGm;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.aGl = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(0));
            this.aGm = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.CS() == 0) {
            bVar.cN(canvas.save());
        }
        canvas.translate(this.aGl, this.aGm);
    }
}
