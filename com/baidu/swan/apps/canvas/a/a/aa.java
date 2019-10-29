package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aa extends a {
    private Paint.Cap aGF;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "butt")) {
                this.aGF = Paint.Cap.BUTT;
            } else if (TextUtils.equals(optString, "round")) {
                this.aGF = Paint.Cap.ROUND;
            } else if (TextUtils.equals(optString, "square")) {
                this.aGF = Paint.Cap.SQUARE;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aGF != null) {
            bVar.mStrokePaint.setStrokeCap(this.aGF);
        }
    }
}
