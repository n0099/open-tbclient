package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class ah extends a {
    private Paint.Align bFE;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, "left")) {
                    this.bFE = Paint.Align.LEFT;
                } else if (TextUtils.equals(optString, "center")) {
                    this.bFE = Paint.Align.CENTER;
                } else if (TextUtils.equals(optString, HorizontalTranslateLayout.DIRECTION_RIGHT)) {
                    this.bFE = Paint.Align.RIGHT;
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
        if (this.bFE != null) {
            bVar.bET.setTextAlign(this.bFE);
        }
    }
}
