package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class ai extends a {
    private int cCa = 0;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, VerticalTranslateLayout.TOP)) {
                    this.cCa = 1;
                } else if (TextUtils.equals(optString, "middle")) {
                    this.cCa = 2;
                } else if (TextUtils.equals(optString, VerticalTranslateLayout.BOTTOM)) {
                    this.cCa = 3;
                } else {
                    this.cCa = 0;
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
        bVar.cCa = this.cCa;
    }
}
