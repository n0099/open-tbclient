package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class aq extends a {
    private int mX;
    private int mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.mX = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(0));
            this.mY = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.US() == 0) {
            bVar.es(canvas.save());
        }
        canvas.translate(this.mX, this.mY);
    }
}
