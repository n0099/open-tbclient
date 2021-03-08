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
    private PorterDuffXfermode cLr = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int T = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(0));
                int T2 = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(1));
                this.mRect = new Rect(T, T2, com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(2)) + T, com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(3)) + T2);
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
            this.mPaint.setXfermode(this.cLr);
            canvas.drawRect(this.mRect, this.mPaint);
        }
    }
}
