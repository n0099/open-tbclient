package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class ah extends a {
    private Paint.Align cHW;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, "left")) {
                    this.cHW = Paint.Align.LEFT;
                } else if (TextUtils.equals(optString, "center")) {
                    this.cHW = Paint.Align.CENTER;
                } else if (TextUtils.equals(optString, HorizontalTranslateLayout.DIRECTION_RIGHT)) {
                    this.cHW = Paint.Align.RIGHT;
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cHW != null) {
            bVar.cHi.setTextAlign(this.cHW);
        }
    }
}
