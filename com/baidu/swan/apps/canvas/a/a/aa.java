package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aa extends a {
    private Paint.Cap amP;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "butt")) {
                this.amP = Paint.Cap.BUTT;
            } else if (TextUtils.equals(optString, "round")) {
                this.amP = Paint.Cap.ROUND;
            } else if (TextUtils.equals(optString, "square")) {
                this.amP = Paint.Cap.SQUARE;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amP != null) {
            bVar.mStrokePaint.setStrokeCap(this.amP);
        }
    }
}
