package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class aa extends a {
    private Paint.Cap cCC;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "butt")) {
                this.cCC = Paint.Cap.BUTT;
            } else if (TextUtils.equals(optString, "round")) {
                this.cCC = Paint.Cap.ROUND;
            } else if (TextUtils.equals(optString, "square")) {
                this.cCC = Paint.Cap.SQUARE;
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cCC != null) {
            bVar.mStrokePaint.setStrokeCap(this.cCC);
        }
    }
}
