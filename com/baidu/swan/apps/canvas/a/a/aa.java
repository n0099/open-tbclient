package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aa extends a {
    private Paint.Cap ann;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "butt")) {
                this.ann = Paint.Cap.BUTT;
            } else if (TextUtils.equals(optString, "round")) {
                this.ann = Paint.Cap.ROUND;
            } else if (TextUtils.equals(optString, "square")) {
                this.ann = Paint.Cap.SQUARE;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.ann != null) {
            bVar.mStrokePaint.setStrokeCap(this.ann);
        }
    }
}
