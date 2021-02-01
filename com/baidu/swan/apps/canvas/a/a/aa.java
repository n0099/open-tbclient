package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class aa extends a {
    private Paint.Cap cKk;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "butt")) {
                this.cKk = Paint.Cap.BUTT;
            } else if (TextUtils.equals(optString, "round")) {
                this.cKk = Paint.Cap.ROUND;
            } else if (TextUtils.equals(optString, "square")) {
                this.cKk = Paint.Cap.SQUARE;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cKk != null) {
            bVar.mStrokePaint.setStrokeCap(this.cKk);
        }
    }
}
