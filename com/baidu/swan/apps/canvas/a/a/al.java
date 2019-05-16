package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class al extends a {
    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        int alpha = bVar.mStrokePaint.getAlpha();
        bVar.a(bVar.mStrokePaint);
        canvas.drawPath(bVar.mPath, bVar.mStrokePaint);
        bVar.mStrokePaint.setAlpha(alpha);
    }
}
