package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class aa extends a {
    private Paint.Cap cbQ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "butt")) {
                this.cbQ = Paint.Cap.BUTT;
            } else if (TextUtils.equals(optString, "round")) {
                this.cbQ = Paint.Cap.ROUND;
            } else if (TextUtils.equals(optString, "square")) {
                this.cbQ = Paint.Cap.SQUARE;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cbQ != null) {
            bVar.mStrokePaint.setStrokeCap(this.cbQ);
        }
    }
}
