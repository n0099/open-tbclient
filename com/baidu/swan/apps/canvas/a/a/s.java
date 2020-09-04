package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class s extends a {
    private RectF aCc;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int H = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(0));
                int H2 = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(1));
                this.aCc = new RectF(H, H2, H + com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(2)), H2 + com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aCc != null) {
            bVar.mPath.addRect(this.aCc, Path.Direction.CW);
        }
    }
}
