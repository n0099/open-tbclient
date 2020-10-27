package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class ac extends a {
    private Paint.Join cwL;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "bevel")) {
                this.cwL = Paint.Join.BEVEL;
            } else if (TextUtils.equals(optString, "round")) {
                this.cwL = Paint.Join.ROUND;
            } else if (TextUtils.equals(optString, "miter")) {
                this.cwL = Paint.Join.MITER;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cwL != null) {
            bVar.mStrokePaint.setStrokeJoin(this.cwL);
        }
    }
}
