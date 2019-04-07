package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ac extends a {
    private Paint.Join amb;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "bevel")) {
                this.amb = Paint.Join.BEVEL;
            } else if (TextUtils.equals(optString, "round")) {
                this.amb = Paint.Join.ROUND;
            } else if (TextUtils.equals(optString, "miter")) {
                this.amb = Paint.Join.MITER;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amb != null) {
            bVar.mStrokePaint.setStrokeJoin(this.amb);
        }
    }
}
