package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ac extends a {
    private Paint.Join amc;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "bevel")) {
                this.amc = Paint.Join.BEVEL;
            } else if (TextUtils.equals(optString, "round")) {
                this.amc = Paint.Join.ROUND;
            } else if (TextUtils.equals(optString, "miter")) {
                this.amc = Paint.Join.MITER;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amc != null) {
            bVar.mStrokePaint.setStrokeJoin(this.amc);
        }
    }
}
