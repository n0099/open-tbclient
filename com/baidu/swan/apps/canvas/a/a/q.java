package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class q extends a {
    private int aGl = Integer.MAX_VALUE;
    private int aGm = Integer.MAX_VALUE;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.aGl = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(0));
            this.aGm = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aGl != Integer.MAX_VALUE && this.aGm != Integer.MAX_VALUE) {
            bVar.mPath.moveTo(this.aGl, this.aGm);
        }
    }
}
