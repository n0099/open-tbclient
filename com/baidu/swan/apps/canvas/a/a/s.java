package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class s extends a {
    private RectF mRect;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int ad = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
                int ad2 = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.mRect = new RectF(ad, ad2, ad + com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2)), ad2 + com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
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
