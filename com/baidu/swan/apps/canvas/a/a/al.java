package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class al extends a {
    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        int alpha = bVar.mStrokePaint.getAlpha();
        bVar.b(bVar.mStrokePaint);
        canvas.drawPath(bVar.mPath, bVar.mStrokePaint);
        bVar.mStrokePaint.setAlpha(alpha);
    }
}
