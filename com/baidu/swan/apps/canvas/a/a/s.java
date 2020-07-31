package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class s extends a {
    private RectF awY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int D = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(0));
                int D2 = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(1));
                this.awY = new RectF(D, D2, D + com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(2)), D2 + com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.awY != null) {
            bVar.mPath.addRect(this.awY, Path.Direction.CW);
        }
    }
}
