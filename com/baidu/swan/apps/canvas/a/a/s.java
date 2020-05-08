package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class s extends a {
    private RectF aoX;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int C = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(0));
                int C2 = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(1));
                this.aoX = new RectF(C, C2, C + com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(2)), C2 + com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aoX != null) {
            bVar.mPath.addRect(this.aoX, Path.Direction.CW);
        }
    }
}
