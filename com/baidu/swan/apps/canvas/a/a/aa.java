package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aa extends a {
    private Paint.Cap alU;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "butt")) {
                this.alU = Paint.Cap.BUTT;
            } else if (TextUtils.equals(optString, "round")) {
                this.alU = Paint.Cap.ROUND;
            } else if (TextUtils.equals(optString, "square")) {
                this.alU = Paint.Cap.SQUARE;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alU != null) {
            bVar.mStrokePaint.setStrokeCap(this.alU);
        }
    }
}
