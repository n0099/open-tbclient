package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class s extends a {
    private RectF atR;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int B = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(0));
                int B2 = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(1));
                this.atR = new RectF(B, B2, B + com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(2)), B2 + com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.atR != null) {
            bVar.mPath.addRect(this.atR, Path.Direction.CW);
        }
    }
}
