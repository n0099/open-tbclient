package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class x extends a {
    private i cLI;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cLI = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cLI != null && this.cLI.isValid()) {
            if (this.cLI.akS()) {
                bVar.mFillPaint.setShader(this.cLI.getShader());
                return;
            }
            bVar.cLc.setColor(this.cLI.getColor());
            bVar.mFillPaint.setColor(this.cLI.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
