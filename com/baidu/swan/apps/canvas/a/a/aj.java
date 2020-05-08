package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class aj extends a {
    private float bFK;
    private float bFL;
    private float bFM;
    private float bFN;
    private int bFO;
    private int bFP;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bFK = (float) jSONArray.optDouble(0);
                this.bFL = (float) jSONArray.optDouble(1);
                this.bFM = (float) jSONArray.optDouble(2);
                this.bFN = (float) jSONArray.optDouble(3);
                this.bFO = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(4));
                this.bFP = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.Sg() == 0) {
            bVar.eh(canvas.save());
        } else {
            canvas.restoreToCount(bVar.Sg());
            bVar.eh(canvas.save());
        }
        if (this.bFK > 0.0f && this.bFN > 0.0f) {
            canvas.scale(this.bFK, this.bFN);
        }
        canvas.skew(this.bFM, this.bFL);
        canvas.translate(this.bFO, this.bFP);
    }
}
