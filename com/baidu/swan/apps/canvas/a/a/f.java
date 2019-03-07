package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class f extends a {
    private Rect mRect;
    private Paint mPaint = new Paint();
    private PorterDuffXfermode alw = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int ad = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
                int ad2 = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.mRect = new Rect(ad, ad2, com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2)) + ad, com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(3)) + ad2);
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
            this.mPaint.setXfermode(this.alw);
            canvas.drawRect(this.mRect, this.mPaint);
        }
    }
}
