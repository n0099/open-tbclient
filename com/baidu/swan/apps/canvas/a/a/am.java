package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class am extends a {
    private Path mPath;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int B = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(0));
                int B2 = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(1));
                int B3 = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(2));
                int B4 = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(3));
                this.mPath = new Path();
                this.mPath.addRect(new RectF(B, B2, B + B3, B2 + B4), Path.Direction.CW);
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mPath != null) {
            int alpha = bVar.mStrokePaint.getAlpha();
            bVar.a(bVar.mStrokePaint);
            canvas.drawPath(this.mPath, bVar.mStrokePaint);
            bVar.mStrokePaint.setAlpha(alpha);
        }
    }
}
