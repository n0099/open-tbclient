package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class ap extends a {
    private float bca;
    private float bcb;
    private float bcc;
    private float bcd;
    private int bce;
    private int bcf;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.bca = (float) jSONArray.optDouble(0);
                this.bcb = (float) jSONArray.optDouble(1);
                this.bcc = (float) jSONArray.optDouble(2);
                this.bcd = (float) jSONArray.optDouble(3);
                this.bce = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(4));
                this.bcf = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.HD() == 0) {
            bVar.dL(canvas.save());
        }
        if (this.bca > 0.0f && this.bcd > 0.0f) {
            canvas.scale(this.bca, this.bcd);
        }
        canvas.skew(this.bcc, this.bcb);
        canvas.translate(this.bce, this.bcf);
    }
}
