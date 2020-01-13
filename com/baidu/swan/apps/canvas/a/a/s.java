package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class s extends a {
    private RectF UY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int S = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(0));
                int S2 = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(1));
                this.UY = new RectF(S, S2, S + com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(2)), S2 + com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.UY != null) {
            bVar.mPath.addRect(this.UY, Path.Direction.CW);
        }
    }
}
