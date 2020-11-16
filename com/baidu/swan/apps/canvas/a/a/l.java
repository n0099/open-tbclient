package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class l extends a {
    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        int alpha = bVar.mFillPaint.getAlpha();
        bVar.a(bVar.mFillPaint);
        canvas.drawPath(bVar.mPath, bVar.mFillPaint);
        bVar.mFillPaint.setAlpha(alpha);
    }
}
