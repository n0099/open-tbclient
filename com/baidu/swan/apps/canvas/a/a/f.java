package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class f extends a {
    private Rect mRect;
    private Paint mPaint = new Paint();
    private PorterDuffXfermode cwr = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int L = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(0));
                int L2 = com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(1));
                this.mRect = new Rect(L, L2, com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(2)) + L, com.baidu.swan.apps.ap.ah.L((float) jSONArray.optDouble(3)) + L2);
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
            this.mPaint.setXfermode(this.cwr);
            canvas.drawRect(this.mRect, this.mPaint);
        }
    }
}
