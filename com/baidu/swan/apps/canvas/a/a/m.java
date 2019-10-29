package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class m extends a {
    private Rect mRect;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int S = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(0));
                int S2 = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
                this.mRect = new Rect(S, S2, com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(2)) + S, com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(3)) + S2);
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
            int alpha = bVar.mFillPaint.getAlpha();
            bVar.a(bVar.mFillPaint);
            canvas.drawRect(this.mRect, bVar.mFillPaint);
            bVar.mFillPaint.setAlpha(alpha);
        }
    }
}
