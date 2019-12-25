package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class ah extends a {
    private Paint.Align bbZ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, "left")) {
                    this.bbZ = Paint.Align.LEFT;
                } else if (TextUtils.equals(optString, "center")) {
                    this.bbZ = Paint.Align.CENTER;
                } else if (TextUtils.equals(optString, HorizontalTranslateLayout.RIGHT)) {
                    this.bbZ = Paint.Align.RIGHT;
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
        if (this.bbZ != null) {
            bVar.bbm.setTextAlign(this.bbZ);
        }
    }
}
