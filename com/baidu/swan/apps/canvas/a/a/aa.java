package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aa extends a {
    private Paint.Cap alV;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "butt")) {
                this.alV = Paint.Cap.BUTT;
            } else if (TextUtils.equals(optString, "round")) {
                this.alV = Paint.Cap.ROUND;
            } else if (TextUtils.equals(optString, "square")) {
                this.alV = Paint.Cap.SQUARE;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alV != null) {
            bVar.mStrokePaint.setStrokeCap(this.alV);
        }
    }
}
