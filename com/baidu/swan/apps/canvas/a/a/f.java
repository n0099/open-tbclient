package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class f extends a {
    private Rect mRect;
    private Paint mPaint = new Paint();
    private PorterDuffXfermode bZt = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

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
            this.mPaint.setXfermode(this.bZt);
            canvas.drawRect(this.mRect, this.mPaint);
        }
    }
}
