package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class m extends a {
    private Rect mRect;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int H = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(0));
                int H2 = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(1));
                this.mRect = new Rect(H, H2, com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(2)) + H, com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(3)) + H2);
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
