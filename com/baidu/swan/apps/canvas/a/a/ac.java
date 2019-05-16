package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ac extends a {
    private Paint.Join amo;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "bevel")) {
                this.amo = Paint.Join.BEVEL;
            } else if (TextUtils.equals(optString, "round")) {
                this.amo = Paint.Join.ROUND;
            } else if (TextUtils.equals(optString, "miter")) {
                this.amo = Paint.Join.MITER;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amo != null) {
            bVar.mStrokePaint.setStrokeJoin(this.amo);
        }
    }
}
