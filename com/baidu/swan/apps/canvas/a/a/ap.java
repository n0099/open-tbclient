package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class ap extends a {
    private float bFF;
    private float bFG;
    private float bFH;
    private float bFI;
    private int bFJ;
    private int bFK;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bFF = (float) jSONArray.optDouble(0);
                this.bFG = (float) jSONArray.optDouble(1);
                this.bFH = (float) jSONArray.optDouble(2);
                this.bFI = (float) jSONArray.optDouble(3);
                this.bFJ = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(4));
                this.bFK = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.Sh() == 0) {
            bVar.eh(canvas.save());
        }
        if (this.bFF > 0.0f && this.bFI > 0.0f) {
            canvas.scale(this.bFF, this.bFI);
        }
        canvas.skew(this.bFH, this.bFG);
        canvas.translate(this.bFJ, this.bFK);
    }
}
