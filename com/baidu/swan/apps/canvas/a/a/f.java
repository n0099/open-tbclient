package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class f extends a {
    private Rect mRect;
    private Paint mPaint = new Paint();
    private PorterDuffXfermode bFn = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int C = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(0));
                int C2 = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(1));
                this.mRect = new Rect(C, C2, com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(2)) + C, com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(3)) + C2);
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
            this.mPaint.setXfermode(this.bFn);
            canvas.drawRect(this.mRect, this.mPaint);
        }
    }
}
