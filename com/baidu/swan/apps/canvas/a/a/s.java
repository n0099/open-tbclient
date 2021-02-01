package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class s extends a {
    private RectF mRect;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int P = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(0));
                int P2 = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(1));
                this.mRect = new RectF(P, P2, P + com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(2)), P2 + com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mRect != null) {
            bVar.mPath.addRect(this.mRect, Path.Direction.CW);
        }
    }
}
