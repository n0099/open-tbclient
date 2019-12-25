package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class s extends a {
    private RectF UG;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int T = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(0));
                int T2 = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(1));
                this.UG = new RectF(T, T2, T + com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(2)), T2 + com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.UG != null) {
            bVar.mPath.addRect(this.UG, Path.Direction.CW);
        }
    }
}
